package com.hekai.backend.controller;

import com.hekai.backend.entity.OrdReserve;
import com.hekai.backend.service.OrdReserveService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 预约(OrdReserve)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("ordReserve")
public class OrdReserveController {
    /**
     * 服务对象
     */
    @Resource
    private OrdReserveService ordReserveService;

    /**
     * 分页查询
     *
     * @param ordReserve 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<OrdReserve>> queryByPage(OrdReserve ordReserve, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ordReserveService.queryByPage(ordReserve, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<OrdReserve> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.ordReserveService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ordReserve 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<OrdReserve> add(OrdReserve ordReserve) {
        return ResponseEntity.ok(this.ordReserveService.insert(ordReserve));
    }

    /**
     * 编辑数据
     *
     * @param ordReserve 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<OrdReserve> edit(OrdReserve ordReserve) {
        return ResponseEntity.ok(this.ordReserveService.update(ordReserve));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.ordReserveService.deleteById(id));
    }

}

