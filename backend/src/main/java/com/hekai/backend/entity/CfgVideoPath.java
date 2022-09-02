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
    @Column(name = "position_id")
    private Integer positionId;
    @Basic
    @Column(name = "video_path")
    private String videoPath;
    @Basic
    @Column(name = "photo_path")
    private String photoPath;
    @Basic
    @Column(name = "ord")
    private Integer ord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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
        return id == that.id && Objects.equals(positionId, that.positionId) && Objects.equals(videoPath, that.videoPath) && Objects.equals(photoPath, that.photoPath) && Objects.equals(ord, that.ord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, positionId, videoPath, photoPath, ord);
    }
}
