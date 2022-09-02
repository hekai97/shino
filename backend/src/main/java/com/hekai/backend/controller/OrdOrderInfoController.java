package com.hekai.backend.controller;

import com.hekai.backend.entity.OrdOrderInfo;
import com.hekai.backend.service.OrdOrderInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单信息(OrdOrderInfo)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("ordOrderInfo")
public class OrdOrderInfoController {
    /**
     * 服务对象
     */
    @Resource
    private OrdOrderInfoService ordOrderInfoService;

    /**
     * 分页查询
     *
     * @param ordOrderInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<OrdOrderInfo>> queryByPage(OrdOrderInfo ordOrderInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ordOrderInfoService.queryByPage(ordOrderInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<OrdOrderInfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.ordOrderInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ordOrderInfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<OrdOrderInfo> add(OrdOrderInfo ordOrderInfo) {
        return ResponseEntity.ok(this.ordOrderInfoService.insert(ordOrderInfo));
    }

    /**
     * 编辑数据
     *
     * @param ordOrderInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<OrdOrderInfo> edit(OrdOrderInfo ordOrderInfo) {
        return ResponseEntity.ok(this.ordOrderInfoService.update(ordOrderInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.ordOrderInfoService.deleteById(id));
    }

}

