package com.hekai.backend.service.impl;

import com.hekai.backend.entity.BasicRlRolePermition;
import com.hekai.backend.dao.BasicRlRolePermitionDao;
import com.hekai.backend.service.BasicRlRolePermitionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 角色与权限对应(BasicRlRolePermition)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:02
 */
@Service("basicRlRolePermitionService")
public class BasicRlRolePermitionServiceImpl implements BasicRlRolePermitionService {
    @Resource
    private BasicRlRolePermitionDao basicRlRolePermitionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BasicRlRolePermition queryById(Integer id) {
        return this.basicRlRolePermitionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param basicRlRolePermition 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BasicRlRolePermition> queryByPage(BasicRlRolePermition basicRlRolePermition, PageRequest pageRequest) {
        long total = this.basicRlRolePermitionDao.count(basicRlRolePermition);
        return new PageImpl<>(this.basicRlRolePermitionDao.queryAllByLimit(basicRlRolePermition, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param basicRlRolePermition 实例对象
     * @return 实例对象
     */
    @Override
    public BasicRlRolePermition insert(BasicRlRolePermition basicRlRolePermition) {
        this.basicRlRolePermitionDao.insert(basicRlRolePermition);
        return basicRlRolePermition;
    }

    /**
     * 修改数据
     *
     * @param basicRlRolePermition 实例对象
     * @return 实例对象
     */
    @Override
    public BasicRlRolePermition update(BasicRlRolePermition basicRlRolePermition) {
        this.basicRlRolePermitionDao.update(basicRlRolePermition);
        return this.queryById(basicRlRolePermition.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.basicRlRolePermitionDao.deleteById(id) > 0;
    }
}
