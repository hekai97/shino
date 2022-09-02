package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "basic_permission_page", schema = "shinho", catalog = "")
public class BasicPermissionPage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "page_name")
    private String pageName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicPermissionPage that = (BasicPermissionPage) o;
        return id == that.id && Objects.equals(pageName, that.pageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pageName);
    }
}
