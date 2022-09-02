package com.hekai.backend.service;

import com.hekai.backend.entity.BasicRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 角色(BasicRole)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:19
 */
public interface BasicRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BasicRole queryById(Integer id);

    /**
     * 分页查询
     *
     * @param basicRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BasicRole> queryByPage(BasicRole basicRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param basicRole 实例对象
     * @return 实例对象
     */
    BasicRole insert(BasicRole basicRole);

    /**
     * 修改数据
     *
     * @param basicRole 实例对象
     * @return 实例对象
     */
    BasicRole update(BasicRole basicRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
