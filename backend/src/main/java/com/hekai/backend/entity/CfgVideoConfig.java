package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cfg_video_config", schema = "shinho", catalog = "")
public class CfgVideoConfig {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "position")
    private Integer position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CfgVideoConfig that = (CfgVideoConfig) o;
        return id == that.id && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position);
    }
}
