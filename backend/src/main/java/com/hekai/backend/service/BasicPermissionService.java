package com.hekai.backend.service;

import com.hekai.backend.entity.BasicPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 权限(BasicPermission)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:19
 */
public interface BasicPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BasicPermission queryById(Integer id);

    /**
     * 分页查询
     *
     * @param basicPermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BasicPermission> queryByPage(BasicPermission basicPermission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param basicPermission 实例对象
     * @return 实例对象
     */
    BasicPermission insert(BasicPermission basicPermission);

    /**
     * 修改数据
     *
     * @param basicPermission 实例对象
     * @return 实例对象
     */
    BasicPermission update(BasicPermission basicPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
