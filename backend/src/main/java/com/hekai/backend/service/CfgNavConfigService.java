package com.hekai.backend.service;

import com.hekai.backend.entity.CfgNavConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 导航配置(CfgNavConfig)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:19
 */
public interface CfgNavConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CfgNavConfig queryById(Integer id);

    /**
     * 分页查询
     *
     * @param cfgNavConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CfgNavConfig> queryByPage(CfgNavConfig cfgNavConfig, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param cfgNavConfig 实例对象
     * @return 实例对象
     */
    CfgNavConfig insert(CfgNavConfig cfgNavConfig);

    /**
     * 修改数据
     *
     * @param cfgNavConfig 实例对象
     * @return 实例对象
     */
    CfgNavConfig update(CfgNavConfig cfgNavConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
