package com.hekai.backend.service.impl;

import com.hekai.backend.entity.BasicUser;
import com.hekai.backend.dao.BasicUserDao;
import com.hekai.backend.service.BasicUserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 用户(BasicUser)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:02
 */
@Service("basicUserService")
public class BasicUserServiceImpl implements BasicUserService {
    @Resource
    private BasicUserDao basicUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BasicUser queryById(Integer id) {
        return this.basicUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param basicUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BasicUser> queryByPage(BasicUser basicUser, PageRequest pageRequest) {
        long total = this.basicUserDao.count(basicUser);
        return new PageImpl<>(this.basicUserDao.queryAllByLimit(basicUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param basicUser 实例对象
     * @return 实例对象
     */
    @Override
    public BasicUser insert(BasicUser basicUser) {
        this.basicUserDao.insert(basicUser);
        return basicUser;
    }

    /**
     * 修改数据
     *
     * @param basicUser 实例对象
     * @return 实例对象
     */
    @Override
    public BasicUser update(BasicUser basicUser) {
        this.basicUserDao.update(basicUser);
        return this.queryById(basicUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.basicUserDao.deleteById(id) > 0;
    }
}
