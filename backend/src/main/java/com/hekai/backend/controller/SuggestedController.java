package com.hekai.backend.controller;

import com.hekai.backend.entity.Suggested;
import com.hekai.backend.service.SuggestedService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 建议反馈(Suggested)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("suggested")
public class SuggestedController {
    /**
     * 服务对象
     */
    @Resource
    private SuggestedService suggestedService;

    /**
     * 分页查询
     *
     * @param suggested 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Suggested>> queryByPage(Suggested suggested, PageRequest pageRequest) {
        return ResponseEntity.ok(this.suggestedService.queryByPage(suggested, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Suggested> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.suggestedService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param suggested 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Suggested> add(Suggested suggested) {
        return ResponseEntity.ok(this.suggestedService.insert(suggested));
    }

    /**
     * 编辑数据
     *
     * @param suggested 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Suggested> edit(Suggested suggested) {
        return ResponseEntity.ok(this.suggestedService.update(suggested));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.suggestedService.deleteById(id));
    }

}

