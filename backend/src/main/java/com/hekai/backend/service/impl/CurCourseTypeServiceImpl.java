package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CurCourseType;
import com.hekai.backend.dao.CurCourseTypeDao;
import com.hekai.backend.service.CurCourseTypeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 课程分类(CurCourseType)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("curCourseTypeService")
public class CurCourseTypeServiceImpl implements CurCourseTypeService {
    @Resource
    private CurCourseTypeDao curCourseTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CurCourseType queryById(Integer id) {
        return this.curCourseTypeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param curCourseType 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CurCourseType> queryByPage(CurCourseType curCourseType, PageRequest pageRequest) {
        long total = this.curCourseTypeDao.count(curCourseType);
        return new PageImpl<>(this.curCourseTypeDao.queryAllByLimit(curCourseType, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param curCourseType 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourseType insert(CurCourseType curCourseType) {
        this.curCourseTypeDao.insert(curCourseType);
        return curCourseType;
    }

    /**
     * 修改数据
     *
     * @param curCourseType 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourseType update(CurCourseType curCourseType) {
        this.curCourseTypeDao.update(curCourseType);
        return this.queryById(curCourseType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.curCourseTypeDao.deleteById(id) > 0;
    }
}
