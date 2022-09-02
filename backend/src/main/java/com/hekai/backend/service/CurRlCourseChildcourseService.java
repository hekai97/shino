package com.hekai.backend.service;

import com.hekai.backend.entity.CurRlCourseChildcourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 套餐课配置(CurRlCourseChildcourse)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CurRlCourseChildcourseService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    CurRlCourseChildcourse queryById( );

    /**
     * 分页查询
     *
     * @param curRlCourseChildcourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CurRlCourseChildcourse> queryByPage(CurRlCourseChildcourse curRlCourseChildcourse, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param curRlCourseChildcourse 实例对象
     * @return 实例对象
     */
    CurRlCourseChildcourse insert(CurRlCourseChildcourse curRlCourseChildcourse);

    /**
     * 修改数据
     *
     * @param curRlCourseChildcourse 实例对象
     * @return 实例对象
     */
    CurRlCourseChildcourse update(CurRlCourseChildcourse curRlCourseChildcourse);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    boolean deleteById( );

}
