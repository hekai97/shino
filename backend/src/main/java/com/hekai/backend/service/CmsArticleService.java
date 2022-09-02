package com.hekai.backend.service;

import com.hekai.backend.entity.CmsArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 文章内容(CmsArticle)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CmsArticleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CmsArticle queryById(Integer id);

    /**
     * 分页查询
     *
     * @param cmsArticle 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CmsArticle> queryByPage(CmsArticle cmsArticle, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param cmsArticle 实例对象
     * @return 实例对象
     */
    CmsArticle insert(CmsArticle cmsArticle);

    /**
     * 修改数据
     *
     * @param cmsArticle 实例对象
     * @return 实例对象
     */
    CmsArticle update(CmsArticle cmsArticle);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
