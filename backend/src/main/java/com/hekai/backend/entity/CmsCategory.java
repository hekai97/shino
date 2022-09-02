package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cms_category", schema = "shinho", catalog = "")
public class CmsCategory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "cmstitle")
    private String cmstitle;
    @Basic
    @Column(name = "cmscode")
    private String cmscode;
    @Basic
    @Column(name = "articlecount")
    private Integer articlecount;
    @Basic
    @Column(name = "cmstype")
    private String cmstype;
    @Basic
    @Column(name = "ispublished")
    private Byte ispublished;
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

    public String getCmstitle() {
        return cmstitle;
    }

    public void setCmstitle(String cmstitle) {
        this.cmstitle = cmstitle;
    }

    public String getCmscode() {
        return cmscode;
    }

    public void setCmscode(String cmscode) {
        this.cmscode = cmscode;
    }

    public Integer getArticlecount() {
        return articlecount;
    }

    public void setArticlecount(Integer articlecount) {
        this.articlecount = articlecount;
    }

    public String getCmstype() {
        return cmstype;
    }

    public void setCmstype(String cmstype) {
        this.cmstype = cmstype;
    }

    public Byte getIspublished() {
        return ispublished;
    }

    public void setIspublished(Byte ispublished) {
        this.ispublished = ispublished;
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
        CmsCategory that = (CmsCategory) o;
        return id == that.id && Objects.equals(cmstitle, that.cmstitle) && Objects.equals(cmscode, that.cmscode) && Objects.equals(articlecount, that.articlecount) && Objects.equals(cmstype, that.cmstype) && Objects.equals(ispublished, that.ispublished) && Objects.equals(creater, that.creater) && Objects.equals(createtime, that.createtime) && Objects.equals(updater, that.updater) && Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cmstitle, cmscode, articlecount, cmstype, ispublished, creater, createtime, updater, updatetime);
    }
}
