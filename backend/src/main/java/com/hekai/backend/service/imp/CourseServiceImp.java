package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseDto;
import com.hekai.backend.entity.*;
import com.hekai.backend.repository.CourseCategoryRepository;
import com.hekai.backend.repository.CourseRepository;
import com.hekai.backend.repository.RelationStoreCourseRepository;
import com.hekai.backend.service.CourseService;
import com.hekai.backend.utils.ConstUtil;
import com.hekai.backend.utils.DateFormatUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseCategoryRepository courseCategoryRepository;
    @Autowired
    private RelationStoreCourseRepository relationStoreCourseRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ServerResponse<Page<CourseDto>> getAllCoursePageable(Pageable pageable) {
        Page<Course> coursePage=courseRepository.findAll(pageable);
        List<Course> courseList=coursePage.getContent();
        List<CourseDto> courseDtos=courseListToCourseDtoList(courseList);
        Page<CourseDto> result=new PageImpl<>(courseDtos,coursePage.getPageable(),coursePage.getTotalElements());
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<Page<CourseDto>> getCoursesPageableByCategoryId(Pageable pageable,Integer categoryId) {
        Page<Course> coursePage=courseRepository.findCoursesByCourseCategoryId(pageable,categoryId);
        List<CourseDto> courseDtos=courseListToCourseDtoList(coursePage.getContent());
        Page<CourseDto> result=new PageImpl<>(courseDtos,coursePage.getPageable(),coursePage.getTotalElements());
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<List<CourseDto>> getCourseList() {
        List<Course> courseList=courseRepository.findAll();
        List<CourseDto> courseDtoList=courseListToCourseDtoList(courseList);
        return ServerResponse.createRespBySuccess(courseDtoList);
    }

    @Override
    public ServerResponse<Course> createCourse(EmployeeUser operator, Course course) {
        if(course.getCourseCategoryId()==null){
            return ServerResponse.createByErrorMessage("请选择课程分类！");
        }
        if(course.getCourseNumber()==null){
            return ServerResponse.createByErrorMessage("请输入课程编号！");
        }
        if(course.getCourseName()==null){
            return ServerResponse.createByErrorMessage("请输入课程名字！");
        }
        Course isExistCourse=courseRepository.findCourseByCourseNumber(course.getCourseNumber());
        if(isExistCourse!=null){
            return ServerResponse.createByErrorMessage("该课程已存在，请修改课程号！");
        }
        course.setCreator(operator.getName());
        course.setCreatedTime(new Timestamp(new Date().getTime()));
        if(course.getCourseTypeId()==null){
            course.setCourseTypeId(0);
        }
        return ServerResponse.createRespBySuccess(courseRepository.save(course));
    }

    @Override
    public ServerResponse<Course> updateCourseInfo(EmployeeUser operator,Course course) {
        course.setUpdater(operator.getName());
        course.setUpdatedTime(new Timestamp(new Date().getTime()));
        return ServerResponse.createRespBySuccess(courseRepository.save(course));
    }

    @Override
    public ServerResponse<String> deleteCourseByNumber(EmployeeUser curUser, String courseNumber) {
        Course course=courseRepository.findCourseByCourseNumber(courseNumber);
        courseRepository.delete(course);
        return ServerResponse.createRespBySuccessMessage("删除课程成功！");
    }

    @Override
    public ServerResponse<Course> getCourseDetail(Integer id) {
        Course course=courseRepository.findCourseById(id);
        return ServerResponse.createRespBySuccess(course);
    }

    @Override
    public ServerResponse<List<Course>> getUserPurchasedCourseList(int id) {
        return null;
    }

    @Override
    public ServerResponse<List<CourseCategory>> getAllCourseCategory() {
        return ServerResponse.createRespBySuccess(courseCategoryRepository.findAll());
    }

    @Override
    public ServerResponse<List<CourseDto>> getRandomCourse(int number) {
        List<Course> courseList=courseRepository.findAll();
        Map<Integer,Boolean> map=new HashMap<>();
        List<CourseDto> res=new ArrayList<>();
        for(int i=0;i<number;i++){
            int index=(int)(Math.random()*courseList.size());
            while(map.get(index)!=null){
                index=(int)(Math.random()*courseList.size());
            }
            map.put(index,true);
            Course course=courseList.get(index);
            CourseDto courseDto=courseToCourseDto(course);
            res.add(courseDto);
        }
        return ServerResponse.createRespBySuccess(res);
    }

    @Override
    public ServerResponse<Page<CourseDto>> getCoursesPageableByStoreId(Pageable pageable, Integer storeId) {
        List<RelationStoreCourse> relationStoreCourseList=relationStoreCourseRepository.findRelationStoreCoursesByStoreId(storeId);
        List<Integer> courseIdList=new ArrayList<>();
        for(RelationStoreCourse relationStoreCourse:relationStoreCourseList){
            courseIdList.add(relationStoreCourse.getCourseId());
        }
        Page<Course> coursePage=courseRepository.findCoursesByIdIn(pageable,courseIdList);
        List<CourseDto> courseDtoList=courseListToCourseDtoList(coursePage.getContent());
        Page<CourseDto> result=new PageImpl<>(courseDtoList,coursePage.getPageable(),coursePage.getTotalElements());
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<List<Course>> getCoursesNotInStore() {
        List<RelationStoreCourse> relationStoreCourseList=relationStoreCourseRepository.findAll();
        List<Integer> courseIdList=new ArrayList<>();
        for(RelationStoreCourse relationStoreCourse:relationStoreCourseList){
            courseIdList.add(relationStoreCourse.getCourseId());
        }
        List<Course> courseList=courseRepository.findCoursesByIdNotIn(courseIdList);
        return ServerResponse.createRespBySuccess(courseList);
    }

    @Override
    public ServerResponse<String> setCourseToStore(String courseNumber, Integer storeId) {
        Course course=courseRepository.findCourseByCourseNumber(courseNumber);
        RelationStoreCourse relationStoreCourse=new RelationStoreCourse();
        relationStoreCourse.setCourseId(course.getId());
        relationStoreCourse.setStoreId(storeId);
        relationStoreCourseRepository.save(relationStoreCourse);
        return ServerResponse.createRespBySuccessMessage("设置课程成功！");
    }

    @Override
    public ServerResponse<String> deleteCourseFromStore(String courseNumber, Integer storeId) {
        Course course=courseRepository.findCourseByCourseNumber(courseNumber);
        RelationStoreCourse relationStoreCourse=relationStoreCourseRepository.findRelationStoreCourseByCourseIdAndStoreId(course.getId(),storeId);
        relationStoreCourseRepository.delete(relationStoreCourse);
        return ServerResponse.createRespBySuccessMessage("删除课程成功！");
    }

    @Override
    public ServerResponse<String> addCourseCategory(Integer id, CourseCategory courseCategory) {
        CourseCategory isExistCourseCategory=courseCategoryRepository.findCourseCategoryByCategoryName(courseCategory.getCategoryName());
        if(isExistCourseCategory!=null){
            return ServerResponse.createByErrorMessage("该课程分类已存在！");
        }
        courseCategory.setCreatedId(id);
        courseCategory.setCreateTime(new Timestamp(new Date().getTime()));
        courseCategoryRepository.save(courseCategory);
        return ServerResponse.createRespBySuccessMessage("添加课程分类成功！");
    }

    @Override
    public ServerResponse<String> updateCourseCategory(CourseCategory courseCategory) {
        if(courseCategory.getId()==null){
            return ServerResponse.createByErrorMessage("请输入课程分类id！");
        }
        courseCategoryRepository.save(courseCategory);
        return ServerResponse.createRespBySuccessMessage("修改课程分类成功！");
    }

    @Override
    public ServerResponse<String> deleteCourseCategory(Integer categoryId) {
        if(courseRepository.findAllByCourseCategoryId(categoryId).size()>0){
            return ServerResponse.createByErrorMessage("该课程分类下存在课程，无法删除！");
        }
        courseCategoryRepository.deleteById(categoryId);
        return ServerResponse.createRespBySuccessMessage("删除课程分类成功！");
    }


    private List<CourseDto> courseListToCourseDtoList(List<Course> courses){
        List<CourseDto> courseDtos=new ArrayList<>();
        for(Course c:courses){
            courseDtos.add(courseToCourseDto(c));
        }
        return courseDtos;
    }
    private CourseDto courseToCourseDto(Course c){
        CourseDto courseDto=modelMapper.map(c,CourseDto.class);
        courseDto.setCourseCategoryName(courseCategoryRepository.findCourseCategoryById(c.getCourseCategoryId()).getCategoryName());
        courseDto.setCourseTypeName(ConstUtil.CourseType.getCourseTypeDesc(c.getCourseTypeId()));
        courseDto.setCreatedTime(DateFormatUtil.formatTimeNoSecond(c.getCreatedTime()));
        courseDto.setUpdatedTime(DateFormatUtil.formatTimeNoSecond(c.getUpdatedTime()));
        return courseDto;
    }
}
