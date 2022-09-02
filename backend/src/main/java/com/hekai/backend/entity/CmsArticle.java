package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cms_article", schema = "shinho", catalog = "")
public class CmsArticle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "catid")
    private Integer catid;
    @Basic
    @Column(name = "content_title")
    private String contentTitle;
    @Basic
    @Column(name = "content_keys")
    private String contentKeys;
    @Basic
    @Column(name = "content_desc")
    private String contentDesc;
    @Basic
    @Column(name = "content_cover_url")
    private String contentCoverUrl;
    @Basic
    @Column(name = "content_video_url")
    private String contentVideoUrl;
    @Basic
    @Column(name = "content_html")
    private String contentHtml;
    @Basic
    @Column(name = "position")
    private String position;
    @Basic
    @Column(name = "content_public_date")
    private Date contentPublicDate;
    @Basic
    @Column(name = "access_count")
    private Integer accessCount;
    @Basic
    @Column(name = "time_onsite")
    private Time timeOnsite;
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
    @Basic
    @Column(name = "contcls_level")
    private Integer contclsLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentKeys() {
        return contentKeys;
    }

    public void setContentKeys(String contentKeys) {
        this.contentKeys = contentKeys;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public String getContentCoverUrl() {
        return contentCoverUrl;
    }

    public void setContentCoverUrl(String contentCoverUrl) {
        this.contentCoverUrl = contentCoverUrl;
    }

    public String getContentVideoUrl() {
        return contentVideoUrl;
    }

    public void setContentVideoUrl(String contentVideoUrl) {
        this.contentVideoUrl = contentVideoUrl;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getContentPublicDate() {
        return contentPublicDate;
    }

    public void setContentPublicDate(Date contentPublicDate) {
        this.contentPublicDate = contentPublicDate;
    }

    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }

    public Time getTimeOnsite() {
        return timeOnsite;
    }

    public void setTimeOnsite(Time timeOnsite) {
        this.timeOnsite = timeOnsite;
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

    public Integer getContclsLevel() {
        return contclsLevel;
    }

    public void setContclsLevel(Integer contclsLevel) {
        this.contclsLevel = contclsLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CmsArticle that = (CmsArticle) o;
        return id == that.id && Objects.equals(catid, that.catid) && Objects.equals(contentTitle, that.contentTitle) && Objects.equals(contentKeys, that.contentKeys) && Objects.equals(contentDesc, that.contentDesc) && Objects.equals(contentCoverUrl, that.contentCoverUrl) && Objects.equals(contentVideoUrl, that.contentVideoUrl) && Objects.equals(contentHtml, that.contentHtml) && Objects.equals(position, that.position) && Objects.equals(contentPublicDate, that.contentPublicDate) && Objects.equals(accessCount, that.accessCount) && Objects.equals(timeOnsite, that.timeOnsite) && Objects.equals(isPublished, that.isPublished) && Objects.equals(creater, that.creater) && Objects.equals(createTime, that.createTime) && Objects.equals(updater, that.updater) && Objects.equals(updateTime, that.updateTime) && Objects.equals(contclsLevel, that.contclsLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, catid, contentTitle, contentKeys, contentDesc, contentCoverUrl, contentVideoUrl, contentHtml, position, contentPublicDate, accessCount, timeOnsite, isPublished, creater, createTime, updater, updateTime, contclsLevel);
    }
}
