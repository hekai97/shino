package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cfg_video_path", schema = "shinho", catalog = "")
public class CfgVideoPath {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "positionid")
    private Integer positionid;
    @Basic
    @Column(name = "vdopath")
    private String vdopath;
    @Basic
    @Column(name = "phopath")
    private String phopath;
    @Basic
    @Column(name = "ord")
    private Integer ord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public String getVdopath() {
        return vdopath;
    }

    public void setVdopath(String vdopath) {
        this.vdopath = vdopath;
    }

    public String getPhopath() {
        return phopath;
    }

    public void setPhopath(String phopath) {
        this.phopath = phopath;
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CfgVideoPath that = (CfgVideoPath) o;
        return id == that.id && Objects.equals(positionid, that.positionid) && Objects.equals(vdopath, that.vdopath) && Objects.equals(phopath, that.phopath) && Objects.equals(ord, that.ord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, positionid, vdopath, phopath, ord);
    }
}
