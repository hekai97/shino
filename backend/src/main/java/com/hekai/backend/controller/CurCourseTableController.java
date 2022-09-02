package com.hekai.backend.controller;

import com.hekai.backend.entity.CurCourseTable;
import com.hekai.backend.service.CurCourseTableService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 排课表(CurCourseTable)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("curCourseTable")
public class CurCourseTableController {
    /**
     * 服务对象
     */
    @Resource
    private CurCourseTableService curCourseTableService;

    /**
     * 分页查询
     *
     * @param curCourseTable 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CurCourseTable>> queryByPage(CurCourseTable curCourseTable, PageRequest pageRequest) {
        return ResponseEntity.ok(this.curCourseTableService.queryByPage(curCourseTable, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CurCourseTable> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.curCourseTableService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param curCourseTable 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CurCourseTable> add(CurCourseTable curCourseTable) {
        return ResponseEntity.ok(this.curCourseTableService.insert(curCourseTable));
    }

    /**
     * 编辑数据
     *
     * @param curCourseTable 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CurCourseTable> edit(CurCourseTable curCourseTable) {
        return ResponseEntity.ok(this.curCourseTableService.update(curCourseTable));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.curCourseTableService.deleteById(id));
    }

}

