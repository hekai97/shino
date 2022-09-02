package com.hekai.backend.service;

import com.hekai.backend.entity.OrdOrderInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 订单信息(OrdOrderInfo)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface OrdOrderInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrdOrderInfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param ordOrderInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<OrdOrderInfo> queryByPage(OrdOrderInfo ordOrderInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ordOrderInfo 实例对象
     * @return 实例对象
     */
    OrdOrderInfo insert(OrdOrderInfo ordOrderInfo);

    /**
     * 修改数据
     *
     * @param ordOrderInfo 实例对象
     * @return 实例对象
     */
    OrdOrderInfo update(OrdOrderInfo ordOrderInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
