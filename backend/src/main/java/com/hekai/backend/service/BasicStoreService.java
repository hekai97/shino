package com.hekai.backend.service;

import com.hekai.backend.entity.BasicStore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 门店(BasicStore)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:19
 */
public interface BasicStoreService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BasicStore queryById(Integer id);

    /**
     * 分页查询
     *
     * @param basicStore 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BasicStore> queryByPage(BasicStore basicStore, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param basicStore 实例对象
     * @return 实例对象
     */
    BasicStore insert(BasicStore basicStore);

    /**
     * 修改数据
     *
     * @param basicStore 实例对象
     * @return 实例对象
     */
    BasicStore update(BasicStore basicStore);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
