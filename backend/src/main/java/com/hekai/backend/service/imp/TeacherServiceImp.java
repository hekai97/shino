package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.TeacherDto;
import com.hekai.backend.entity.CourseTable;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.Store;
import com.hekai.backend.entity.Teacher;
import com.hekai.backend.repository.CourseTableRepository;
import com.hekai.backend.repository.StoreRepository;
import com.hekai.backend.repository.TeacherRepository;
import com.hekai.backend.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CourseTableRepository courseTableRepository;
    @Override
    public ServerResponse<Page<TeacherDto>> getTeacherListPageable(Pageable pageable) {
        Page<Teacher> teachers=teacherRepository.findAll(pageable);
        List<Store> storeList=storeRepository.findAll();
        Map<Integer,String> storeMap=new HashMap<>();
        //map存储，可以直接在内存中读取，防止每次都去数据库读，造成性能损失
        for(Store store:storeList){
            storeMap.put(store.getId(),store.getStoreName());
        }
        List<Teacher> teacherList=teachers.getContent();
        List<TeacherDto> teacherDtos=new ArrayList<>();
        for(Teacher teacher:teacherList){
            TeacherDto teacherDto=modelMapper.map(teacher,TeacherDto.class);
            teacherDto.setStoreName(storeMap.get(teacherDto.getStoreId()));
            teacherDtos.add(teacherDto);
        }
        Page<TeacherDto> result=new PageImpl<>(teacherDtos,teachers.getPageable(),teachers.getTotalElements());
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<TeacherDto> getTeacherByNumber(String number) {
        Teacher teacher=teacherRepository.findTeacherByNumber(number);
        if(teacher==null){
            return ServerResponse.createByErrorMessage("该老师不存在");
        }
        TeacherDto teacherDto=modelMapper.map(teacher,TeacherDto.class);
        teacherDto.setStoreName(storeRepository.findStoreById(teacherDto.getStoreId()).getStoreName());
        return ServerResponse.createRespBySuccess(teacherDto);
    }

    @Override
    public ServerResponse<TeacherDto> getTeacherById(Integer id) {
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            return ServerResponse.createByErrorMessage("该老师不存在");
        }
        TeacherDto teacherDto=modelMapper.map(teacher,TeacherDto.class);
        teacherDto.setStoreName(storeRepository.findStoreById(teacherDto.getStoreId()).getStoreName());
        return ServerResponse.createRespBySuccess(teacherDto);
    }

    @Override
    public ServerResponse<Teacher> save(EmployeeUser operator, Teacher teacher) {
        if(teacher.getNumber()==null){
            return ServerResponse.createByErrorMessage("必须给老师设置编号！");
        }
        if(teacherRepository.findTeacherByNumber(teacher.getNumber())!=null){
            return ServerResponse.createByErrorMessage("该编号已经存在！");
        }
        if(teacher.getName()==null){
            return ServerResponse.createByErrorMessage("必须给老师设置姓名！");
        }
        if(teacher.getStoreId()==null){
            return ServerResponse.createByErrorMessage("必须给老师设置所属门店！");
        }
        if(storeRepository.findStoreById(teacher.getStoreId())==null){
            return ServerResponse.createByErrorMessage("该门店不存在！");
        }
        if(teacher.getStatus()==null){
            teacher.setStatus(1);
        }
        teacher.setCreatedDate(new Date(System.currentTimeMillis()));
        teacher.setCreatedUserNumber(operator.getNumber());
        teacher.setEntryDate(new Date(System.currentTimeMillis()));
        Teacher result = teacherRepository.save(teacher);
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<Teacher> updateTeacher(Teacher teacher) {
        if(teacher.getId()==null){
            return ServerResponse.createByErrorMessage("必须给老师设置id！");
        }
        Teacher oldTeacher=teacherRepository.findTeacherById(teacher.getId());
        if(teacherRepository.findTeacherByNumber(teacher.getNumber())!=null&&!teacher.getNumber().equals(oldTeacher.getNumber())){
            return ServerResponse.createByErrorMessage("该编号已经存在！");
        }
        if(teacher.getAddress()!=null){
            oldTeacher.setAddress(teacher.getAddress());
        }
        if(teacher.getBirthday()!=null){
            oldTeacher.setBirthday(teacher.getBirthday());
        }
        if(teacher.getDescription()!=null){
            oldTeacher.setDescription(teacher.getDescription());
        }
        if(teacher.getStoreId()!=null){
            oldTeacher.setStoreId(teacher.getStoreId());
        }
        if(teacher.getName()!=null){
            oldTeacher.setName(teacher.getName());
        }
        if(teacher.getEmail()!=null){
            oldTeacher.setEmail(teacher.getEmail());
        }
        if(teacher.getFeature()!=null){
            oldTeacher.setFeature(teacher.getFeature());
        }
        if(teacher.getLeaveDate()!=null){
            oldTeacher.setLeaveDate(teacher.getLeaveDate());
        }
        if(teacher.getPhone()!=null){
            oldTeacher.setPhone(teacher.getPhone());
        }
        if(teacher.getPictureUrl()!=null){
            oldTeacher.setPictureUrl(teacher.getPictureUrl());
        }
        if(teacher.getSex()!=null){
            oldTeacher.setSex(teacher.getSex());
        }
        if(teacher.getStatus()!=null){
            oldTeacher.setStatus(teacher.getStatus());
        }
        if(teacher.getGoodCategory()!=null){
            oldTeacher.setGoodCategory(teacher.getGoodCategory());
        }
        Teacher teacher1=teacherRepository.save(oldTeacher);
        return ServerResponse.createRespBySuccess(teacher1);
    }

    @Override
    public ServerResponse<List<Teacher>> getTeachersByStoreId(Integer storeId) {
        List<Teacher> teachers=teacherRepository.findTeachersByStoreId(storeId);
        return ServerResponse.createRespBySuccess(teachers);
    }

    @Override
    public ServerResponse<String> deleteTeacherByNumber(String number) {
        if(teacherRepository.findTeacherByNumber(number)==null){
            return ServerResponse.createByErrorMessage("该老师不存在！");
        }
        Teacher teacher=teacherRepository.findTeacherByNumber(number);
        if(teacher.getStatus()==0){
            return ServerResponse.createByErrorMessage("该老师已经离职！");
        }
        List<CourseTable> courseTables=courseTableRepository.findCourseTablesByTeacherId(teacher.getId());
        if(courseTables.size()!=0){
            return ServerResponse.createByErrorMessage("该老师还有课程安排，不能删除！");
        }
        teacherRepository.delete(teacher);
        return ServerResponse.createRespBySuccessMessage("删除成功！");
    }
}
