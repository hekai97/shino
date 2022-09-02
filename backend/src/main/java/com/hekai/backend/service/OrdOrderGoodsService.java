package com.hekai.backend.service;

import com.hekai.backend.entity.OrdOrderGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 订单课程信息(OrdOrderGoods)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface OrdOrderGoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrdOrderGoods queryById(Integer id);

    /**
     * 分页查询
     *
     * @param ordOrderGoods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<OrdOrderGoods> queryByPage(OrdOrderGoods ordOrderGoods, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ordOrderGoods 实例对象
     * @return 实例对象
     */
    OrdOrderGoods insert(OrdOrderGoods ordOrderGoods);

    /**
     * 修改数据
     *
     * @param ordOrderGoods 实例对象
     * @return 实例对象
     */
    OrdOrderGoods update(OrdOrderGoods ordOrderGoods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
