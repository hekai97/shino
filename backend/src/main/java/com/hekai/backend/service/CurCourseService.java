package com.hekai.backend.service;

import com.hekai.backend.entity.CurCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 课程(CurCourse)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CurCourseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CurCourse queryById(Integer id);

    /**
     * 分页查询
     *
     * @param curCourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CurCourse> queryByPage(CurCourse curCourse, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param curCourse 实例对象
     * @return 实例对象
     */
    CurCourse insert(CurCourse curCourse);

    /**
     * 修改数据
     *
     * @param curCourse 实例对象
     * @return 实例对象
     */
    CurCourse update(CurCourse curCourse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
