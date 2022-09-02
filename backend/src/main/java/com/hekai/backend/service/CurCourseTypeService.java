package com.hekai.backend.service;

import com.hekai.backend.entity.CurCourseType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 课程分类(CurCourseType)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CurCourseTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CurCourseType queryById(Integer id);

    /**
     * 分页查询
     *
     * @param curCourseType 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CurCourseType> queryByPage(CurCourseType curCourseType, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param curCourseType 实例对象
     * @return 实例对象
     */
    CurCourseType insert(CurCourseType curCourseType);

    /**
     * 修改数据
     *
     * @param curCourseType 实例对象
     * @return 实例对象
     */
    CurCourseType update(CurCourseType curCourseType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
