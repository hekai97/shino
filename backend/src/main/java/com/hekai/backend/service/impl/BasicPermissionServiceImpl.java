package com.hekai.backend.service.impl;

import com.hekai.backend.entity.BasicPermission;
import com.hekai.backend.service.BasicPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 权限(BasicPermission)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:15:15
 */
@Service("basicPermissionService")
public class BasicPermissionServiceImpl implements BasicPermissionService {
    @Resource
    private BasicPermissionDao basicPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BasicPermission queryById(Integer id) {
        return this.basicPermissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param basicPermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BasicPermission> queryByPage(BasicPermission basicPermission, PageRequest pageRequest) {
        long total = this.basicPermissionDao.count(basicPermission);
        return new PageImpl<>(this.basicPermissionDao.queryAllByLimit(basicPermission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param basicPermission 实例对象
     * @return 实例对象
     */
    @Override
    public BasicPermission insert(BasicPermission basicPermission) {
        this.basicPermissionDao.insert(basicPermission);
        return basicPermission;
    }

    /**
     * 修改数据
     *
     * @param basicPermission 实例对象
     * @return 实例对象
     */
    @Override
    public BasicPermission update(BasicPermission basicPermission) {
        this.basicPermissionDao.update(basicPermission);
        return this.queryById(basicPermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.basicPermissionDao.deleteById(id) > 0;
    }
}
