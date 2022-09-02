package com.hekai.backend.service.impl;

import com.hekai.backend.entity.BasicStore;
import com.hekai.backend.dao.BasicStoreDao;
import com.hekai.backend.service.BasicStoreService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 门店(BasicStore)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:02
 */
@Service("basicStoreService")
public class BasicStoreServiceImpl implements BasicStoreService {
    @Resource
    private BasicStoreDao basicStoreDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BasicStore queryById(Integer id) {
        return this.basicStoreDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param basicStore 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BasicStore> queryByPage(BasicStore basicStore, PageRequest pageRequest) {
        long total = this.basicStoreDao.count(basicStore);
        return new PageImpl<>(this.basicStoreDao.queryAllByLimit(basicStore, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param basicStore 实例对象
     * @return 实例对象
     */
    @Override
    public BasicStore insert(BasicStore basicStore) {
        this.basicStoreDao.insert(basicStore);
        return basicStore;
    }

    /**
     * 修改数据
     *
     * @param basicStore 实例对象
     * @return 实例对象
     */
    @Override
    public BasicStore update(BasicStore basicStore) {
        this.basicStoreDao.update(basicStore);
        return this.queryById(basicStore.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.basicStoreDao.deleteById(id) > 0;
    }
}
