package com.hekai.backend.controller;

import com.hekai.backend.entity.CmsArticle;
import com.hekai.backend.service.CmsArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文章内容(CmsArticle)表控制层
 *
 * @author makejava
 * @since 2022-09-02 11:18:11
 */
@RestController
@RequestMapping("cmsArticle")
public class CmsArticleController {
    /**
     * 服务对象
     */
    @Resource
    private CmsArticleService cmsArticleService;

    /**
     * 分页查询
     *
     * @param cmsArticle 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CmsArticle>> queryByPage(CmsArticle cmsArticle, PageRequest pageRequest) {
        return ResponseEntity.ok(this.cmsArticleService.queryByPage(cmsArticle, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CmsArticle> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.cmsArticleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param cmsArticle 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CmsArticle> add(CmsArticle cmsArticle) {
        return ResponseEntity.ok(this.cmsArticleService.insert(cmsArticle));
    }

    /**
     * 编辑数据
     *
     * @param cmsArticle 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CmsArticle> edit(CmsArticle cmsArticle) {
        return ResponseEntity.ok(this.cmsArticleService.update(cmsArticle));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.cmsArticleService.deleteById(id));
    }

}

