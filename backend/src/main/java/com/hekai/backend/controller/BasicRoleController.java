package com.hekai.backend.controller;

import com.hekai.backend.entity.BasicRole;
import com.hekai.backend.service.BasicRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色(BasicRole)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:10
 */
@RestController
@RequestMapping("basicRole")
public class BasicRoleController {
    /**
     * 服务对象
     */
    @Resource
    private BasicRoleService basicRoleService;

    /**
     * 分页查询
     *
     * @param basicRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BasicRole>> queryByPage(BasicRole basicRole, PageRequest pageRequest) {
        return ResponseEntity.ok(this.basicRoleService.queryByPage(basicRole, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BasicRole> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.basicRoleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param basicRole 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BasicRole> add(BasicRole basicRole) {
        return ResponseEntity.ok(this.basicRoleService.insert(basicRole));
    }

    /**
     * 编辑数据
     *
     * @param basicRole 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BasicRole> edit(BasicRole basicRole) {
        return ResponseEntity.ok(this.basicRoleService.update(basicRole));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.basicRoleService.deleteById(id));
    }

}

