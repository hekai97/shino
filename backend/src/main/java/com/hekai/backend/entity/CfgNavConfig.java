package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cfg_nav_config", schema = "shinho", catalog = "")
public class CfgNavConfig {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "icon_url")
    private String iconUrl;
    @Basic
    @Column(name = "nav_title")
    private String navTitle;
    @Basic
    @Column(name = "link_url")
    private String linkUrl;
    @Basic
    @Column(name = "sort")
    private Integer sort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getNavTitle() {
        return navTitle;
    }

    public void setNavTitle(String navTitle) {
        this.navTitle = navTitle;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CfgNavConfig that = (CfgNavConfig) o;
        return id == that.id && Objects.equals(iconUrl, that.iconUrl) && Objects.equals(navTitle, that.navTitle) && Objects.equals(linkUrl, that.linkUrl) && Objects.equals(sort, that.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iconUrl, navTitle, linkUrl, sort);
    }
}
