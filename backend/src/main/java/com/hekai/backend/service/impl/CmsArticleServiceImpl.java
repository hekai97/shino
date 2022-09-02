package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CmsArticle;
import com.hekai.backend.dao.CmsArticleDao;
import com.hekai.backend.service.CmsArticleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 文章内容(CmsArticle)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("cmsArticleService")
public class CmsArticleServiceImpl implements CmsArticleService {
    @Resource
    private CmsArticleDao cmsArticleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CmsArticle queryById(Integer id) {
        return this.cmsArticleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param cmsArticle 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CmsArticle> queryByPage(CmsArticle cmsArticle, PageRequest pageRequest) {
        long total = this.cmsArticleDao.count(cmsArticle);
        return new PageImpl<>(this.cmsArticleDao.queryAllByLimit(cmsArticle, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cmsArticle 实例对象
     * @return 实例对象
     */
    @Override
    public CmsArticle insert(CmsArticle cmsArticle) {
        this.cmsArticleDao.insert(cmsArticle);
        return cmsArticle;
    }

    /**
     * 修改数据
     *
     * @param cmsArticle 实例对象
     * @return 实例对象
     */
    @Override
    public CmsArticle update(CmsArticle cmsArticle) {
        this.cmsArticleDao.update(cmsArticle);
        return this.queryById(cmsArticle.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.cmsArticleDao.deleteById(id) > 0;
    }
}
