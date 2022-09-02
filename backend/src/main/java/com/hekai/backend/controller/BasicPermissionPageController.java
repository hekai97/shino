package com.hekai.backend.controller;

import com.hekai.backend.entity.BasicPermissionPage;
import com.hekai.backend.service.BasicPermissionPageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 权限页面(BasicPermissionPage)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:10
 */
@RestController
@RequestMapping("basicPermissionPage")
public class BasicPermissionPageController {
    /**
     * 服务对象
     */
    @Resource
    private BasicPermissionPageService basicPermissionPageService;

    /**
     * 分页查询
     *
     * @param basicPermissionPage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BasicPermissionPage>> queryByPage(BasicPermissionPage basicPermissionPage, PageRequest pageRequest) {
        return ResponseEntity.ok(this.basicPermissionPageService.queryByPage(basicPermissionPage, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BasicPermissionPage> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.basicPermissionPageService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param basicPermissionPage 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BasicPermissionPage> add(BasicPermissionPage basicPermissionPage) {
        return ResponseEntity.ok(this.basicPermissionPageService.insert(basicPermissionPage));
    }

    /**
     * 编辑数据
     *
     * @param basicPermissionPage 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BasicPermissionPage> edit(BasicPermissionPage basicPermissionPage) {
        return ResponseEntity.ok(this.basicPermissionPageService.update(basicPermissionPage));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.basicPermissionPageService.deleteById(id));
    }

}

