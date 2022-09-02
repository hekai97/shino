package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CfgNavConfig;
import com.hekai.backend.dao.CfgNavConfigDao;
import com.hekai.backend.service.CfgNavConfigService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 导航配置(CfgNavConfig)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:02
 */
@Service("cfgNavConfigService")
public class CfgNavConfigServiceImpl implements CfgNavConfigService {
    @Resource
    private CfgNavConfigDao cfgNavConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CfgNavConfig queryById(Integer id) {
        return this.cfgNavConfigDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param cfgNavConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CfgNavConfig> queryByPage(CfgNavConfig cfgNavConfig, PageRequest pageRequest) {
        long total = this.cfgNavConfigDao.count(cfgNavConfig);
        return new PageImpl<>(this.cfgNavConfigDao.queryAllByLimit(cfgNavConfig, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cfgNavConfig 实例对象
     * @return 实例对象
     */
    @Override
    public CfgNavConfig insert(CfgNavConfig cfgNavConfig) {
        this.cfgNavConfigDao.insert(cfgNavConfig);
        return cfgNavConfig;
    }

    /**
     * 修改数据
     *
     * @param cfgNavConfig 实例对象
     * @return 实例对象
     */
    @Override
    public CfgNavConfig update(CfgNavConfig cfgNavConfig) {
        this.cfgNavConfigDao.update(cfgNavConfig);
        return this.queryById(cfgNavConfig.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.cfgNavConfigDao.deleteById(id) > 0;
    }
}
