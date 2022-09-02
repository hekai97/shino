package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "basic_rl_role_permission", schema = "shinho", catalog = "")
public class BasicRlRolePermission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "role_id")
    private Integer roleId;
    @Basic
    @Column(name = "permission_id")
    private Integer permissionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicRlRolePermission that = (BasicRlRolePermission) o;
        return id == that.id && Objects.equals(roleId, that.roleId) && Objects.equals(permissionId, that.permissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, permissionId);
    }
}
