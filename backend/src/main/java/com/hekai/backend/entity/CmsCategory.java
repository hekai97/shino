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
    @Column(name = "cms_title")
    private String cmsTitle;
    @Basic
    @Column(name = "cms_code")
    private String cmsCode;
    @Basic
    @Column(name = "article_count")
    private Integer articleCount;
    @Basic
    @Column(name = "cms_type")
    private String cmsType;
    @Basic
    @Column(name = "is_published")
    private Byte isPublished;
    @Basic
    @Column(name = "creater")
    private String creater;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;
    @Basic
    @Column(name = "updater")
    private String updater;
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCmsTitle() {
        return cmsTitle;
    }

    public void setCmsTitle(String cmsTitle) {
        this.cmsTitle = cmsTitle;
    }

    public String getCmsCode() {
        return cmsCode;
    }

    public void setCmsCode(String cmsCode) {
        this.cmsCode = cmsCode;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public String getCmsType() {
        return cmsType;
    }

    public void setCmsType(String cmsType) {
        this.cmsType = cmsType;
    }

    public Byte getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Byte isPublished) {
        this.isPublished = isPublished;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CmsCategory that = (CmsCategory) o;
        return id == that.id && Objects.equals(cmsTitle, that.cmsTitle) && Objects.equals(cmsCode, that.cmsCode) && Objects.equals(articleCount, that.articleCount) && Objects.equals(cmsType, that.cmsType) && Objects.equals(isPublished, that.isPublished) && Objects.equals(creater, that.creater) && Objects.equals(createTime, that.createTime) && Objects.equals(updater, that.updater) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cmsTitle, cmsCode, articleCount, cmsType, isPublished, creater, createTime, updater, updateTime);
    }
}
