package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderItemDto;
import com.hekai.backend.entity.Course;
import com.hekai.backend.entity.OrderDetail;
import com.hekai.backend.entity.OrderItem;
import com.hekai.backend.repository.*;
import com.hekai.backend.service.OrderService;
import com.hekai.backend.utils.ConstUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseCategoryRepository courseCategoryRepository;
    @Override
    public ServerResponse<Page<OrderItemDto>> getOrderListPageable(Pageable pageable) {
        Page<OrderItem> orderItemPage=orderItemRepository.findAll(pageable);
        List<OrderItem> orderItemList=orderItemPage.getContent();
        List<OrderItemDto> orderItemDtos=new ArrayList<>();
        for(OrderItem o:orderItemList){
            OrderItemDto orderItemDto=modelMapper.map(o,OrderItemDto.class);
            orderItemDto.setStatusDesc(ConstUtil.OrderStatus.getStatusDesc(orderItemDto.getStatus()));
            orderItemDto.setUsername(userRepository.findUserById(orderItemDto.getUserId()).getUsername());
            orderItemDtos.add(orderItemDto);
        }
        Page<OrderItemDto> result=new PageImpl<>(orderItemDtos,orderItemPage.getPageable(),orderItemPage.getTotalElements());
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<List<OrderDetailDto>> getOrderDetailByOrderNumber(String orderNumber) {
        OrderItem orderItem=orderItemRepository.findOrderItemByOrderNumber(orderNumber);
        List<OrderDetail> orderDetailList=orderDetailRepository.findOrderDetailsByOrderId(orderItem.getId());
        List<OrderDetailDto> orderDetailDtoList=new ArrayList<>();
        for(OrderDetail o:orderDetailList){
            OrderDetailDto orderDetailDto=modelMapper.map(o,OrderDetailDto.class);
            orderDetailDto.setCourseType(ConstUtil.CourseType.getCourseTypeDesc(orderDetailDto.getCourseTypeId()));
            Course course=courseRepository.findCourseById(orderDetailDto.getCourseId());
            orderDetailDto.setCourseName(course.getCourseName());
            orderDetailDto.setCategoryName(courseCategoryRepository.findCourseCategoryById(course.getCourseCategoryId()).getCategoryName());
            orderDetailDtoList.add(orderDetailDto);
        }
        return ServerResponse.createRespBySuccess(orderDetailDtoList);
    }
}
