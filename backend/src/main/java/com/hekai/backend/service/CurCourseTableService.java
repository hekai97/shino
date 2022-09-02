package com.hekai.backend.service;

import com.hekai.backend.entity.CurCourseTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 排课表(CurCourseTable)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CurCourseTableService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CurCourseTable queryById(Integer id);

    /**
     * 分页查询
     *
     * @param curCourseTable 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CurCourseTable> queryByPage(CurCourseTable curCourseTable, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param curCourseTable 实例对象
     * @return 实例对象
     */
    CurCourseTable insert(CurCourseTable curCourseTable);

    /**
     * 修改数据
     *
     * @param curCourseTable 实例对象
     * @return 实例对象
     */
    CurCourseTable update(CurCourseTable curCourseTable);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
