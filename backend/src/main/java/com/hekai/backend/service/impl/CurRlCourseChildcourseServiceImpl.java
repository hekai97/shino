package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CurRlCourseChildcourse;
import com.hekai.backend.dao.CurRlCourseChildcourseDao;
import com.hekai.backend.service.CurRlCourseChildcourseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 套餐课配置(CurRlCourseChildcourse)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("curRlCourseChildcourseService")
public class CurRlCourseChildcourseServiceImpl implements CurRlCourseChildcourseService {
    @Resource
    private CurRlCourseChildcourseDao curRlCourseChildcourseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    @Override
    public CurRlCourseChildcourse queryById( ) {
        return this.curRlCourseChildcourseDao.queryById();
    }

    /**
     * 分页查询
     *
     * @param curRlCourseChildcourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CurRlCourseChildcourse> queryByPage(CurRlCourseChildcourse curRlCourseChildcourse, PageRequest pageRequest) {
        long total = this.curRlCourseChildcourseDao.count(curRlCourseChildcourse);
        return new PageImpl<>(this.curRlCourseChildcourseDao.queryAllByLimit(curRlCourseChildcourse, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param curRlCourseChildcourse 实例对象
     * @return 实例对象
     */
    @Override
    public CurRlCourseChildcourse insert(CurRlCourseChildcourse curRlCourseChildcourse) {
        this.curRlCourseChildcourseDao.insert(curRlCourseChildcourse);
        return curRlCourseChildcourse;
    }

    /**
     * 修改数据
     *
     * @param curRlCourseChildcourse 实例对象
     * @return 实例对象
     */
    @Override
    public CurRlCourseChildcourse update(CurRlCourseChildcourse curRlCourseChildcourse) {
        this.curRlCourseChildcourseDao.update(curRlCourseChildcourse);
        return this.queryById(curRlCourseChildcourse.get());
    }

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.curRlCourseChildcourseDao.deleteById() > 0;
    }
}
