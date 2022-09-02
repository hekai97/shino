package com.hekai.backend.service.impl;

import com.hekai.backend.entity.Loginlog;
import com.hekai.backend.dao.LoginlogDao;
import com.hekai.backend.service.LoginlogService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 登陆记录表(Loginlog)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("loginlogService")
public class LoginlogServiceImpl implements LoginlogService {
    @Resource
    private LoginlogDao loginlogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Loginlog queryById(Integer id) {
        return this.loginlogDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param loginlog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Loginlog> queryByPage(Loginlog loginlog, PageRequest pageRequest) {
        long total = this.loginlogDao.count(loginlog);
        return new PageImpl<>(this.loginlogDao.queryAllByLimit(loginlog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param loginlog 实例对象
     * @return 实例对象
     */
    @Override
    public Loginlog insert(Loginlog loginlog) {
        this.loginlogDao.insert(loginlog);
        return loginlog;
    }

    /**
     * 修改数据
     *
     * @param loginlog 实例对象
     * @return 实例对象
     */
    @Override
    public Loginlog update(Loginlog loginlog) {
        this.loginlogDao.update(loginlog);
        return this.queryById(loginlog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.loginlogDao.deleteById(id) > 0;
    }
}
