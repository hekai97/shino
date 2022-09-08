package com.hekai.backend.utils;

public class ConstUtil {
    public static final String NORMAL_USER="student";
    public static final String EMPLOYEE_USER="employee";
    public static final String ADMIN_USER="admin";

    public static final Integer SUPER_ADMIN_ROLE=0;
    public static final Integer ADMIN_ROLE=1;
    public static final Integer EMPLOYEE_ROLE=2;

    public static final String IMAGE_ROOT_PATH="/home/hekai/images/";
    public static final String TEACHER_IMAGE_PATH=IMAGE_ROOT_PATH+"teachers/";
    public static final String COURSE_IMAGE_PATH=IMAGE_ROOT_PATH+"courses/";
    public static final String STORE_IMAGE_PATH=IMAGE_ROOT_PATH+"stores/";


    public static class OrderStatus{

        public static final int UNPAID =1;		//未付款
        public static final int PAID =2;		//已经付款
        public static final int AFTER_SALE =3;	//售后中
        public static final int REFUNDED =4;	//已退款
        public static final int CLOSED = 5;	//交易关闭
        public static String getStatusDesc(int code) {
            String desc="未知状态";
            switch (code) {
                case UNPAID -> desc = "未付款";
                case PAID -> desc = "已经付款";
                case AFTER_SALE -> desc = "售后中";
                case REFUNDED -> desc = "已退款";
                case CLOSED -> desc = "交易关闭";
                default -> {
                }
            }
            return desc;
        }
    }
    public static class CourseType{
        public static final int SINGLE =0;		//单节课
        public static final int PACKAGE =1;		//套餐
        public static String getCourseTypeDesc(int code) {
            String desc="未知";
            switch (code){
                case SINGLE:
                    desc="单节课";
                    break;
                case PACKAGE:
                    desc="套餐";
                default:
                    break;
            }
            return desc;
        }
    }
}
