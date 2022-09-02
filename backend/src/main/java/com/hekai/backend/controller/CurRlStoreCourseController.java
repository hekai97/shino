package com.hekai.backend.controller;

import com.hekai.backend.entity.CurRlStoreCourse;
import com.hekai.backend.service.CurRlStoreCourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 门店课程关系表(CurRlStoreCourse)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("curRlStoreCourse")
public class CurRlStoreCourseController {
    /**
     * 服务对象
     */
    @Resource
    private CurRlStoreCourseService curRlStoreCourseService;

    /**
     * 分页查询
     *
     * @param curRlStoreCourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CurRlStoreCourse>> queryByPage(CurRlStoreCourse curRlStoreCourse, PageRequest pageRequest) {
        return ResponseEntity.ok(this.curRlStoreCourseService.queryByPage(curRlStoreCourse, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CurRlStoreCourse> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.curRlStoreCourseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param curRlStoreCourse 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CurRlStoreCourse> add(CurRlStoreCourse curRlStoreCourse) {
        return ResponseEntity.ok(this.curRlStoreCourseService.insert(curRlStoreCourse));
    }

    /**
     * 编辑数据
     *
     * @param curRlStoreCourse 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CurRlStoreCourse> edit(CurRlStoreCourse curRlStoreCourse) {
        return ResponseEntity.ok(this.curRlStoreCourseService.update(curRlStoreCourse));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.curRlStoreCourseService.deleteById(id));
    }

}

