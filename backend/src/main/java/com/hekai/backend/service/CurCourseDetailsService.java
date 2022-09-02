package com.hekai.backend.service;

import com.hekai.backend.entity.CurCourseDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 订单详情表(CurCourseDetails)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CurCourseDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CurCourseDetails queryById(Integer id);

    /**
     * 分页查询
     *
     * @param curCourseDetails 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CurCourseDetails> queryByPage(CurCourseDetails curCourseDetails, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param curCourseDetails 实例对象
     * @return 实例对象
     */
    CurCourseDetails insert(CurCourseDetails curCourseDetails);

    /**
     * 修改数据
     *
     * @param curCourseDetails 实例对象
     * @return 实例对象
     */
    CurCourseDetails update(CurCourseDetails curCourseDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
