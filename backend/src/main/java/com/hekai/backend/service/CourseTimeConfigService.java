package com.hekai.backend.service;

import com.hekai.backend.entity.CourseTimeConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 上课时间配置(CourseTimeConfig)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CourseTimeConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CourseTimeConfig queryById(Integer id);

    /**
     * 分页查询
     *
     * @param courseTimeConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CourseTimeConfig> queryByPage(CourseTimeConfig courseTimeConfig, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param courseTimeConfig 实例对象
     * @return 实例对象
     */
    CourseTimeConfig insert(CourseTimeConfig courseTimeConfig);

    /**
     * 修改数据
     *
     * @param courseTimeConfig 实例对象
     * @return 实例对象
     */
    CourseTimeConfig update(CourseTimeConfig courseTimeConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
