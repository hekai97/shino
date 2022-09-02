package com.hekai.backend.service;

import com.hekai.backend.entity.BasicTeacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 讲师信息(BasicTeacher)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:19
 */
public interface BasicTeacherService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BasicTeacher queryById(Integer id);

    /**
     * 分页查询
     *
     * @param basicTeacher 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BasicTeacher> queryByPage(BasicTeacher basicTeacher, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param basicTeacher 实例对象
     * @return 实例对象
     */
    BasicTeacher insert(BasicTeacher basicTeacher);

    /**
     * 修改数据
     *
     * @param basicTeacher 实例对象
     * @return 实例对象
     */
    BasicTeacher update(BasicTeacher basicTeacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
