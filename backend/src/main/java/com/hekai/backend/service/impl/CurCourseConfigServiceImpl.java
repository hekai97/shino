package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CurCourseConfig;
import com.hekai.backend.dao.CurCourseConfigDao;
import com.hekai.backend.service.CurCourseConfigService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 课程配置(CurCourseConfig)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("curCourseConfigService")
public class CurCourseConfigServiceImpl implements CurCourseConfigService {
    @Resource
    private CurCourseConfigDao curCourseConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CurCourseConfig queryById(Integer id) {
        return this.curCourseConfigDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param curCourseConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CurCourseConfig> queryByPage(CurCourseConfig curCourseConfig, PageRequest pageRequest) {
        long total = this.curCourseConfigDao.count(curCourseConfig);
        return new PageImpl<>(this.curCourseConfigDao.queryAllByLimit(curCourseConfig, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param curCourseConfig 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourseConfig insert(CurCourseConfig curCourseConfig) {
        this.curCourseConfigDao.insert(curCourseConfig);
        return curCourseConfig;
    }

    /**
     * 修改数据
     *
     * @param curCourseConfig 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourseConfig update(CurCourseConfig curCourseConfig) {
        this.curCourseConfigDao.update(curCourseConfig);
        return this.queryById(curCourseConfig.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.curCourseConfigDao.deleteById(id) > 0;
    }
}
