package com.hekai.backend.service;

import com.hekai.backend.entity.CurRlStoreCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 门店课程关系表(CurRlStoreCourse)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CurRlStoreCourseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CurRlStoreCourse queryById(Integer id);

    /**
     * 分页查询
     *
     * @param curRlStoreCourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CurRlStoreCourse> queryByPage(CurRlStoreCourse curRlStoreCourse, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param curRlStoreCourse 实例对象
     * @return 实例对象
     */
    CurRlStoreCourse insert(CurRlStoreCourse curRlStoreCourse);

    /**
     * 修改数据
     *
     * @param curRlStoreCourse 实例对象
     * @return 实例对象
     */
    CurRlStoreCourse update(CurRlStoreCourse curRlStoreCourse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
