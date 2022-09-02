package com.hekai.backend.controller;

import com.hekai.backend.entity.Loginlog;
import com.hekai.backend.service.LoginlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 登陆记录表(Loginlog)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("loginlog")
public class LoginlogController {
    /**
     * 服务对象
     */
    @Resource
    private LoginlogService loginlogService;

    /**
     * 分页查询
     *
     * @param loginlog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Loginlog>> queryByPage(Loginlog loginlog, PageRequest pageRequest) {
        return ResponseEntity.ok(this.loginlogService.queryByPage(loginlog, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Loginlog> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.loginlogService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param loginlog 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Loginlog> add(Loginlog loginlog) {
        return ResponseEntity.ok(this.loginlogService.insert(loginlog));
    }

    /**
     * 编辑数据
     *
     * @param loginlog 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Loginlog> edit(Loginlog loginlog) {
        return ResponseEntity.ok(this.loginlogService.update(loginlog));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.loginlogService.deleteById(id));
    }

}

