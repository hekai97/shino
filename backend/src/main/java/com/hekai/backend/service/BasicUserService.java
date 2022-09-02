package com.hekai.backend.service;

import com.hekai.backend.entity.BasicUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户(BasicUser)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:19
 */
public interface BasicUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BasicUser queryById(Integer id);

    /**
     * 分页查询
     *
     * @param basicUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BasicUser> queryByPage(BasicUser basicUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param basicUser 实例对象
     * @return 实例对象
     */
    BasicUser insert(BasicUser basicUser);

    /**
     * 修改数据
     *
     * @param basicUser 实例对象
     * @return 实例对象
     */
    BasicUser update(BasicUser basicUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
