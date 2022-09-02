package com.hekai.backend.controller;

import com.hekai.backend.entity.CurCourseImg;
import com.hekai.backend.service.CurCourseImgService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CurCourseImg)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("curCourseImg")
public class CurCourseImgController {
    /**
     * 服务对象
     */
    @Resource
    private CurCourseImgService curCourseImgService;

    /**
     * 分页查询
     *
     * @param curCourseImg 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CurCourseImg>> queryByPage(CurCourseImg curCourseImg, PageRequest pageRequest) {
        return ResponseEntity.ok(this.curCourseImgService.queryByPage(curCourseImg, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CurCourseImg> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.curCourseImgService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param curCourseImg 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CurCourseImg> add(CurCourseImg curCourseImg) {
        return ResponseEntity.ok(this.curCourseImgService.insert(curCourseImg));
    }

    /**
     * 编辑数据
     *
     * @param curCourseImg 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CurCourseImg> edit(CurCourseImg curCourseImg) {
        return ResponseEntity.ok(this.curCourseImgService.update(curCourseImg));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.curCourseImgService.deleteById(id));
    }

}

