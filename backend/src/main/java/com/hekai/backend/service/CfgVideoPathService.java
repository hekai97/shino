package com.hekai.backend.service;

import com.hekai.backend.entity.CfgVideoPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 视频存放路径(CfgVideoPath)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:19
 */
public interface CfgVideoPathService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CfgVideoPath queryById(Integer id);

    /**
     * 分页查询
     *
     * @param cfgVideoPath 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CfgVideoPath> queryByPage(CfgVideoPath cfgVideoPath, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param cfgVideoPath 实例对象
     * @return 实例对象
     */
    CfgVideoPath insert(CfgVideoPath cfgVideoPath);

    /**
     * 修改数据
     *
     * @param cfgVideoPath 实例对象
     * @return 实例对象
     */
    CfgVideoPath update(CfgVideoPath cfgVideoPath);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
