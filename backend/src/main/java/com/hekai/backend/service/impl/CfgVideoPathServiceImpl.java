package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CfgVideoPath;
import com.hekai.backend.dao.CfgVideoPathDao;
import com.hekai.backend.service.CfgVideoPathService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 视频存放路径(CfgVideoPath)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:02
 */
@Service("cfgVideoPathService")
public class CfgVideoPathServiceImpl implements CfgVideoPathService {
    @Resource
    private CfgVideoPathDao cfgVideoPathDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CfgVideoPath queryById(Integer id) {
        return this.cfgVideoPathDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param cfgVideoPath 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CfgVideoPath> queryByPage(CfgVideoPath cfgVideoPath, PageRequest pageRequest) {
        long total = this.cfgVideoPathDao.count(cfgVideoPath);
        return new PageImpl<>(this.cfgVideoPathDao.queryAllByLimit(cfgVideoPath, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cfgVideoPath 实例对象
     * @return 实例对象
     */
    @Override
    public CfgVideoPath insert(CfgVideoPath cfgVideoPath) {
        this.cfgVideoPathDao.insert(cfgVideoPath);
        return cfgVideoPath;
    }

    /**
     * 修改数据
     *
     * @param cfgVideoPath 实例对象
     * @return 实例对象
     */
    @Override
    public CfgVideoPath update(CfgVideoPath cfgVideoPath) {
        this.cfgVideoPathDao.update(cfgVideoPath);
        return this.queryById(cfgVideoPath.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.cfgVideoPathDao.deleteById(id) > 0;
    }
}
