package com.hekai.backend.controller;

import com.hekai.backend.entity.CurRlCourseChildcourse;
import com.hekai.backend.service.CurRlCourseChildcourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 套餐课配置(CurRlCourseChildcourse)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("curRlCourseChildcourse")
public class CurRlCourseChildcourseController {
    /**
     * 服务对象
     */
    @Resource
    private CurRlCourseChildcourseService curRlCourseChildcourseService;

    /**
     * 分页查询
     *
     * @param curRlCourseChildcourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CurRlCourseChildcourse>> queryByPage(CurRlCourseChildcourse curRlCourseChildcourse, PageRequest pageRequest) {
        return ResponseEntity.ok(this.curRlCourseChildcourseService.queryByPage(curRlCourseChildcourse, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CurRlCourseChildcourse> queryById(@PathVariable("id")  id) {
        return ResponseEntity.ok(this.curRlCourseChildcourseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param curRlCourseChildcourse 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CurRlCourseChildcourse> add(CurRlCourseChildcourse curRlCourseChildcourse) {
        return ResponseEntity.ok(this.curRlCourseChildcourseService.insert(curRlCourseChildcourse));
    }

    /**
     * 编辑数据
     *
     * @param curRlCourseChildcourse 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CurRlCourseChildcourse> edit(CurRlCourseChildcourse curRlCourseChildcourse) {
        return ResponseEntity.ok(this.curRlCourseChildcourseService.update(curRlCourseChildcourse));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById( id) {
        return ResponseEntity.ok(this.curRlCourseChildcourseService.deleteById(id));
    }

}

