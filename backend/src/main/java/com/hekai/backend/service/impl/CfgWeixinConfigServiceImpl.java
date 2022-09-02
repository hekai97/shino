package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CfgWeixinConfig;
import com.hekai.backend.dao.CfgWeixinConfigDao;
import com.hekai.backend.service.CfgWeixinConfigService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 微信支付接口配置(CfgWeixinConfig)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("cfgWeixinConfigService")
public class CfgWeixinConfigServiceImpl implements CfgWeixinConfigService {
    @Resource
    private CfgWeixinConfigDao cfgWeixinConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CfgWeixinConfig queryById(Integer id) {
        return this.cfgWeixinConfigDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param cfgWeixinConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CfgWeixinConfig> queryByPage(CfgWeixinConfig cfgWeixinConfig, PageRequest pageRequest) {
        long total = this.cfgWeixinConfigDao.count(cfgWeixinConfig);
        return new PageImpl<>(this.cfgWeixinConfigDao.queryAllByLimit(cfgWeixinConfig, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cfgWeixinConfig 实例对象
     * @return 实例对象
     */
    @Override
    public CfgWeixinConfig insert(CfgWeixinConfig cfgWeixinConfig) {
        this.cfgWeixinConfigDao.insert(cfgWeixinConfig);
        return cfgWeixinConfig;
    }

    /**
     * 修改数据
     *
     * @param cfgWeixinConfig 实例对象
     * @return 实例对象
     */
    @Override
    public CfgWeixinConfig update(CfgWeixinConfig cfgWeixinConfig) {
        this.cfgWeixinConfigDao.update(cfgWeixinConfig);
        return this.queryById(cfgWeixinConfig.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.cfgWeixinConfigDao.deleteById(id) > 0;
    }
}
