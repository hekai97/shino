package com.hekai.backend.service.impl;

import com.hekai.backend.entity.OrdOrderInfo;
import com.hekai.backend.dao.OrdOrderInfoDao;
import com.hekai.backend.service.OrdOrderInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 订单信息(OrdOrderInfo)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("ordOrderInfoService")
public class OrdOrderInfoServiceImpl implements OrdOrderInfoService {
    @Resource
    private OrdOrderInfoDao ordOrderInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrdOrderInfo queryById(Integer id) {
        return this.ordOrderInfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param ordOrderInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<OrdOrderInfo> queryByPage(OrdOrderInfo ordOrderInfo, PageRequest pageRequest) {
        long total = this.ordOrderInfoDao.count(ordOrderInfo);
        return new PageImpl<>(this.ordOrderInfoDao.queryAllByLimit(ordOrderInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ordOrderInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OrdOrderInfo insert(OrdOrderInfo ordOrderInfo) {
        this.ordOrderInfoDao.insert(ordOrderInfo);
        return ordOrderInfo;
    }

    /**
     * 修改数据
     *
     * @param ordOrderInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OrdOrderInfo update(OrdOrderInfo ordOrderInfo) {
        this.ordOrderInfoDao.update(ordOrderInfo);
        return this.queryById(ordOrderInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.ordOrderInfoDao.deleteById(id) > 0;
    }
}
