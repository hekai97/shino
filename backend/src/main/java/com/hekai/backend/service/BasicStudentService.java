package com.hekai.backend.service;

import com.hekai.backend.entity.BasicStudent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 学员信息(BasicStudent)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:19
 */
public interface BasicStudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BasicStudent queryById(Integer id);

    /**
     * 分页查询
     *
     * @param basicStudent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BasicStudent> queryByPage(BasicStudent basicStudent, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param basicStudent 实例对象
     * @return 实例对象
     */
    BasicStudent insert(BasicStudent basicStudent);

    /**
     * 修改数据
     *
     * @param basicStudent 实例对象
     * @return 实例对象
     */
    BasicStudent update(BasicStudent basicStudent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
