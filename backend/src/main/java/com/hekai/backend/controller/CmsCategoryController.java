package com.hekai.backend.controller;

import com.hekai.backend.entity.CmsCategory;
import com.hekai.backend.service.CmsCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * CMS分类管理(CmsCategory)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("cmsCategory")
public class CmsCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CmsCategoryService cmsCategoryService;

    /**
     * 分页查询
     *
     * @param cmsCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CmsCategory>> queryByPage(CmsCategory cmsCategory, PageRequest pageRequest) {
        return ResponseEntity.ok(this.cmsCategoryService.queryByPage(cmsCategory, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CmsCategory> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.cmsCategoryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param cmsCategory 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CmsCategory> add(CmsCategory cmsCategory) {
        return ResponseEntity.ok(this.cmsCategoryService.insert(cmsCategory));
    }

    /**
     * 编辑数据
     *
     * @param cmsCategory 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CmsCategory> edit(CmsCategory cmsCategory) {
        return ResponseEntity.ok(this.cmsCategoryService.update(cmsCategory));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.cmsCategoryService.deleteById(id));
    }

}

