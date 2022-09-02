package com.hekai.backend.service.impl;

import com.hekai.backend.entity.BasicTeacher;
import com.hekai.backend.dao.BasicTeacherDao;
import com.hekai.backend.service.BasicTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 讲师信息(BasicTeacher)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:02
 */
@Service("basicTeacherService")
public class BasicTeacherServiceImpl implements BasicTeacherService {
    @Resource
    private BasicTeacherDao basicTeacherDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BasicTeacher queryById(Integer id) {
        return this.basicTeacherDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param basicTeacher 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BasicTeacher> queryByPage(BasicTeacher basicTeacher, PageRequest pageRequest) {
        long total = this.basicTeacherDao.count(basicTeacher);
        return new PageImpl<>(this.basicTeacherDao.queryAllByLimit(basicTeacher, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param basicTeacher 实例对象
     * @return 实例对象
     */
    @Override
    public BasicTeacher insert(BasicTeacher basicTeacher) {
        this.basicTeacherDao.insert(basicTeacher);
        return basicTeacher;
    }

    /**
     * 修改数据
     *
     * @param basicTeacher 实例对象
     * @return 实例对象
     */
    @Override
    public BasicTeacher update(BasicTeacher basicTeacher) {
        this.basicTeacherDao.update(basicTeacher);
        return this.queryById(basicTeacher.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.basicTeacherDao.deleteById(id) > 0;
    }
}
