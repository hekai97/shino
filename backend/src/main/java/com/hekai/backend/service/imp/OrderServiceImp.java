package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.*;
import com.hekai.backend.entity.*;
import com.hekai.backend.repository.*;
import com.hekai.backend.service.OrderService;
import com.hekai.backend.utils.ConstUtil;
import com.hekai.backend.utils.DateFormatUtil;
import com.hekai.backend.utils.UUIDUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

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
    @Autowired
    private RelationStoreCourseRepository relationStoreCourseRepository;
    @Autowired
    private OrderGoodsRepository orderGoodsRepository;
    @Autowired
    private CourseReservationRepository courseReservationRepository;
    @Autowired
    private CourseTableRepository courseTableRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseTimeConfigRepository courseTimeConfigRepository;
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
    public ServerResponse<List<OrderItemDto>> getUserUnPaidOrderList(Integer id) {
        List<OrderItem> orderItemList=orderItemRepository.findOrderItemsByUserIdAndStatusIs(id,ConstUtil.OrderStatus.UNPAID);
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
        }else if(type==1){
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
        }else{
            return ServerResponse.createByErrorMessage("type参数错误");
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
//        orderItem.setStatus(ConstUtil.OrderStatus.CLOSED);
//        orderItemRepository.save(orderItem);
        List<OrderDetail> orderDetailList=orderDetailRepository.findOrderDetailsByOrderId(orderItem.getId());
        orderDetailRepository.deleteAll(orderDetailList);
        orderItemRepository.delete(orderItem);
        return ServerResponse.createRespBySuccessMessage("成功取消订单！");
    }

    @Override
    public void updateOrderStatus(String orderNumber, int status) {
        OrderItem orderItem=orderItemRepository.findOrderItemByOrderNumber(orderNumber);
        orderItem.setStatus(status);
        orderItemRepository.save(orderItem);
    }

    @Override
    public ServerResponse<Page<OrderItemDto>> getOrderItemsByStoreId(Pageable pageable, Integer storeId) {
        List<RelationStoreCourse> relationStoreCourseList=relationStoreCourseRepository.findRelationStoreCoursesByStoreId(storeId);
        List<Integer> courseIdList=new ArrayList<>();
        for(RelationStoreCourse rsc:relationStoreCourseList){
            courseIdList.add(rsc.getCourseId());
        }

        List<OrderDetail> orderDetailList=orderDetailRepository.findOrderDetailsByCourseIdIn(courseIdList);
        List<Integer> orderIdList=new ArrayList<>();
        for(OrderDetail orderDetail:orderDetailList){
            orderIdList.add(orderDetail.getOrderId());
        }
        Page<OrderItem> orderItemPage=orderItemRepository.findOrderItemsByIdInAndStatusIsNot(orderIdList,ConstUtil.OrderStatus.UNPAID,pageable);
        List<OrderItem> orderItemList=orderItemPage.getContent();
        List<OrderItemDto> orderItemDtoList=orderItemListToOrderItemDtoList(orderItemList);
        Page<OrderItemDto> result=new PageImpl<>(orderItemDtoList,orderItemPage.getPageable(),orderItemPage.getTotalElements());
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<BigDecimal> getBenefitByStoreId(Integer storeId) {
        List<RelationStoreCourse> relationStoreCourseList=relationStoreCourseRepository.findRelationStoreCoursesByStoreId(storeId);
        List<Integer> courseIdList=new ArrayList<>();
        for(RelationStoreCourse rsc:relationStoreCourseList){
            courseIdList.add(rsc.getCourseId());
        }

        List<OrderDetail> orderDetailList=orderDetailRepository.findOrderDetailsByCourseIdIn(courseIdList);
        List<Integer> orderIdList=new ArrayList<>();
        for(OrderDetail orderDetail:orderDetailList){
            orderIdList.add(orderDetail.getOrderId());
        }
        List<OrderItem> orderItemList=orderItemRepository.findAllByIdInAndStatusIsNot(orderIdList,ConstUtil.OrderStatus.UNPAID);
        BigDecimal benefit=BigDecimal.ZERO;
        for(OrderItem orderItem:orderItemList){
            benefit=benefit.add(orderItem.getTotalAmount());
        }
        return ServerResponse.createRespBySuccess(benefit);
    }

    @Override
    public ServerResponse<Integer> getAllPaidUserNumber() {
        return ServerResponse.createRespBySuccess(orderItemRepository.findAllPaidUserByStatusIsNot(ConstUtil.OrderStatus.UNPAID));
    }

    @Override
    public ServerResponse<List<TimeAndCountDto>> getOrderItemsByDate(int day) {
        Date now=new Date();
        List<TimeAndCountDto> timeAndCountDtoList=new ArrayList<>();
        for(int i=0;i<day;++i){
            Date date=DateUtils.addDays(now,-i);
            Date start=DateUtils.truncate(date,Calendar.DATE);
            Date end=DateUtils.addMilliseconds(DateUtils.ceiling(date,Calendar.DATE),-1);
            int count=orderItemRepository.findPaidOrderByStatusIsNotAndPayTimeBetween(ConstUtil.OrderStatus.UNPAID, DateFormatUtil.formatDate(start),DateFormatUtil.formatDate(end));
            TimeAndCountDto timeAndCountDto=new TimeAndCountDto();
            timeAndCountDto.setTime(DateFormatUtil.formatDate(date));
            timeAndCountDto.setCount(count);
            timeAndCountDtoList.add(timeAndCountDto);
        }
        return ServerResponse.createRespBySuccess(timeAndCountDtoList);
    }

    @Override
    public ServerResponse<List<OrderItemDto>> getUserPaidOrderList(int id) {
        List<Integer> orderStatus=new ArrayList<>();
        orderStatus.add(ConstUtil.OrderStatus.PAID);
        orderStatus.add(ConstUtil.OrderStatus.CLOSED);
        List<OrderItem> orderItemList=orderItemRepository.findOrderItemsByUserIdAndStatusIn(id,orderStatus);
        List<OrderItemDto> orderItemDtoList=orderItemListToOrderItemDtoList(orderItemList);
        return ServerResponse.createRespBySuccess(orderItemDtoList);
    }

    @Override
    public ServerResponse<List<OrderItemDto>> getAfterSaleOrderList(int id) {
        List<OrderItem> orderItemList=orderItemRepository.findOrderItemsByUserIdAndStatus(id,ConstUtil.OrderStatus.AFTER_SALE);
        List<OrderItemDto> orderItemDtoList=orderItemListToOrderItemDtoList(orderItemList);
        return ServerResponse.createRespBySuccess(orderItemDtoList);
    }

    @Override
    public ServerResponse<List<OrderGoodsDto>> getNoReservations(Integer userId) {
        List<OrderItem> orderItemList=orderItemRepository.findOrderItemsByUserIdAndStatusIsNot(userId,ConstUtil.OrderStatus.UNPAID);
        List<Integer> orderIdList=new ArrayList<>();
        for(OrderItem orderItem:orderItemList){
            orderIdList.add(orderItem.getId());
        }
        List<OrderDetail> orderDetailList=orderDetailRepository.findOrderDetailsByOrderIdIn(orderIdList);
        List<Integer> orderDetailIdList=new ArrayList<>();
        for(OrderDetail orderDetail:orderDetailList){
            orderDetailIdList.add(orderDetail.getId());
        }
        List<OrderGoods> orderGoodsList=orderGoodsRepository.findOrderGoodsByOrderDetailIdInAndReserveIdIsNull(orderDetailIdList);
        List<OrderGoodsDto> orderGoodsDtoList=orderGoodsListToOrderGoodsDtoList(orderItemList,orderDetailList,orderGoodsList);
        return ServerResponse.createRespBySuccess(orderGoodsDtoList);
    }

    @Override
    public ServerResponse<List<OrderGoodsDto>> getReservations(Integer userId) {
        List<OrderItem> orderItemList=orderItemRepository.findOrderItemsByUserIdAndStatusIsNot(userId,ConstUtil.OrderStatus.UNPAID);
        List<Integer> orderIdList=new ArrayList<>();
        for(OrderItem orderItem:orderItemList){
            orderIdList.add(orderItem.getId());
        }
        List<OrderDetail> orderDetailList=orderDetailRepository.findOrderDetailsByOrderIdIn(orderIdList);
        List<Integer> orderDetailIdList=new ArrayList<>();
        for(OrderDetail orderDetail:orderDetailList){
            orderDetailIdList.add(orderDetail.getId());
        }
        List<OrderGoods> orderGoodsList=orderGoodsRepository.findOrderGoodsByOrderDetailIdInAndReserveIdIsNotNull(orderDetailIdList);
        List<OrderGoodsDto> orderGoodsDtoList=orderGoodsListToOrderGoodsDtoListWithReservationAndTable(orderItemList,orderDetailList,orderGoodsList);
        return ServerResponse.createRespBySuccess(orderGoodsDtoList);
    }

    @Override
    public ServerResponse<String> userCreateReservations(Integer userId, Integer orderDetailId, Integer storeId, String date, Integer group) {
        OrderDetail orderDetail=orderDetailRepository.findOrderDetailById(orderDetailId);
        if(orderDetail==null){
            return ServerResponse.createByErrorMessage("订单详情不存在");
        }
        OrderItem orderItem=orderItemRepository.findOrderItemById(orderDetail.getOrderId());
        if(orderItem==null){
            return ServerResponse.createByErrorMessage("订单不存在");
        }
        if(!Objects.equals(orderItem.getUserId(), userId)){
            return ServerResponse.createByErrorMessage("订单不属于该用户");
        }
        CourseReservation courseReservation=new CourseReservation();
        courseReservation.setStoreId(storeId);
        courseReservation.setCourseId(orderDetail.getCourseId());
        courseReservation.setOrderId(orderDetail.getOrderId());
        courseReservation.setState(ConstUtil.COURSE_RESERVATION_STATUS_WAITING);
        courseReservation.setDate(DateFormatUtil.formatTimestamp(date));
        CourseTimeConfig courseTimeConfig=courseTimeConfigRepository.findAll().get(0);
        switch (group){
            case 1 -> {
                courseReservation.setBeginTime(DateFormatUtil.formatTimestamp(courseTimeConfig.getCourse1StartTime()));
                courseReservation.setEndTime(DateFormatUtil.formatTimestamp(courseTimeConfig.getCourse1EndTime()));
            }
            case 2 -> {
                courseReservation.setBeginTime(DateFormatUtil.formatTimestamp(courseTimeConfig.getCourse2StartTime()));
                courseReservation.setEndTime(DateFormatUtil.formatTimestamp(courseTimeConfig.getCourse2EndTime()));
            }
            case 3 -> {
                courseReservation.setBeginTime(DateFormatUtil.formatTimestamp(courseTimeConfig.getCourse3StartTime()));
                courseReservation.setEndTime(DateFormatUtil.formatTimestamp(courseTimeConfig.getCourse3EndTime()));
            }
            case 4 -> {
                courseReservation.setBeginTime(DateFormatUtil.formatTimestamp(courseTimeConfig.getCourse4StartTime()));
                courseReservation.setEndTime(DateFormatUtil.formatTimestamp(courseTimeConfig.getCourse4EndTime()));
            }
            default -> {
                return ServerResponse.createByErrorMessage("时间参数错误");
            }
        }
        CourseReservation result=courseReservationRepository.save(courseReservation);
        OrderGoods orderGoods=orderGoodsRepository.findOrderGoodsByOrderDetailIdAndReserveIdIsNull(orderDetailId);
        if(orderGoods==null){
            return ServerResponse.createByErrorMessage("预约失败");
        }
        orderGoods.setReserveId(result.getId());
        orderGoodsRepository.save(orderGoods);
        return ServerResponse.createRespBySuccess("预约成功");
    }

    @Override
    public ServerResponse<CourseReservation> getReservationsDetailByReservationId(Integer courseReservationId) {
        CourseReservation courseReservation=courseReservationRepository.findCourseReservationById(courseReservationId);
        if(courseReservation==null){
            return ServerResponse.createByErrorMessage("预约不存在");
        }
        return ServerResponse.createRespBySuccess(courseReservation);
    }

    @Override
    public ServerResponse<List<OrderDetailDto>> getUserOrderDetailByOrderItemId(Integer id, Integer orderItemId) {
        OrderItem orderItem=orderItemRepository.findOrderItemById(orderItemId);
        if(orderItem==null){
            return ServerResponse.createByErrorMessage("订单不存在");
        }
        if(!Objects.equals(orderItem.getUserId(), id)){
            return ServerResponse.createByErrorMessage("订单不属于该用户");
        }
        List<OrderDetail> orderDetailList=orderDetailRepository.findOrderDetailsByOrderId(orderItemId);
        List<OrderDetailDto> orderDetailDtoList=orderDetailListToOrderDetailDtoList(orderDetailList);
        return ServerResponse.createRespBySuccess(orderDetailDtoList);
    }

    @Override
    public void generateWriteOffCode(String out_trade_no) {
        OrderItem orderItem=orderItemRepository.findOrderItemByOrderNumber(out_trade_no);
        List<OrderDetail> orderDetailList=orderDetailRepository.findOrderDetailsByOrderId(orderItem.getId());
        for(OrderDetail orderDetail:orderDetailList) {
            String writeOffCode = UUIDUtil.generationSixNumber();
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setCourseId(orderDetail.getCourseId());
            orderGoods.setOrderDetailId(orderDetail.getId());
            orderGoods.setWriteOffCodeNumber(writeOffCode);
            orderGoodsRepository.save(orderGoods);
        }
    }

    @Override
    public void setToPaid(String out_trade_no) {
        updateOrderStatus(out_trade_no, ConstUtil.OrderStatus.PAID);
        OrderItem orderItem=orderItemRepository.findOrderItemByOrderNumber(out_trade_no);
        orderItem.setPayTime(new Timestamp(new Date().getTime()));
        orderItemRepository.save(orderItem);
        generateWriteOffCode(out_trade_no);
    }

    private List<OrderGoodsDto> orderGoodsListToOrderGoodsDtoListWithReservationAndTable(List<OrderItem> orderItemList, List<OrderDetail> orderDetailList, List<OrderGoods> orderGoodsList) {
        List<OrderGoodsDto> orderGoodsDtoList=orderGoodsListToOrderGoodsDtoList(orderItemList,orderDetailList,orderGoodsList);
        for(OrderGoodsDto orderGoodsDto:orderGoodsDtoList){
            Integer reserveId=orderGoodsDto.getReserveId();
            if(reserveId!=null) {
                CourseReservation courseReservation = courseReservationRepository.findCourseReservationById(reserveId);
                orderGoodsDto.setCourseReservation(courseReservation);
            }
            if(orderGoodsDto.getCourseTableId()!=null){
                CourseTable courseTable=courseTableRepository.findCourseTableById(orderGoodsDto.getCourseTableId());
                orderGoodsDto.setCourseTable(courseTableToCourseTableDto(courseTable));
            }
        }
        return orderGoodsDtoList;
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

    private List<OrderGoodsDto> orderGoodsListToOrderGoodsDtoList(List<OrderItem> orderItemList, List<OrderDetail> orderDetailList, List<OrderGoods> orderGoodsList) {
        List<OrderGoodsDto> orderGoodsDtoList=new ArrayList<>();
        for(OrderGoods orderGoods:orderGoodsList) {
            OrderGoodsDto orderGoodsDto= new OrderGoodsDto();
            modelMapper.map(orderGoods,orderGoodsDto);
            for(OrderDetail orderDetail:orderDetailList){
                if(orderGoodsDto.getOrderDetailId().equals(orderDetail.getId())){
                    orderGoodsDto.setOrderId(orderDetail.getOrderId());
                    orderGoodsDto.setPrice(orderDetail.getPrice());
                    Course course=courseRepository.findCourseById(orderDetail.getCourseId());
                    orderGoodsDto.setCourseName(course.getCourseName());
                    orderGoodsDto.setPictureUrl(course.getPictureUrl());
                    orderGoodsDto.setCategoryName(courseCategoryRepository.findCourseCategoryById(course.getCourseCategoryId()).getCategoryName());
                    break;
                }
            }
            for(OrderItem orderItem:orderItemList){
                if(orderGoodsDto.getOrderId().equals(orderItem.getId())){
                    orderGoodsDto.setOrderNumber(orderItem.getOrderNumber());
                    break;
                }
            }
            orderGoodsDtoList.add(orderGoodsDto);
        }
        return orderGoodsDtoList;
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
        orderDetailDto.setPictureUrl(course.getPictureUrl());
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
