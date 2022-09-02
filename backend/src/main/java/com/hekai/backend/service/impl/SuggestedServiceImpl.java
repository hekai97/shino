package com.hekai.backend.service.impl;

import com.hekai.backend.entity.Suggested;
import com.hekai.backend.dao.SuggestedDao;
import com.hekai.backend.service.SuggestedService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 建议反馈(Suggested)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 11:16:03
 */
@Service("suggestedService")
public class SuggestedServiceImpl implements SuggestedService {
    @Resource
    private SuggestedDao suggestedDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Suggested queryById(Integer id) {
        return this.suggestedDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param suggested 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Suggested> queryByPage(Suggested suggested, PageRequest pageRequest) {
        long total = this.suggestedDao.count(suggested);
        return new PageImpl<>(this.suggestedDao.queryAllByLimit(suggested, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param suggested 实例对象
     * @return 实例对象
     */
    @Override
    public Suggested insert(Suggested suggested) {
        this.suggestedDao.insert(suggested);
        return suggested;
    }

    /**
     * 修改数据
     *
     * @param suggested 实例对象
     * @return 实例对象
     */
    @Override
    public Suggested update(Suggested suggested) {
        this.suggestedDao.update(suggested);
        return this.queryById(suggested.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.suggestedDao.deleteById(id) > 0;
    }
}
