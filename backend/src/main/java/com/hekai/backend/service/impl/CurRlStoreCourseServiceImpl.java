package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CurRlStoreCourse;
import com.hekai.backend.dao.CurRlStoreCourseDao;
import com.hekai.backend.service.CurRlStoreCourseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 门店课程关系表(CurRlStoreCourse)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("curRlStoreCourseService")
public class CurRlStoreCourseServiceImpl implements CurRlStoreCourseService {
    @Resource
    private CurRlStoreCourseDao curRlStoreCourseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CurRlStoreCourse queryById(Integer id) {
        return this.curRlStoreCourseDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param curRlStoreCourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CurRlStoreCourse> queryByPage(CurRlStoreCourse curRlStoreCourse, PageRequest pageRequest) {
        long total = this.curRlStoreCourseDao.count(curRlStoreCourse);
        return new PageImpl<>(this.curRlStoreCourseDao.queryAllByLimit(curRlStoreCourse, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param curRlStoreCourse 实例对象
     * @return 实例对象
     */
    @Override
    public CurRlStoreCourse insert(CurRlStoreCourse curRlStoreCourse) {
        this.curRlStoreCourseDao.insert(curRlStoreCourse);
        return curRlStoreCourse;
    }

    /**
     * 修改数据
     *
     * @param curRlStoreCourse 实例对象
     * @return 实例对象
     */
    @Override
    public CurRlStoreCourse update(CurRlStoreCourse curRlStoreCourse) {
        this.curRlStoreCourseDao.update(curRlStoreCourse);
        return this.queryById(curRlStoreCourse.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.curRlStoreCourseDao.deleteById(id) > 0;
    }
}
