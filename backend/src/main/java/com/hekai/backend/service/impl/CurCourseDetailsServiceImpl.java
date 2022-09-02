package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CurCourseDetails;
import com.hekai.backend.dao.CurCourseDetailsDao;
import com.hekai.backend.service.CurCourseDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 订单详情表(CurCourseDetails)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("curCourseDetailsService")
public class CurCourseDetailsServiceImpl implements CurCourseDetailsService {
    @Resource
    private CurCourseDetailsDao curCourseDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CurCourseDetails queryById(Integer id) {
        return this.curCourseDetailsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param curCourseDetails 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CurCourseDetails> queryByPage(CurCourseDetails curCourseDetails, PageRequest pageRequest) {
        long total = this.curCourseDetailsDao.count(curCourseDetails);
        return new PageImpl<>(this.curCourseDetailsDao.queryAllByLimit(curCourseDetails, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param curCourseDetails 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourseDetails insert(CurCourseDetails curCourseDetails) {
        this.curCourseDetailsDao.insert(curCourseDetails);
        return curCourseDetails;
    }

    /**
     * 修改数据
     *
     * @param curCourseDetails 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourseDetails update(CurCourseDetails curCourseDetails) {
        this.curCourseDetailsDao.update(curCourseDetails);
        return this.queryById(curCourseDetails.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.curCourseDetailsDao.deleteById(id) > 0;
    }
}
