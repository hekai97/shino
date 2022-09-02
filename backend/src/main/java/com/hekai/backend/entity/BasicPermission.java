package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "basic_permission", schema = "shinho", catalog = "")
public class BasicPermission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "permissionname")
    private String permissionname;
    @Basic
    @Column(name = "pageid")
    private Integer pageid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicPermission that = (BasicPermission) o;
        return id == that.id && Objects.equals(code, that.code) && Objects.equals(permissionname, that.permissionname) && Objects.equals(pageid, that.pageid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, permissionname, pageid);
    }
}
