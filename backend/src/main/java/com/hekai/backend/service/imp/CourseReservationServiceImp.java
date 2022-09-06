package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseReservationDto;
import com.hekai.backend.entity.Course;
import com.hekai.backend.entity.CourseReservation;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.Store;
import com.hekai.backend.repository.CourseRepository;
import com.hekai.backend.repository.CourseReservationRepository;
import com.hekai.backend.repository.EmployeeUserRepository;
import com.hekai.backend.repository.StoreRepository;
import com.hekai.backend.service.CourseReservationService;
import com.hekai.backend.utils.DateFormatUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseReservationServiceImp implements CourseReservationService {
    @Autowired
    private CourseReservationRepository courseReservationRepository;
    @Autowired
    private EmployeeUserRepository employeeUserRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ServerResponse<Page<CourseReservationDto>> getCourseReservationListPageable(EmployeeUser curUser, Pageable pageable) {
        EmployeeUser operator=employeeUserRepository.findEmployeeUserById(curUser.getId());
        if(operator.getStoreId()==null){
            return ServerResponse.createByErrorMessage("您不属于任何商店，因此无法查看课程安排，请联系管理员为您分配商店！");
        }
        Page<CourseReservation> courseReservationPage=courseReservationRepository.findAllByStoreId(operator.getStoreId(),pageable);
        List<CourseReservationDto> courseReservationDtoList=courseReservationListToCourseReservationDtoList(courseReservationPage.getContent());
        Page<CourseReservationDto> result=new PageImpl<>(courseReservationDtoList,courseReservationPage.getPageable(),courseReservationPage.getTotalElements());
        return ServerResponse.createRespBySuccess(result);

    }

    @Override
    public ServerResponse<String> deleteReservation(Integer reservationId) {
        CourseReservation courseReservation=courseReservationRepository.findCourseReservationById(reservationId);
        if(courseReservation==null){
            return ServerResponse.createByErrorMessage("该课程安排不存在！");
        }
        courseReservationRepository.delete(courseReservation);
        return ServerResponse.createRespBySuccess("删除成功！");
    }

    private CourseReservationDto courseReservationToCourseReservationDto(CourseReservation courseReservation){
        CourseReservationDto courseReservationDto=modelMapper.map(courseReservation,CourseReservationDto.class);
        Course course=courseRepository.findCourseById(courseReservation.getCourseId());
        courseReservationDto.setCourseName(course.getCourseName());
        Store store=storeRepository.findStoreById(course.getId());
        courseReservationDto.setStoreName(store.getStoreName());
        courseReservationDto.setDate(DateFormatUtil.formatTimeNoSecond(courseReservation.getDate()));
        courseReservationDto.setBeginTime(DateFormatUtil.formatTimeNoSecond(courseReservation.getBeginTime()));
        courseReservationDto.setEndTime(DateFormatUtil.formatTimeNoSecond(courseReservation.getEndTime()));
        courseReservationDto.setOperateTime(DateFormatUtil.formatTimeNoSecond(courseReservation.getOperateTime()));
        return courseReservationDto;
    }
    private List<CourseReservationDto> courseReservationListToCourseReservationDtoList(List<CourseReservation> courseReservationList){
        List<CourseReservationDto> courseReservationDtoList=new ArrayList<>();
        for(CourseReservation courseReservation:courseReservationList){
            courseReservationDtoList.add(courseReservationToCourseReservationDto(courseReservation));
        }
        return courseReservationDtoList;
    }
}
