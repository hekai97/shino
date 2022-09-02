package com.hekai.backend.service;

import com.hekai.backend.entity.Suggested;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 建议反馈(Suggested)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface SuggestedService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Suggested queryById(Integer id);

    /**
     * 分页查询
     *
     * @param suggested 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Suggested> queryByPage(Suggested suggested, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param suggested 实例对象
     * @return 实例对象
     */
    Suggested insert(Suggested suggested);

    /**
     * 修改数据
     *
     * @param suggested 实例对象
     * @return 实例对象
     */
    Suggested update(Suggested suggested);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
