package com.hekai.backend.service.impl;

import com.hekai.backend.entity.OrdReserve;
import com.hekai.backend.dao.OrdReserveDao;
import com.hekai.backend.service.OrdReserveService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 预约(OrdReserve)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("ordReserveService")
public class OrdReserveServiceImpl implements OrdReserveService {
    @Resource
    private OrdReserveDao ordReserveDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrdReserve queryById(Integer id) {
        return this.ordReserveDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param ordReserve 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<OrdReserve> queryByPage(OrdReserve ordReserve, PageRequest pageRequest) {
        long total = this.ordReserveDao.count(ordReserve);
        return new PageImpl<>(this.ordReserveDao.queryAllByLimit(ordReserve, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ordReserve 实例对象
     * @return 实例对象
     */
    @Override
    public OrdReserve insert(OrdReserve ordReserve) {
        this.ordReserveDao.insert(ordReserve);
        return ordReserve;
    }

    /**
     * 修改数据
     *
     * @param ordReserve 实例对象
     * @return 实例对象
     */
    @Override
    public OrdReserve update(OrdReserve ordReserve) {
        this.ordReserveDao.update(ordReserve);
        return this.queryById(ordReserve.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.ordReserveDao.deleteById(id) > 0;
    }
}
