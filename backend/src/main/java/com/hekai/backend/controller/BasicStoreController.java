package com.hekai.backend.controller;

import com.hekai.backend.entity.BasicStore;
import com.hekai.backend.service.BasicStoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 门店(BasicStore)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:10
 */
@RestController
@RequestMapping("basicStore")
public class BasicStoreController {
    /**
     * 服务对象
     */
    @Resource
    private BasicStoreService basicStoreService;

    /**
     * 分页查询
     *
     * @param basicStore 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BasicStore>> queryByPage(BasicStore basicStore, PageRequest pageRequest) {
        return ResponseEntity.ok(this.basicStoreService.queryByPage(basicStore, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BasicStore> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.basicStoreService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param basicStore 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BasicStore> add(BasicStore basicStore) {
        return ResponseEntity.ok(this.basicStoreService.insert(basicStore));
    }

    /**
     * 编辑数据
     *
     * @param basicStore 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BasicStore> edit(BasicStore basicStore) {
        return ResponseEntity.ok(this.basicStoreService.update(basicStore));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.basicStoreService.deleteById(id));
    }

}

