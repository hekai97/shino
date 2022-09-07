package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseTableDto;
import com.hekai.backend.entity.CourseTable;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.repository.*;
import com.hekai.backend.service.CourseTableService;
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
public class CourseTableServiceImp implements CourseTableService {
    @Autowired
    private CourseTableRepository courseTableRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private EmployeeUserRepository employeeUserRepository;

    @Override
    public ServerResponse<Page<CourseTableDto>> getAllSchedulingPageable(EmployeeUser curUser, Pageable pageable) {
        EmployeeUser operator=employeeUserRepository.findEmployeeUserById(curUser.getId());
        if(operator.getStoreId()==null){
            return ServerResponse.createByErrorMessage("您不属于任何商店，因此无法查看课程安排，请联系管理员为您分配商店！");
        }
        Page<CourseTable> courseTablePage=courseTableRepository.findAllByStoreId(operator.getStoreId(),pageable);
        List<CourseTableDto> courseTableDtoList=courseTableListToCourseTableDtoList(courseTablePage.getContent());
        Page<CourseTableDto> result=new PageImpl<>(courseTableDtoList,courseTablePage.getPageable(),courseTablePage.getTotalElements());
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<CourseTableDto> getSchedulingDetailById(EmployeeUser curUser, Integer id) {
        EmployeeUser operator=employeeUserRepository.findEmployeeUserById(curUser.getId());
        if(operator.getStoreId()==null){
            return ServerResponse.createByErrorMessage("您不属于任何商店，因此无法查看课程安排，请联系管理员为您分配商店！");
        }
        CourseTable courseTable=courseTableRepository.findCourseTableById(id);
        if(courseTable==null){
            return ServerResponse.createByErrorMessage("该课程安排不存在！");
        }
        if(!courseTable.getStoreId().equals(operator.getStoreId())){
            return ServerResponse.createByErrorMessage("您无权查看该课程安排！");
        }
        CourseTableDto courseTableDto=courseTableToCourseTableDto(courseTable);
        return ServerResponse.createRespBySuccess(courseTableDto);
    }

    @Override
    public ServerResponse<CourseTableDto> createScheduling(CourseTable courseTable) {
        courseTable.setCreateTime(new Timestamp(new Date().getTime()));
        CourseTable courseTable1=courseTableRepository.save(courseTable);
        return ServerResponse.createRespBySuccess(courseTableToCourseTableDto(courseTable1));
    }

    @Override
    public ServerResponse<String> deleteCourseTableById(Integer courseTableId) {
        CourseTable courseTable=courseTableRepository.findCourseTableById(courseTableId);
        if(courseTable==null){
            return ServerResponse.createByErrorMessage("该课程安排不存在！");
        }
        courseTableRepository.delete(courseTable);
        return ServerResponse.createRespBySuccess("删除成功！");
    }

    @Override
    public ServerResponse<CourseTableDto> updateCourseTable(CourseTable courseTable) {
        CourseTable courseTable1=courseTableRepository.findCourseTableById(courseTable.getId());
        if(courseTable1==null){
            return ServerResponse.createByErrorMessage("该课程安排不存在！");
        }
        courseTableRepository.save(courseTable);
        return ServerResponse.createRespBySuccess(courseTableToCourseTableDto(courseTable));
    }

    private CourseTableDto courseTableToCourseTableDto(CourseTable courseTable) {
        CourseTableDto courseTableDto = modelMapper.map(courseTable, CourseTableDto.class);
        courseTableDto.setCourseName(courseRepository.findCourseById(courseTable.getCourseId()).getCourseName());
        courseTableDto.setStoreName(storeRepository.findStoreById(courseTable.getStoreId()).getStoreName());
        courseTableDto.setTeacherName(teacherRepository.findTeacherById(courseTable.getTeacherId()).getName());
        courseTableDto.setUserName(userRepository.findUserById(courseTable.getUserId()).getName());
        courseTableDto.setCreateTime(DateFormatUtil.formatTimeNoSecond(courseTable.getCreateTime()));
        courseTableDto.setReservationDate(DateFormatUtil.formatDate(courseTable.getReservationDate()));
        return courseTableDto;
    }
    private List<CourseTableDto> courseTableListToCourseTableDtoList(List<CourseTable> courseTableList) {
        List<CourseTableDto> courseTableDtoList=new ArrayList<>();
        for(CourseTable c:courseTableList){
            courseTableDtoList.add(courseTableToCourseTableDto(c));
        }
        return courseTableDtoList;
    }
}
