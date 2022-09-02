package com.hekai.backend.service;

import com.hekai.backend.entity.BasicPermissionPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 权限页面(BasicPermissionPage)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:19
 */
public interface BasicPermissionPageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BasicPermissionPage queryById(Integer id);

    /**
     * 分页查询
     *
     * @param basicPermissionPage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BasicPermissionPage> queryByPage(BasicPermissionPage basicPermissionPage, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param basicPermissionPage 实例对象
     * @return 实例对象
     */
    BasicPermissionPage insert(BasicPermissionPage basicPermissionPage);

    /**
     * 修改数据
     *
     * @param basicPermissionPage 实例对象
     * @return 实例对象
     */
    BasicPermissionPage update(BasicPermissionPage basicPermissionPage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
