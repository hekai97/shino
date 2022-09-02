package com.hekai.backend.controller;

import com.hekai.backend.entity.CurCourseType;
import com.hekai.backend.service.CurCourseTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 课程分类(CurCourseType)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("curCourseType")
public class CurCourseTypeController {
    /**
     * 服务对象
     */
    @Resource
    private CurCourseTypeService curCourseTypeService;

    /**
     * 分页查询
     *
     * @param curCourseType 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CurCourseType>> queryByPage(CurCourseType curCourseType, PageRequest pageRequest) {
        return ResponseEntity.ok(this.curCourseTypeService.queryByPage(curCourseType, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CurCourseType> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.curCourseTypeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param curCourseType 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CurCourseType> add(CurCourseType curCourseType) {
        return ResponseEntity.ok(this.curCourseTypeService.insert(curCourseType));
    }

    /**
     * 编辑数据
     *
     * @param curCourseType 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CurCourseType> edit(CurCourseType curCourseType) {
        return ResponseEntity.ok(this.curCourseTypeService.update(curCourseType));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.curCourseTypeService.deleteById(id));
    }

}

