package com.hekai.backend.service.impl;

import com.hekai.backend.entity.CurCourseImg;
import com.hekai.backend.dao.CurCourseImgDao;
import com.hekai.backend.service.CurCourseImgService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (CurCourseImg)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("curCourseImgService")
public class CurCourseImgServiceImpl implements CurCourseImgService {
    @Resource
    private CurCourseImgDao curCourseImgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CurCourseImg queryById(Integer id) {
        return this.curCourseImgDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param curCourseImg 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CurCourseImg> queryByPage(CurCourseImg curCourseImg, PageRequest pageRequest) {
        long total = this.curCourseImgDao.count(curCourseImg);
        return new PageImpl<>(this.curCourseImgDao.queryAllByLimit(curCourseImg, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param curCourseImg 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourseImg insert(CurCourseImg curCourseImg) {
        this.curCourseImgDao.insert(curCourseImg);
        return curCourseImg;
    }

    /**
     * 修改数据
     *
     * @param curCourseImg 实例对象
     * @return 实例对象
     */
    @Override
    public CurCourseImg update(CurCourseImg curCourseImg) {
        this.curCourseImgDao.update(curCourseImg);
        return this.queryById(curCourseImg.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.curCourseImgDao.deleteById(id) > 0;
    }
}
