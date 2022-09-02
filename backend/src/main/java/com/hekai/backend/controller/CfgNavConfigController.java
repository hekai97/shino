package com.hekai.backend.controller;

import com.hekai.backend.entity.CfgNavConfig;
import com.hekai.backend.service.CfgNavConfigService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 导航配置(CfgNavConfig)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:10
 */
@RestController
@RequestMapping("cfgNavConfig")
public class CfgNavConfigController {
    /**
     * 服务对象
     */
    @Resource
    private CfgNavConfigService cfgNavConfigService;

    /**
     * 分页查询
     *
     * @param cfgNavConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CfgNavConfig>> queryByPage(CfgNavConfig cfgNavConfig, PageRequest pageRequest) {
        return ResponseEntity.ok(this.cfgNavConfigService.queryByPage(cfgNavConfig, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CfgNavConfig> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.cfgNavConfigService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param cfgNavConfig 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CfgNavConfig> add(CfgNavConfig cfgNavConfig) {
        return ResponseEntity.ok(this.cfgNavConfigService.insert(cfgNavConfig));
    }

    /**
     * 编辑数据
     *
     * @param cfgNavConfig 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CfgNavConfig> edit(CfgNavConfig cfgNavConfig) {
        return ResponseEntity.ok(this.cfgNavConfigService.update(cfgNavConfig));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.cfgNavConfigService.deleteById(id));
    }

}

