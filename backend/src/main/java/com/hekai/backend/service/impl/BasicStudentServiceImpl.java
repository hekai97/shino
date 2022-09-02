package com.hekai.backend.service.impl;

import com.hekai.backend.entity.BasicStudent;
import com.hekai.backend.dao.BasicStudentDao;
import com.hekai.backend.service.BasicStudentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 学员信息(BasicStudent)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:02
 */
@Service("basicStudentService")
public class BasicStudentServiceImpl implements BasicStudentService {
    @Resource
    private BasicStudentDao basicStudentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BasicStudent queryById(Integer id) {
        return this.basicStudentDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param basicStudent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BasicStudent> queryByPage(BasicStudent basicStudent, PageRequest pageRequest) {
        long total = this.basicStudentDao.count(basicStudent);
        return new PageImpl<>(this.basicStudentDao.queryAllByLimit(basicStudent, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param basicStudent 实例对象
     * @return 实例对象
     */
    @Override
    public BasicStudent insert(BasicStudent basicStudent) {
        this.basicStudentDao.insert(basicStudent);
        return basicStudent;
    }

    /**
     * 修改数据
     *
     * @param basicStudent 实例对象
     * @return 实例对象
     */
    @Override
    public BasicStudent update(BasicStudent basicStudent) {
        this.basicStudentDao.update(basicStudent);
        return this.queryById(basicStudent.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.basicStudentDao.deleteById(id) > 0;
    }
}
