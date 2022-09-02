package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cfg_weixin_config", schema = "shinho", catalog = "")
public class CfgWeixinConfig {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "appid")
    private String appid;
    @Basic
    @Column(name = "machineid")
    private String machineid;
    @Basic
    @Column(name = "paternerkey")
    private String paternerkey;
    @Basic
    @Column(name = "notifyurl")
    private String notifyurl;
    @Basic
    @Column(name = "creater")
    private String creater;
    @Basic
    @Column(name = "createtime")
    private Timestamp createtime;
    @Basic
    @Column(name = "updater")
    private String updater;
    @Basic
    @Column(name = "updatetime")
    private Timestamp updatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMachineid() {
        return machineid;
    }

    public void setMachineid(String machineid) {
        this.machineid = machineid;
    }

    public String getPaternerkey() {
        return paternerkey;
    }

    public void setPaternerkey(String paternerkey) {
        this.paternerkey = paternerkey;
    }

    public String getNotifyurl() {
        return notifyurl;
    }

    public void setNotifyurl(String notifyurl) {
        this.notifyurl = notifyurl;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CfgWeixinConfig that = (CfgWeixinConfig) o;
        return id == that.id && Objects.equals(appid, that.appid) && Objects.equals(machineid, that.machineid) && Objects.equals(paternerkey, that.paternerkey) && Objects.equals(notifyurl, that.notifyurl) && Objects.equals(creater, that.creater) && Objects.equals(createtime, that.createtime) && Objects.equals(updater, that.updater) && Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appid, machineid, paternerkey, notifyurl, creater, createtime, updater, updatetime);
    }
}
