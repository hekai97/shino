package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderItemDto;
import com.hekai.backend.entity.Course;
import com.hekai.backend.entity.CoursePackage;
import com.hekai.backend.entity.OrderDetail;
import com.hekai.backend.entity.OrderItem;
import com.hekai.backend.repository.*;
import com.hekai.backend.service.OrderService;
import com.hekai.backend.utils.ConstUtil;
import com.hekai.backend.utils.UUIDUtil;
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
    @Autowired
    private CoursePackageRepository coursePackageRepository;
    @Override
    public ServerResponse<Page<OrderItemDto>> getOrderListPageable(Pageable pageable) {
        Page<OrderItem> orderItemPage=orderItemRepository.findAll(pageable);
        List<OrderItem> orderItemList=orderItemPage.getContent();
        List<OrderItemDto> orderItemDtos=orderItemListToOrderItemDtoList(orderItemList);
        Page<OrderItemDto> result=new PageImpl<>(orderItemDtos,orderItemPage.getPageable(),orderItemPage.getTotalElements());
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<List<OrderDetailDto>> getOrderDetailByOrderNumber(String orderNumber) {
        OrderItem orderItem=orderItemRepository.findOrderItemByOrderNumber(orderNumber);
        List<OrderDetail> orderDetailList=orderDetailRepository.findOrderDetailsByOrderId(orderItem.getId());
        List<OrderDetailDto> orderDetailDtoList=orderDetailListToOrderDetailDtoList(orderDetailList);
        return ServerResponse.createRespBySuccess(orderDetailDtoList);
    }

    @Override
    public ServerResponse<List<OrderItemDto>> getUserOrderList(Integer id) {
        List<OrderItem> orderItemList=orderItemRepository.findOrderItemsByUserId(id);
        List<OrderItemDto> orderItemDtoList=orderItemListToOrderItemDtoList(orderItemList);
        return ServerResponse.createRespBySuccess(orderItemDtoList);
    }

    @Override
    public ServerResponse<List<OrderDetailDto>> getUserOrderDetailByOrderNumber(String orderNumber) {
        OrderItem orderItem=orderItemRepository.findOrderItemByOrderNumber(orderNumber);
        List<OrderDetail> orderDetailList=orderDetailRepository.findOrderDetailsByOrderId(orderItem.getId());
        List<OrderDetailDto> orderDetailDtoList=orderDetailListToOrderDetailDtoList(orderDetailList);
        return ServerResponse.createRespBySuccess(orderDetailDtoList);
    }

    @Override
    public ServerResponse<OrderItemDto> createOrder(Integer userId, Integer id, Integer type) {
        OrderItem orderItem=new OrderItem();
        if(type==0){
            Course course=courseRepository.findCourseById(id);
            orderItem.setOrderNumber(UUIDUtil.generationOrderNumber());
            orderItem.setUserId(userId);
            orderItem.setTotalAmount(course.getCoursePrice());
            orderItem.setCreatedTime(new Timestamp(new Date().getTime()));
            orderItem.setStatus(ConstUtil.OrderStatus.UNPAID);
            orderItemRepository.save(orderItem);
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setOrderId(orderItem.getId());
            orderDetail.setCourseId(course.getId());
            orderDetail.setCourseTypeId(type);
            orderDetail.setPrice(course.getCoursePrice());
            orderDetailRepository.save(orderDetail);
        }else{
            List<CoursePackage> coursePackageList=coursePackageRepository.findCoursePackagesByPackageId(id);
            orderItem.setOrderNumber(UUIDUtil.generationOrderNumber());
            orderItem.setUserId(userId);
            orderItem.setTotalAmount(BigDecimal.ZERO);
            for(CoursePackage cp:coursePackageList){
                Course course=courseRepository.findCourseById(cp.getCourseId());
                OrderDetail orderDetail=new OrderDetail();
                orderDetail.setOrderId(orderItem.getId());
                orderDetail.setCourseId(course.getId());
                orderDetail.setCourseTypeId(type);
                orderDetail.setPrice(course.getCoursePrice());
                orderDetailRepository.save(orderDetail);
                orderItem.setTotalAmount(orderItem.getTotalAmount().add(course.getCoursePrice()));
            }
            orderItem.setCreatedTime(new Timestamp(new Date().getTime()));
            orderItem.setStatus(ConstUtil.OrderStatus.UNPAID);
            orderItemRepository.save(orderItem);
        }
        return ServerResponse.createRespBySuccess(orderItmToOrderItemDto(orderItem));
    }

    @Override
    public ServerResponse<OrderItemDto> cancelOrder(int userId, String orderNo) {
        OrderItem orderItem=orderItemRepository.findOrderItemByOrderNumber(orderNo);
        if(orderItem.getUserId()!=userId){
            return ServerResponse.createByErrorMessage("这不是你的订单，你不能取消！");
        }
        if(orderItem.getStatus()!=ConstUtil.OrderStatus.UNPAID){
            return ServerResponse.createByErrorMessage("订单已付款，无法取消！");
        }
        orderItem.setStatus(ConstUtil.OrderStatus.CLOSED);
        orderItemRepository.save(orderItem);
        return ServerResponse.createRespBySuccessMessage("成功取消订单！");
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private OrderItemDto orderItmToOrderItemDto(OrderItem orderItem){
        OrderItemDto orderItemDto=modelMapper.map(orderItem,OrderItemDto.class);
        orderItemDto.setStatusDesc(ConstUtil.OrderStatus.getStatusDesc(orderItemDto.getStatus()));
        orderItemDto.setUsername(userRepository.findUserById(orderItemDto.getUserId()).getUsername());
        return orderItemDto;
    }
    private List<OrderItemDto> orderItemListToOrderItemDtoList(List<OrderItem> orderItemList){
        List<OrderItemDto> orderItemDtoList=new ArrayList<>();
        for(OrderItem o:orderItemList){
            orderItemDtoList.add(orderItmToOrderItemDto(o));
        }
        return orderItemDtoList;
    }
    private OrderDetailDto orderDetailToOrderDetailDto(OrderDetail orderDetail){
        OrderDetailDto orderDetailDto=modelMapper.map(orderDetail,OrderDetailDto.class);
        orderDetailDto.setCourseType(ConstUtil.CourseType.getCourseTypeDesc(orderDetailDto.getCourseTypeId()));
        Course course=courseRepository.findCourseById(orderDetailDto.getCourseId());
        orderDetailDto.setCourseName(course.getCourseName());
        orderDetailDto.setCategoryName(courseCategoryRepository.findCourseCategoryById(course.getCourseCategoryId()).getCategoryName());
        return orderDetailDto;
    }
    private List<OrderDetailDto> orderDetailListToOrderDetailDtoList(List<OrderDetail> orderDetailList){
        List<OrderDetailDto> orderDetailDtoList=new ArrayList<>();
        for(OrderDetail o:orderDetailList){
            orderDetailDtoList.add(orderDetailToOrderDetailDto(o));
        }
        return orderDetailDtoList;
    }
}