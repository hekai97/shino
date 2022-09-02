package com.hekai.backend.controller;

import com.hekai.backend.entity.BasicRlRolePermition;
import com.hekai.backend.service.BasicRlRolePermitionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色与权限对应(BasicRlRolePermition)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:10
 */
@RestController
@RequestMapping("basicRlRolePermition")
public class BasicRlRolePermitionController {
    /**
     * 服务对象
     */
    @Resource
    private BasicRlRolePermitionService basicRlRolePermitionService;

    /**
     * 分页查询
     *
     * @param basicRlRolePermition 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BasicRlRolePermition>> queryByPage(BasicRlRolePermition basicRlRolePermition, PageRequest pageRequest) {
        return ResponseEntity.ok(this.basicRlRolePermitionService.queryByPage(basicRlRolePermition, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BasicRlRolePermition> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.basicRlRolePermitionService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param basicRlRolePermition 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BasicRlRolePermition> add(BasicRlRolePermition basicRlRolePermition) {
        return ResponseEntity.ok(this.basicRlRolePermitionService.insert(basicRlRolePermition));
    }

    /**
     * 编辑数据
     *
     * @param basicRlRolePermition 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BasicRlRolePermition> edit(BasicRlRolePermition basicRlRolePermition) {
        return ResponseEntity.ok(this.basicRlRolePermitionService.update(basicRlRolePermition));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.basicRlRolePermitionService.deleteById(id));
    }

}

