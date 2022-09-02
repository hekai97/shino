package com.hekai.backend.service.impl;

import com.hekai.backend.entity.BasicStudent;
import com.hekai.backend.repository.BasicStudentRepository;
import com.hekai.backend.service.BasicStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学员信息(BasicStudent)表服务实现类
 *
 * @author hekai
 * @since 2022-09-02 11:16:02
 */
@Service("basicStudentService")
public class BasicStudentServiceImpl implements BasicStudentService {

    @Autowired
    private BasicStudentRepository basicStudentRepository;

    @Override
    public ResponseEntity<List<BasicStudent>> findAll() {
        List<BasicStudent> basicStudents = basicStudentRepository.findAll();
        return ResponseEntity.ok(basicStudents);
    }
}
