package com.hekai.backend.service;

import com.hekai.backend.entity.CurCourseConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 课程配置(CurCourseConfig)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CurCourseConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CurCourseConfig queryById(Integer id);

    /**
     * 分页查询
     *
     * @param curCourseConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CurCourseConfig> queryByPage(CurCourseConfig curCourseConfig, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param curCourseConfig 实例对象
     * @return 实例对象
     */
    CurCourseConfig insert(CurCourseConfig curCourseConfig);

    /**
     * 修改数据
     *
     * @param curCourseConfig 实例对象
     * @return 实例对象
     */
    CurCourseConfig update(CurCourseConfig curCourseConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
