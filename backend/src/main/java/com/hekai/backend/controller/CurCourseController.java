package com.hekai.backend.controller;

import com.hekai.backend.entity.CurCourse;
import com.hekai.backend.service.CurCourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 课程(CurCourse)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("curCourse")
public class CurCourseController {
    /**
     * 服务对象
     */
    @Resource
    private CurCourseService curCourseService;

    /**
     * 分页查询
     *
     * @param curCourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CurCourse>> queryByPage(CurCourse curCourse, PageRequest pageRequest) {
        return ResponseEntity.ok(this.curCourseService.queryByPage(curCourse, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CurCourse> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.curCourseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param curCourse 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CurCourse> add(CurCourse curCourse) {
        return ResponseEntity.ok(this.curCourseService.insert(curCourse));
    }

    /**
     * 编辑数据
     *
     * @param curCourse 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CurCourse> edit(CurCourse curCourse) {
        return ResponseEntity.ok(this.curCourseService.update(curCourse));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.curCourseService.deleteById(id));
    }

}

