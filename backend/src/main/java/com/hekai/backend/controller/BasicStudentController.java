package com.hekai.backend.controller;

import com.hekai.backend.entity.BasicStudent;
import com.hekai.backend.service.BasicStudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 学员信息(BasicStudent)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:10
 */
@RestController
@RequestMapping("basicStudent")
public class BasicStudentController {
    /**
     * 服务对象
     */
    @Resource
    private BasicStudentService basicStudentService;

    /**
     * 分页查询
     *
     * @param basicStudent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BasicStudent>> queryByPage(BasicStudent basicStudent, PageRequest pageRequest) {
        return ResponseEntity.ok(this.basicStudentService.queryByPage(basicStudent, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BasicStudent> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.basicStudentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param basicStudent 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BasicStudent> add(BasicStudent basicStudent) {
        return ResponseEntity.ok(this.basicStudentService.insert(basicStudent));
    }

    /**
     * 编辑数据
     *
     * @param basicStudent 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BasicStudent> edit(BasicStudent basicStudent) {
        return ResponseEntity.ok(this.basicStudentService.update(basicStudent));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.basicStudentService.deleteById(id));
    }

}

