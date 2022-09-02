package com.hekai.backend.service;

import com.hekai.backend.entity.CfgWeixinConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 微信支付接口配置(CfgWeixinConfig)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 11:13:20
 */
public interface CfgWeixinConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CfgWeixinConfig queryById(Integer id);

    /**
     * 分页查询
     *
     * @param cfgWeixinConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CfgWeixinConfig> queryByPage(CfgWeixinConfig cfgWeixinConfig, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param cfgWeixinConfig 实例对象
     * @return 实例对象
     */
    CfgWeixinConfig insert(CfgWeixinConfig cfgWeixinConfig);

    /**
     * 修改数据
     *
     * @param cfgWeixinConfig 实例对象
     * @return 实例对象
     */
    CfgWeixinConfig update(CfgWeixinConfig cfgWeixinConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
