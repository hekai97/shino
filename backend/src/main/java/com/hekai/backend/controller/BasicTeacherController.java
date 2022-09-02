package com.hekai.backend.controller;

import com.hekai.backend.entity.BasicTeacher;
import com.hekai.backend.service.BasicTeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 讲师信息(BasicTeacher)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:10
 */
@RestController
@RequestMapping("basicTeacher")
public class BasicTeacherController {
    /**
     * 服务对象
     */
    @Resource
    private BasicTeacherService basicTeacherService;

    /**
     * 分页查询
     *
     * @param basicTeacher 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BasicTeacher>> queryByPage(BasicTeacher basicTeacher, PageRequest pageRequest) {
        return ResponseEntity.ok(this.basicTeacherService.queryByPage(basicTeacher, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BasicTeacher> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.basicTeacherService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param basicTeacher 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BasicTeacher> add(BasicTeacher basicTeacher) {
        return ResponseEntity.ok(this.basicTeacherService.insert(basicTeacher));
    }

    /**
     * 编辑数据
     *
     * @param basicTeacher 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BasicTeacher> edit(BasicTeacher basicTeacher) {
        return ResponseEntity.ok(this.basicTeacherService.update(basicTeacher));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.basicTeacherService.deleteById(id));
    }

}

