package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CourseTimeConfig;
import com.hekai.backend.dao.CourseTimeConfigDao;
import com.hekai.backend.service.CourseTimeConfigService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 上课时间配置(CourseTimeConfig)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("courseTimeConfigService")
public class CourseTimeConfigServiceImpl implements CourseTimeConfigService {
    @Resource
    private CourseTimeConfigDao courseTimeConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CourseTimeConfig queryById(Integer id) {
        return this.courseTimeConfigDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param courseTimeConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CourseTimeConfig> queryByPage(CourseTimeConfig courseTimeConfig, PageRequest pageRequest) {
        long total = this.courseTimeConfigDao.count(courseTimeConfig);
        return new PageImpl<>(this.courseTimeConfigDao.queryAllByLimit(courseTimeConfig, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param courseTimeConfig 实例对象
     * @return 实例对象
     */
    @Override
    public CourseTimeConfig insert(CourseTimeConfig courseTimeConfig) {
        this.courseTimeConfigDao.insert(courseTimeConfig);
        return courseTimeConfig;
    }

    /**
     * 修改数据
     *
     * @param courseTimeConfig 实例对象
     * @return 实例对象
     */
    @Override
    public CourseTimeConfig update(CourseTimeConfig courseTimeConfig) {
        this.courseTimeConfigDao.update(courseTimeConfig);
        return this.queryById(courseTimeConfig.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.courseTimeConfigDao.deleteById(id) > 0;
    }
}
