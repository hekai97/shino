package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CfgVideoConfig;
import com.hekai.backend.dao.CfgVideoConfigDao;
import com.hekai.backend.service.CfgVideoConfigService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 视频位置配置(CfgVideoConfig)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:02
 */
@Service("cfgVideoConfigService")
public class CfgVideoConfigServiceImpl implements CfgVideoConfigService {
    @Resource
    private CfgVideoConfigDao cfgVideoConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CfgVideoConfig queryById(Integer id) {
        return this.cfgVideoConfigDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param cfgVideoConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CfgVideoConfig> queryByPage(CfgVideoConfig cfgVideoConfig, PageRequest pageRequest) {
        long total = this.cfgVideoConfigDao.count(cfgVideoConfig);
        return new PageImpl<>(this.cfgVideoConfigDao.queryAllByLimit(cfgVideoConfig, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cfgVideoConfig 实例对象
     * @return 实例对象
     */
    @Override
    public CfgVideoConfig insert(CfgVideoConfig cfgVideoConfig) {
        this.cfgVideoConfigDao.insert(cfgVideoConfig);
        return cfgVideoConfig;
    }

    /**
     * 修改数据
     *
     * @param cfgVideoConfig 实例对象
     * @return 实例对象
     */
    @Override
    public CfgVideoConfig update(CfgVideoConfig cfgVideoConfig) {
        this.cfgVideoConfigDao.update(cfgVideoConfig);
        return this.queryById(cfgVideoConfig.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.cfgVideoConfigDao.deleteById(id) > 0;
    }
}
