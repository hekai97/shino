package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseTableDto;
import com.hekai.backend.dto.NewCourseTableDto;
import com.hekai.backend.dto.TeacherDto;
import com.hekai.backend.entity.*;
import com.hekai.backend.repository.*;
import com.hekai.backend.service.CourseTableService;
import com.hekai.backend.utils.DateFormatUtil;
import com.hekai.backend.utils.SendMail;
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
    @Autowired
    private OrderGoodsRepository orderGoodsRepository;
    @Autowired
    private CourseReservationRepository courseReservationRepository;
    @Autowired
    private SendMail emailUtil;

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
    public ServerResponse<CourseTableDto> createScheduling(NewCourseTableDto newCourseTableDto) {
        System.out.println(newCourseTableDto.toString());
        CourseTable courseTable=new CourseTable();
        courseTable.setStoreId(newCourseTableDto.getStoreId());
        courseTable.setCourseId(newCourseTableDto.getCourseId());
        courseTable.setTeacherId(newCourseTableDto.getTeacherId());
        courseTable.setUserId(newCourseTableDto.getUserId());
        courseTable.setCreateTime(new Timestamp(new Date().getTime()));
        courseTable.setReservationDate(new java.sql.Date(DateFormatUtil.formatToDate(newCourseTableDto.getDate()).getTime()));
        courseTable.setBeginTime(DateFormatUtil.formatTime(newCourseTableDto.getBeginTime()));
        courseTable.setEndTime(DateFormatUtil.formatTime(newCourseTableDto.getEndTime()));
        CourseTable courseTable1=courseTableRepository.save(courseTable);
        //TODO:更新订单状态

        CourseReservation courseReservation=courseReservationRepository.findCourseReservationById(newCourseTableDto.getCourseReservationId());
        if(courseReservation==null){
            return ServerResponse.createByErrorMessage("该课程预约不存在！");
        }
        courseReservation.setArrangementDate(courseTable.getReservationDate());
        courseReservation.setOrderBeginTime(courseTable.getBeginTime());
        courseReservation.setOrderEndTime(courseTable.getEndTime());
        courseReservation.setOperateTime(new Timestamp(new Date().getTime()));
        courseReservation.setStartTime(courseTable.getReservationDate());
        courseReservationRepository.save(courseReservation);




        OrderGoods orderGoods=orderGoodsRepository.findOrderGoodsByReserveId(newCourseTableDto.getCourseReservationId());
        orderGoods.setCourseTableId(courseTable1.getId());
        orderGoodsRepository.save(orderGoods);
        //发送邮件通知上课
        String content=userRepository.findUserById(courseTable1.getUserId()).getUsername()+" 同学您好，您的课程预约成功，预约的课程为："+courseRepository.findCourseById(courseTable1.getCourseId()).getCourseName()
                +"，上课时间为："+courseTable1.getReservationDate()+" "+courseTable1.getBeginTime()+"-"+courseTable1.getEndTime()
                +"上课地点为："+storeRepository.findStoreById(courseTable1.getStoreId()).getStoreName()
                +"，核销码为："+orderGoods.getWriteOffCodeNumber()+",请在上课时将该核销码告诉管理人员，届时将会有签到，请准时参加！";
        emailUtil.sendMail(userRepository.findUserById(courseTable1.getUserId()).getEmail(),content);
        return ServerResponse.createRespBySuccessMessage("创建成功");
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

    //非常重要的方法，没事儿别动
    @Override
    public ServerResponse<List<TeacherDto>> getFreeTeacherByTime(Integer storeId,String date, Integer timeId,Integer courseId) {
        //首先获取这个店铺所有的老师

        //然后看一下这个时间段有没有老师在上这个课,如果有的话，直接返回这些个老师就行了

        String startTime;
        String endTime;
        switch (timeId){
            case 1 -> {
                startTime="09:00:00";
                endTime="11:00:00";
            }
            case 2 -> {
                startTime="13:30:00";
                endTime="15:30:00";
            }
            case 3 -> {
                startTime="16:00:00";
                endTime="18:00:00";
            }
            case 4 -> {
                startTime="19:30:00";
                endTime="21:30:00";
            }
            default -> {
                return ServerResponse.createByErrorMessage("时间段错误！");
            }
        }
        List<Teacher> teacherList=teacherRepository.findAllByStoreId(storeId);
        List<Integer> teacherIdList=new ArrayList<>();
        for(Teacher teacher:teacherList){
            teacherIdList.add(teacher.getId());
        }
        List<CourseTable> courseTableList=courseTableRepository.findCourseTablesByStoreIdAndCourseIdAndTeacherIdInAndReservationDateAndBeginTimeAndEndTime(storeId,courseId,teacherIdList,new java.sql.Date(DateFormatUtil.formatToDate(date).getTime()), DateFormatUtil.formatTime(startTime), DateFormatUtil.formatTime(endTime));
        //如果有老师在这个时间段，这个店铺上这个课
        if(courseTableList.size()!=0){
            List<TeacherDto> teacherDtoList=new ArrayList<>();
            for(CourseTable courseTable:courseTableList){
                for(Teacher teacher:teacherList){
                    if(courseTable.getTeacherId().equals(teacher.getId())){
                        TeacherDto teacherDto=modelMapper.map(teacher,TeacherDto.class);
                        teacherDto.setStoreName(storeRepository.findStoreById(teacher.getStoreId()).getStoreName());
                        teacherDtoList.add(teacherDto);
                        teacherList.remove(teacher);
                        break;
                    }
                }
            }
            return ServerResponse.createRespBySuccess(teacherDtoList);
        }
        else {
            //没有的话，就再看看这些个老师中，是不是有人在这个时间段正在上课？如果有的话就排除他
            List<CourseTable> courseTableListWithBusyTeacher=courseTableRepository.findCourseTablesByStoreIdAndTeacherIdInAndReservationDateAndBeginTimeAndEndTime(storeId,teacherIdList,new java.sql.Date(DateFormatUtil.formatToDate(date).getTime()), DateFormatUtil.formatTime(startTime), DateFormatUtil.formatTime(endTime));
            if(courseTableListWithBusyTeacher.size()!=0){
                for(CourseTable courseTable:courseTableListWithBusyTeacher){
                    for(Teacher teacher:teacherList){
                        if(courseTable.getTeacherId().equals(teacher.getId())){
                            teacherList.remove(teacher);
                            break;
                        }
                    }
                }
            }
        }
        List<TeacherDto> teacherDtoList=new ArrayList<>();
        for(Teacher teacher:teacherList){
            TeacherDto teacherDto=modelMapper.map(teacher,TeacherDto.class);
            teacherDto.setStoreName(storeRepository.findStoreById(teacher.getStoreId()).getStoreName());
            teacherDtoList.add(teacherDto);
        }
        return ServerResponse.createRespBySuccess(teacherDtoList);
    }

    @Override
    public ServerResponse<List<CourseTableDto>> getAllCourseTableList(Integer storeId) {
        List<CourseTable> courseTableList=courseTableRepository.findAllByStoreId(storeId);
        List<CourseTableDto> courseTableDtoList=courseTableListToCourseTableDtoList(courseTableList);
        return ServerResponse.createRespBySuccess(courseTableDtoList);
    }

    private CourseTableDto courseTableToCourseTableDto(CourseTable courseTable) {
        CourseTableDto courseTableDto = modelMapper.map(courseTable, CourseTableDto.class);
        courseTableDto.setCourseName(courseRepository.findCourseById(courseTable.getCourseId()).getCourseName());
        courseTableDto.setStoreName(storeRepository.findStoreById(courseTable.getStoreId()).getStoreName());
        courseTableDto.setTeacherName(teacherRepository.findTeacherById(courseTable.getTeacherId()).getName());
        courseTableDto.setUserName(userRepository.findUserById(courseTable.getUserId()).getName());
        courseTableDto.setCreateTime(DateFormatUtil.formatTimeNoSecond(courseTable.getCreateTime()));
        courseTableDto.setReservationDate(DateFormatUtil.formatDateToString(courseTable.getReservationDate()));
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
