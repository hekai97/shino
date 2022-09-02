package com.hekai.backend.service;

import com.hekai.backend.entity.OrdReserve;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 预约(OrdReserve)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface OrdReserveService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrdReserve queryById(Integer id);

    /**
     * 分页查询
     *
     * @param ordReserve 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<OrdReserve> queryByPage(OrdReserve ordReserve, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ordReserve 实例对象
     * @return 实例对象
     */
    OrdReserve insert(OrdReserve ordReserve);

    /**
     * 修改数据
     *
     * @param ordReserve 实例对象
     * @return 实例对象
     */
    OrdReserve update(OrdReserve ordReserve);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
