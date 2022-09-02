package com.hekai.backend.common;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//字段为空的话，不序列化进json数据，即不像前台返回空的值。
@JsonSerialize
public class ServerResponse<T> implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	private int status;
	private String message;
	private T data;
	public int getStatus() {
		return this.status;
	}
	public T getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}
	
	@JsonIgnore
	public boolean isSuccess() {
		return this.status==ResponseCode.SUCCESS.getCode();
	}

	private ServerResponse(int status) {
		this.status = status;
	}

	private ServerResponse(int status, T data) {
		this.status = status;
		this.data = data;
	}

	private ServerResponse(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	private ServerResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public static <T> ServerResponse<T> createRespBySuccess() {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
	}

	public static <T> ServerResponse<T> createRespBySuccess(T data) {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), data);
	}

	public static <T> ServerResponse<T> createRespBySuccess(String msg, T data) {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, data);
	}

	public static <T> ServerResponse<T> createRespBySuccessMessage(String msg) {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg);
	}

	public static <T> ServerResponse<T> createRespByError() {
		return new ServerResponse<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
	}

	public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
	}
	
	public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
		return new ServerResponse<T>(errorCode, errorMessage);
	}
}
