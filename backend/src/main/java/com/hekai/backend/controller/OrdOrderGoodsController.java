package com.hekai.backend.controller;

import com.hekai.backend.entity.OrdOrderGoods;
import com.hekai.backend.service.OrdOrderGoodsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单课程信息(OrdOrderGoods)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("ordOrderGoods")
public class OrdOrderGoodsController {
    /**
     * 服务对象
     */
    @Resource
    private OrdOrderGoodsService ordOrderGoodsService;

    /**
     * 分页查询
     *
     * @param ordOrderGoods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<OrdOrderGoods>> queryByPage(OrdOrderGoods ordOrderGoods, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ordOrderGoodsService.queryByPage(ordOrderGoods, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<OrdOrderGoods> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.ordOrderGoodsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ordOrderGoods 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<OrdOrderGoods> add(OrdOrderGoods ordOrderGoods) {
        return ResponseEntity.ok(this.ordOrderGoodsService.insert(ordOrderGoods));
    }

    /**
     * 编辑数据
     *
     * @param ordOrderGoods 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<OrdOrderGoods> edit(OrdOrderGoods ordOrderGoods) {
        return ResponseEntity.ok(this.ordOrderGoodsService.update(ordOrderGoods));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.ordOrderGoodsService.deleteById(id));
    }

}

