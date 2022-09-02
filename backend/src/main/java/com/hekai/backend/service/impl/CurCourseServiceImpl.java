package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CurCourse;
import com.hekai.backend.dao.CurCourseDao;
import com.hekai.backend.service.CurCourseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 课程(CurCourse)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("curCourseService")
public class CurCourseServiceImpl implements CurCourseService {
    @Resource
    private CurCourseDao curCourseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CurCourse queryById(Integer id) {
        return this.curCourseDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param curCourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CurCourse> queryByPage(CurCourse curCourse, PageRequest pageRequest) {
        long total = this.curCourseDao.count(curCourse);
        return new PageImpl<>(this.curCourseDao.queryAllByLimit(curCourse, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param curCourse 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourse insert(CurCourse curCourse) {
        this.curCourseDao.insert(curCourse);
        return curCourse;
    }

    /**
     * 修改数据
     *
     * @param curCourse 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourse update(CurCourse curCourse) {
        this.curCourseDao.update(curCourse);
        return this.queryById(curCourse.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.curCourseDao.deleteById(id) > 0;
    }
}
