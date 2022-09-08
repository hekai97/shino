package com.hekai.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Time;

@Data
public class CourseTableDto implements Serializable {
    private int id;
    private Integer storeId;
    private String storeName;
    private Integer courseId;
    private String courseName;
    private Integer teacherId;
    private String teacherName;
    private Integer userId;
    private String userName;
    private String createTime;
    private String reservationDate;
    private Time beginTime;
    private Time endTime;
}
