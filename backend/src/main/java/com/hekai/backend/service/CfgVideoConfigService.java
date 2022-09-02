package com.hekai.backend.service;

import com.hekai.backend.entity.CfgVideoConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 视频位置配置(CfgVideoConfig)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:19
 */
public interface CfgVideoConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CfgVideoConfig queryById(Integer id);

    /**
     * 分页查询
     *
     * @param cfgVideoConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CfgVideoConfig> queryByPage(CfgVideoConfig cfgVideoConfig, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param cfgVideoConfig 实例对象
     * @return 实例对象
     */
    CfgVideoConfig insert(CfgVideoConfig cfgVideoConfig);

    /**
     * 修改数据
     *
     * @param cfgVideoConfig 实例对象
     * @return 实例对象
     */
    CfgVideoConfig update(CfgVideoConfig cfgVideoConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
