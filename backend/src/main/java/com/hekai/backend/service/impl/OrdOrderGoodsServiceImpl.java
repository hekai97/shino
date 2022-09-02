package com.hekai.backend.service.impl;

import com.hekai.backend.entity.OrdOrderGoods;
import com.hekai.backend.dao.OrdOrderGoodsDao;
import com.hekai.backend.service.OrdOrderGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 订单课程信息(OrdOrderGoods)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("ordOrderGoodsService")
public class OrdOrderGoodsServiceImpl implements OrdOrderGoodsService {
    @Resource
    private OrdOrderGoodsDao ordOrderGoodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrdOrderGoods queryById(Integer id) {
        return this.ordOrderGoodsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param ordOrderGoods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<OrdOrderGoods> queryByPage(OrdOrderGoods ordOrderGoods, PageRequest pageRequest) {
        long total = this.ordOrderGoodsDao.count(ordOrderGoods);
        return new PageImpl<>(this.ordOrderGoodsDao.queryAllByLimit(ordOrderGoods, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ordOrderGoods 实例对象
     * @return 实例对象
     */
    @Override
    public OrdOrderGoods insert(OrdOrderGoods ordOrderGoods) {
        this.ordOrderGoodsDao.insert(ordOrderGoods);
        return ordOrderGoods;
    }

    /**
     * 修改数据
     *
     * @param ordOrderGoods 实例对象
     * @return 实例对象
     */
    @Override
    public OrdOrderGoods update(OrdOrderGoods ordOrderGoods) {
        this.ordOrderGoodsDao.update(ordOrderGoods);
        return this.queryById(ordOrderGoods.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.ordOrderGoodsDao.deleteById(id) > 0;
    }
}
