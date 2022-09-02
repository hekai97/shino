package com.hekai.backend.controller;

import com.hekai.backend.entity.CurCourseConfig;
import com.hekai.backend.service.CurCourseConfigService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 课程配置(CurCourseConfig)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("curCourseConfig")
public class CurCourseConfigController {
    /**
     * 服务对象
     */
    @Resource
    private CurCourseConfigService curCourseConfigService;

    /**
     * 分页查询
     *
     * @param curCourseConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CurCourseConfig>> queryByPage(CurCourseConfig curCourseConfig, PageRequest pageRequest) {
        return ResponseEntity.ok(this.curCourseConfigService.queryByPage(curCourseConfig, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CurCourseConfig> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.curCourseConfigService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param curCourseConfig 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CurCourseConfig> add(CurCourseConfig curCourseConfig) {
        return ResponseEntity.ok(this.curCourseConfigService.insert(curCourseConfig));
    }

    /**
     * 编辑数据
     *
     * @param curCourseConfig 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CurCourseConfig> edit(CurCourseConfig curCourseConfig) {
        return ResponseEntity.ok(this.curCourseConfigService.update(curCourseConfig));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.curCourseConfigService.deleteById(id));
    }

}

