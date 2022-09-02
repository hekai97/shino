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
    @Column(name = "iconurl")
    private String iconurl;
    @Basic
    @Column(name = "navtitle")
    private String navtitle;
    @Basic
    @Column(name = "linkurl")
    private String linkurl;
    @Basic
    @Column(name = "sort")
    private Integer sort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getNavtitle() {
        return navtitle;
    }

    public void setNavtitle(String navtitle) {
        this.navtitle = navtitle;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
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
        return id == that.id && Objects.equals(iconurl, that.iconurl) && Objects.equals(navtitle, that.navtitle) && Objects.equals(linkurl, that.linkurl) && Objects.equals(sort, that.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iconurl, navtitle, linkurl, sort);
    }
}
