package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseDto;
import com.hekai.backend.entity.Course;
import com.hekai.backend.entity.CourseCategory;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.Store;
import com.hekai.backend.repository.CourseCategoryRepository;
import com.hekai.backend.repository.CourseRepository;
import com.hekai.backend.repository.StoreRepository;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseCategoryRepository courseCategoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StoreRepository storeRepository;
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
    public ServerResponse<List<Store>> getStoreList() {
        return ServerResponse.createRespBySuccess(storeRepository.findAll());
    }

    @Override
    public ServerResponse<Store> getStoreByStoreNumber(String storeNumber) {
        return ServerResponse.createRespBySuccess(storeRepository.findStoreByStoreNumber(storeNumber));
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
        courseDto.setCreatedTime(DateFormatUtil.formatTime(c.getCreatedTime()));
        courseDto.setUpdatedTime(DateFormatUtil.formatTime(c.getUpdatedTime()));
        return courseDto;
    }
}
