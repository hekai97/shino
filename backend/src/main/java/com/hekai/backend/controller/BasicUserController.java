package com.hekai.backend.controller;

import com.hekai.backend.entity.BasicUser;
import com.hekai.backend.service.BasicUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户(BasicUser)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:10
 */
@RestController
@RequestMapping("basicUser")
public class BasicUserController {
    /**
     * 服务对象
     */
    @Resource
    private BasicUserService basicUserService;

    /**
     * 分页查询
     *
     * @param basicUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BasicUser>> queryByPage(BasicUser basicUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.basicUserService.queryByPage(basicUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BasicUser> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.basicUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param basicUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BasicUser> add(BasicUser basicUser) {
        return ResponseEntity.ok(this.basicUserService.insert(basicUser));
    }

    /**
     * 编辑数据
     *
     * @param basicUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BasicUser> edit(BasicUser basicUser) {
        return ResponseEntity.ok(this.basicUserService.update(basicUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.basicUserService.deleteById(id));
    }

}

