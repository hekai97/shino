package com.hekai.backend.service;

import com.hekai.backend.entity.BasicRlRolePermition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 角色与权限对应(BasicRlRolePermition)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:19
 */
public interface BasicRlRolePermitionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BasicRlRolePermition queryById(Integer id);

    /**
     * 分页查询
     *
     * @param basicRlRolePermition 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BasicRlRolePermition> queryByPage(BasicRlRolePermition basicRlRolePermition, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param basicRlRolePermition 实例对象
     * @return 实例对象
     */
    BasicRlRolePermition insert(BasicRlRolePermition basicRlRolePermition);

    /**
     * 修改数据
     *
     * @param basicRlRolePermition 实例对象
     * @return 实例对象
     */
    BasicRlRolePermition update(BasicRlRolePermition basicRlRolePermition);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
