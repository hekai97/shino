package com.hekai.backend.service;

import com.hekai.backend.entity.CmsCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * CMS分类管理(CmsCategory)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CmsCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CmsCategory queryById(Integer id);

    /**
     * 分页查询
     *
     * @param cmsCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CmsCategory> queryByPage(CmsCategory cmsCategory, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param cmsCategory 实例对象
     * @return 实例对象
     */
    CmsCategory insert(CmsCategory cmsCategory);

    /**
     * 修改数据
     *
     * @param cmsCategory 实例对象
     * @return 实例对象
     */
    CmsCategory update(CmsCategory cmsCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
