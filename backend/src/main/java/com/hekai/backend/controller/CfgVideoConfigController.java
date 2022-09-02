package com.hekai.backend.controller;

import com.hekai.backend.entity.CfgVideoConfig;
import com.hekai.backend.service.CfgVideoConfigService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 视频位置配置(CfgVideoConfig)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:10
 */
@RestController
@RequestMapping("cfgVideoConfig")
public class CfgVideoConfigController {
    /**
     * 服务对象
     */
    @Resource
    private CfgVideoConfigService cfgVideoConfigService;

    /**
     * 分页查询
     *
     * @param cfgVideoConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CfgVideoConfig>> queryByPage(CfgVideoConfig cfgVideoConfig, PageRequest pageRequest) {
        return ResponseEntity.ok(this.cfgVideoConfigService.queryByPage(cfgVideoConfig, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CfgVideoConfig> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.cfgVideoConfigService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param cfgVideoConfig 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CfgVideoConfig> add(CfgVideoConfig cfgVideoConfig) {
        return ResponseEntity.ok(this.cfgVideoConfigService.insert(cfgVideoConfig));
    }

    /**
     * 编辑数据
     *
     * @param cfgVideoConfig 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CfgVideoConfig> edit(CfgVideoConfig cfgVideoConfig) {
        return ResponseEntity.ok(this.cfgVideoConfigService.update(cfgVideoConfig));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.cfgVideoConfigService.deleteById(id));
    }

}

