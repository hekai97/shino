package com.hekai.backend.service;

import com.hekai.backend.entity.Loginlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 登陆记录表(Loginlog)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface LoginlogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Loginlog queryById(Integer id);

    /**
     * 分页查询
     *
     * @param loginlog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Loginlog> queryByPage(Loginlog loginlog, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param loginlog 实例对象
     * @return 实例对象
     */
    Loginlog insert(Loginlog loginlog);

    /**
     * 修改数据
     *
     * @param loginlog 实例对象
     * @return 实例对象
     */
    Loginlog update(Loginlog loginlog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
