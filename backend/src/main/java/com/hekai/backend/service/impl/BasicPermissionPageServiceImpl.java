package com.hekai.backend.service.impl;

import com.hekai.backend.entity.BasicPermissionPage;
import com.hekai.backend.service.BasicPermissionPageService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 权限页面(BasicPermissionPage)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:02
 */
@Service("basicPermissionPageService")
public class BasicPermissionPageServiceImpl implements BasicPermissionPageService {
    @Resource
    private BasicPermissionPageDao basicPermissionPageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BasicPermissionPage queryById(Integer id) {
        return this.basicPermissionPageDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param basicPermissionPage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BasicPermissionPage> queryByPage(BasicPermissionPage basicPermissionPage, PageRequest pageRequest) {
        long total = this.basicPermissionPageDao.count(basicPermissionPage);
        return new PageImpl<>(this.basicPermissionPageDao.queryAllByLimit(basicPermissionPage, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param basicPermissionPage 实例对象
     * @return 实例对象
     */
    @Override
    public BasicPermissionPage insert(BasicPermissionPage basicPermissionPage) {
        this.basicPermissionPageDao.insert(basicPermissionPage);
        return basicPermissionPage;
    }

    /**
     * 修改数据
     *
     * @param basicPermissionPage 实例对象
     * @return 实例对象
     */
    @Override
    public BasicPermissionPage update(BasicPermissionPage basicPermissionPage) {
        this.basicPermissionPageDao.update(basicPermissionPage);
        return this.queryById(basicPermissionPage.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.basicPermissionPageDao.deleteById(id) > 0;
    }
}
