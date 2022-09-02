package com.hekai.backend.controller;

import com.hekai.backend.entity.CfgVideoPath;
import com.hekai.backend.service.CfgVideoPathService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 视频存放路径(CfgVideoPath)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:10
 */
@RestController
@RequestMapping("cfgVideoPath")
public class CfgVideoPathController {
    /**
     * 服务对象
     */
    @Resource
    private CfgVideoPathService cfgVideoPathService;

    /**
     * 分页查询
     *
     * @param cfgVideoPath 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CfgVideoPath>> queryByPage(CfgVideoPath cfgVideoPath, PageRequest pageRequest) {
        return ResponseEntity.ok(this.cfgVideoPathService.queryByPage(cfgVideoPath, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CfgVideoPath> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.cfgVideoPathService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param cfgVideoPath 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CfgVideoPath> add(CfgVideoPath cfgVideoPath) {
        return ResponseEntity.ok(this.cfgVideoPathService.insert(cfgVideoPath));
    }

    /**
     * 编辑数据
     *
     * @param cfgVideoPath 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CfgVideoPath> edit(CfgVideoPath cfgVideoPath) {
        return ResponseEntity.ok(this.cfgVideoPathService.update(cfgVideoPath));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.cfgVideoPathService.deleteById(id));
    }

}

