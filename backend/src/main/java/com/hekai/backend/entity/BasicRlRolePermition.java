package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "basic_rl_role_permition", schema = "shinho", catalog = "")
public class BasicRlRolePermition {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "roleid")
    private Integer roleid;
    @Basic
    @Column(name = "pomitionid")
    private Integer pomitionid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getPomitionid() {
        return pomitionid;
    }

    public void setPomitionid(Integer pomitionid) {
        this.pomitionid = pomitionid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicRlRolePermition that = (BasicRlRolePermition) o;
        return id == that.id && Objects.equals(roleid, that.roleid) && Objects.equals(pomitionid, that.pomitionid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleid, pomitionid);
    }
}
