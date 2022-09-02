package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CmsCategory;
import com.hekai.backend.dao.CmsCategoryDao;
import com.hekai.backend.service.CmsCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * CMS分类管理(CmsCategory)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("cmsCategoryService")
public class CmsCategoryServiceImpl implements CmsCategoryService {
    @Resource
    private CmsCategoryDao cmsCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CmsCategory queryById(Integer id) {
        return this.cmsCategoryDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param cmsCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CmsCategory> queryByPage(CmsCategory cmsCategory, PageRequest pageRequest) {
        long total = this.cmsCategoryDao.count(cmsCategory);
        return new PageImpl<>(this.cmsCategoryDao.queryAllByLimit(cmsCategory, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cmsCategory 实例对象
     * @return 实例对象
     */
    @Override
    public CmsCategory insert(CmsCategory cmsCategory) {
        this.cmsCategoryDao.insert(cmsCategory);
        return cmsCategory;
    }

    /**
     * 修改数据
     *
     * @param cmsCategory 实例对象
     * @return 实例对象
     */
    @Override
    public CmsCategory update(CmsCategory cmsCategory) {
        this.cmsCategoryDao.update(cmsCategory);
        return this.queryById(cmsCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.cmsCategoryDao.deleteById(id) > 0;
    }
}
