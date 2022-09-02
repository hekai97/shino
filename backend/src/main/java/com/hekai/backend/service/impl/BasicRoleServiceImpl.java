package com.hekai.backend.service.impl;

import com.hekai.backend.entity.BasicRole;
import com.hekai.backend.dao.BasicRoleDao;
import com.hekai.backend.service.BasicRoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 角色(BasicRole)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:02
 */
@Service("basicRoleService")
public class BasicRoleServiceImpl implements BasicRoleService {
    @Resource
    private BasicRoleDao basicRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BasicRole queryById(Integer id) {
        return this.basicRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param basicRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BasicRole> queryByPage(BasicRole basicRole, PageRequest pageRequest) {
        long total = this.basicRoleDao.count(basicRole);
        return new PageImpl<>(this.basicRoleDao.queryAllByLimit(basicRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param basicRole 实例对象
     * @return 实例对象
     */
    @Override
    public BasicRole insert(BasicRole basicRole) {
        this.basicRoleDao.insert(basicRole);
        return basicRole;
    }

    /**
     * 修改数据
     *
     * @param basicRole 实例对象
     * @return 实例对象
     */
    @Override
    public BasicRole update(BasicRole basicRole) {
        this.basicRoleDao.update(basicRole);
        return this.queryById(basicRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.basicRoleDao.deleteById(id) > 0;
    }
}
