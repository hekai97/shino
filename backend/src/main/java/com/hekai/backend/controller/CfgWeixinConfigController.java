package com.hekai.backend.controller;

import com.hekai.backend.entity.CfgWeixinConfig;
import com.hekai.backend.service.CfgWeixinConfigService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 微信支付接口配置(CfgWeixinConfig)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:10
 */
@RestController
@RequestMapping("cfgWeixinConfig")
public class CfgWeixinConfigController {
    /**
     * 服务对象
     */
    @Resource
    private CfgWeixinConfigService cfgWeixinConfigService;

    /**
     * 分页查询
     *
     * @param cfgWeixinConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CfgWeixinConfig>> queryByPage(CfgWeixinConfig cfgWeixinConfig, PageRequest pageRequest) {
        return ResponseEntity.ok(this.cfgWeixinConfigService.queryByPage(cfgWeixinConfig, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CfgWeixinConfig> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.cfgWeixinConfigService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param cfgWeixinConfig 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CfgWeixinConfig> add(CfgWeixinConfig cfgWeixinConfig) {
        return ResponseEntity.ok(this.cfgWeixinConfigService.insert(cfgWeixinConfig));
    }

    /**
     * 编辑数据
     *
     * @param cfgWeixinConfig 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CfgWeixinConfig> edit(CfgWeixinConfig cfgWeixinConfig) {
        return ResponseEntity.ok(this.cfgWeixinConfigService.update(cfgWeixinConfig));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.cfgWeixinConfigService.deleteById(id));
    }

}

