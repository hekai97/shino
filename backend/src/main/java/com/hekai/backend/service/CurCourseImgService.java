package com.hekai.backend.service;

import com.hekai.backend.entity.CurCourseImg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (CurCourseImg)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CurCourseImgService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CurCourseImg queryById(Integer id);

    /**
     * 分页查询
     *
     * @param curCourseImg 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CurCourseImg> queryByPage(CurCourseImg curCourseImg, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param curCourseImg 实例对象
     * @return 实例对象
     */
    CurCourseImg insert(CurCourseImg curCourseImg);

    /**
     * 修改数据
     *
     * @param curCourseImg 实例对象
     * @return 实例对象
     */
    CurCourseImg update(CurCourseImg curCourseImg);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
