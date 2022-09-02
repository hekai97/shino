package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CurCourseTable;
import com.hekai.backend.dao.CurCourseTableDao;
import com.hekai.backend.service.CurCourseTableService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 排课表(CurCourseTable)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("curCourseTableService")
public class CurCourseTableServiceImpl implements CurCourseTableService {
    @Resource
    private CurCourseTableDao curCourseTableDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CurCourseTable queryById(Integer id) {
        return this.curCourseTableDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param curCourseTable 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CurCourseTable> queryByPage(CurCourseTable curCourseTable, PageRequest pageRequest) {
        long total = this.curCourseTableDao.count(curCourseTable);
        return new PageImpl<>(this.curCourseTableDao.queryAllByLimit(curCourseTable, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param curCourseTable 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourseTable insert(CurCourseTable curCourseTable) {
        this.curCourseTableDao.insert(curCourseTable);
        return curCourseTable;
    }

    /**
     * 修改数据
     *
     * @param curCourseTable 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourseTable update(CurCourseTable curCourseTable) {
        this.curCourseTableDao.update(curCourseTable);
        return this.queryById(curCourseTable.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.curCourseTableDao.deleteById(id) > 0;
    }
}
