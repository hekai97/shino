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
    @Column(name = "pagename")
    private String pagename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicPermissionPage that = (BasicPermissionPage) o;
        return id == that.id && Objects.equals(pagename, that.pagename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pagename);
    }
}
