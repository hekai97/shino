package com.hekai.backend.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hekai.backend.entity.BasicStudent;

/**
 * 学员信息(BasicStudent)表服务接口
 *
 * @author hekai
 * @since 2022-09-02 11:13:19
 */
public interface BasicStudentService {
    ResponseEntity<List<BasicStudent>> findAll();
}
