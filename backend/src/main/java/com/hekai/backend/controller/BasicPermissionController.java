package com.hekai.backend.controller;

import com.hekai.backend.entity.BasicPermission;
import com.hekai.backend.service.BasicPermissionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 权限(BasicPermission)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:16:57
 */
@RestController
@RequestMapping("basicPermission")
public class BasicPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private BasicPermissionService basicPermissionService;

    /**
     * 分页查询
     *
     * @param basicPermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BasicPermission>> queryByPage(BasicPermission basicPermission, PageRequest pageRequest) {
        return ResponseEntity.ok(this.basicPermissionService.queryByPage(basicPermission, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BasicPermission> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.basicPermissionService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param basicPermission 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BasicPermission> add(BasicPermission basicPermission) {
        return ResponseEntity.ok(this.basicPermissionService.insert(basicPermission));
    }

    /**
     * 编辑数据
     *
     * @param basicPermission 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BasicPermission> edit(BasicPermission basicPermission) {
        return ResponseEntity.ok(this.basicPermissionService.update(basicPermission));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.basicPermissionService.deleteById(id));
    }

}

