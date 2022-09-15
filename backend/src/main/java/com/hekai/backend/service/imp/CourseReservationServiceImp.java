package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseRankingDto;
import com.hekai.backend.dto.CourseReservationDto;
import com.hekai.backend.entity.*;
import com.hekai.backend.repository.*;
import com.hekai.backend.service.CourseReservationService;
import com.hekai.backend.utils.ConstUtil;
import com.hekai.backend.utils.DateFormatUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderDetailRepository detailRepository;
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

    @Override
    public ServerResponse<List<CourseReservationDto>> getReservations(Integer userId) {
        List<OrderItem> userOrderItems=orderItemRepository.findOrderItemsByUserId(userId);
        List<CourseReservationDto> result=new ArrayList<>();
        for(OrderItem orderItem:userOrderItems){
            CourseReservation courseReservation=courseReservationRepository.findCourseReservationById(orderItem.getId());
            if(courseReservation!=null){
                result.add(modelMapper.map(courseReservation,CourseReservationDto.class));
            }
        }
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<CourseReservationDto> createReservation(User user, CourseReservation courseReservation) {
        Course course=courseRepository.findCourseById(courseReservation.getCourseId());
        if(course==null){
            return ServerResponse.createByErrorMessage("该课程不存在！");
        }
        Store store=storeRepository.findStoreById(courseReservation.getStoreId());
        if(store==null){
            return ServerResponse.createByErrorMessage("该商店不存在！");
        }
        OrderItem orderItem=orderItemRepository.findOrderItemById(courseReservation.getOrderId());
        if(orderItem==null){
            return ServerResponse.createByErrorMessage("该订单不存在！");
        }
        courseReservation.setOperateTime(new Timestamp(new Date().getTime()));
        CourseReservation result=courseReservationRepository.save(courseReservation);
        return ServerResponse.createRespBySuccess(courseReservationToCourseReservationDto(result));
    }

    @Override
    public ServerResponse<String> cancelReservation(Integer courseReservationId) {
        CourseReservation courseReservation=courseReservationRepository.findCourseReservationById(courseReservationId);
        if(courseReservation==null){
            return ServerResponse.createByErrorMessage("该课程安排不存在！");
        }
        courseReservationRepository.delete(courseReservation);
        return ServerResponse.createRespBySuccess("取消成功！");
    }

    @Override
    public ServerResponse<List<CourseRankingDto>> getCourseRanking() {
        List<Object[]> courseRankingList=courseReservationRepository.findCourseRankingCount();
        List<CourseRankingDto> result=new ArrayList<>();
        for(Object[] courseRanking:courseRankingList){
            CourseRankingDto courseRankingDto=new CourseRankingDto();
            courseRankingDto.setCourseId(Integer.valueOf(courseRanking[0].toString()));
            courseRankingDto.setCourseName(courseRepository.findCourseById(courseRankingDto.getCourseId()).getCourseName());
            courseRankingDto.setCount(Integer.valueOf(courseRanking[1].toString()));
            result.add(courseRankingDto);
        }

        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<BigDecimal> getCourseCategoryIncomeByCategoryId(Integer categoryId) {
        List<Course> courseList=courseRepository.findAllByCourseCategoryId(categoryId);
        BigDecimal result=new BigDecimal(0);
        List<Integer> courseIdList=new ArrayList<>();
        for(Course course:courseList){
            courseIdList.add(course.getId());
        }
        List<OrderDetail> orderDetailList=detailRepository.findAllByCourseIdIn(courseIdList);
        for(OrderDetail orderDetail:orderDetailList){
            if(orderItemRepository.findOrderItemById(orderDetail.getOrderId()).getStatus() != ConstUtil.OrderStatus.UNPAID){
                result=result.add(orderDetail.getPrice());
            }
        }
        return ServerResponse.createRespBySuccess(result);
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
