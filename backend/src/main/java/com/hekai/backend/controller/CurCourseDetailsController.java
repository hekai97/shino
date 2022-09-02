package com.hekai.backend.controller;

import com.hekai.backend.entity.CurCourseDetails;
import com.hekai.backend.service.CurCourseDetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单详情表(CurCourseDetails)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("curCourseDetails")
public class CurCourseDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private CurCourseDetailsService curCourseDetailsService;

    /**
     * 分页查询
     *
     * @param curCourseDetails 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CurCourseDetails>> queryByPage(CurCourseDetails curCourseDetails, PageRequest pageRequest) {
        return ResponseEntity.ok(this.curCourseDetailsService.queryByPage(curCourseDetails, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CurCourseDetails> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.curCourseDetailsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param curCourseDetails 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CurCourseDetails> add(CurCourseDetails curCourseDetails) {
        return ResponseEntity.ok(this.curCourseDetailsService.insert(curCourseDetails));
    }

    /**
     * 编辑数据
     *
     * @param curCourseDetails 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CurCourseDetails> edit(CurCourseDetails curCourseDetails) {
        return ResponseEntity.ok(this.curCourseDetailsService.update(curCourseDetails));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.curCourseDetailsService.deleteById(id));
    }

}

