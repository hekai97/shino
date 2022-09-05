package com.hekai.backend.controller.employee;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.CourseReservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/employee/reservation")
public class EmployeeCourseReservationController {
    @RequestMapping(value = "/getCourseReservationListPageable",method = RequestMethod.POST)
    public ServerResponse<Page<CourseReservation>> getCourseReservationListPageable(HttpSession httpSession, Pageable pageable){
        return null;
    }
    @RequestMapping(value = "/deleteReservation",method = RequestMethod.POST)
    public ServerResponse<String> deleteReservation(HttpSession httpSession,Integer reservationId){
        return null;
    }
}
