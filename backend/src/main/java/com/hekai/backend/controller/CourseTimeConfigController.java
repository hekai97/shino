package com.hekai.backend.controller;

import com.hekai.backend.entity.CourseTimeConfig;
import com.hekai.backend.service.CourseTimeConfigService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 上课时间配置(CourseTimeConfig)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("courseTimeConfig")
public class CourseTimeConfigController {
    /**
     * 服务对象
     */
    @Resource
    private CourseTimeConfigService courseTimeConfigService;

    /**
     * 分页查询
     *
     * @param courseTimeConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CourseTimeConfig>> queryByPage(CourseTimeConfig courseTimeConfig, PageRequest pageRequest) {
        return ResponseEntity.ok(this.courseTimeConfigService.queryByPage(courseTimeConfig, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CourseTimeConfig> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.courseTimeConfigService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param courseTimeConfig 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CourseTimeConfig> add(CourseTimeConfig courseTimeConfig) {
        return ResponseEntity.ok(this.courseTimeConfigService.insert(courseTimeConfig));
    }

    /**
     * 编辑数据
     *
     * @param courseTimeConfig 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CourseTimeConfig> edit(CourseTimeConfig courseTimeConfig) {
        return ResponseEntity.ok(this.courseTimeConfigService.update(courseTimeConfig));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.courseTimeConfigService.deleteById(id));
    }

}

