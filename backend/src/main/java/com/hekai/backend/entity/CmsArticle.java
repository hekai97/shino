package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cms_article", schema = "shinho", catalog = "")
public class CmsArticle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "catid")
    private Integer catid;
    @Basic
    @Column(name = "conttitle")
    private String conttitle;
    @Basic
    @Column(name = "contkeys")
    private String contkeys;
    @Basic
    @Column(name = "contdesc")
    private String contdesc;
    @Basic
    @Column(name = "contcoverurl")
    private String contcoverurl;
    @Basic
    @Column(name = "contvdourl")
    private String contvdourl;
    @Basic
    @Column(name = "conthtml")
    private String conthtml;
    @Basic
    @Column(name = "position")
    private String position;
    @Basic
    @Column(name = "contpublicdate")
    private Date contpublicdate;
    @Basic
    @Column(name = "accesscount")
    private Integer accesscount;
    @Basic
    @Column(name = "timeonsite")
    private Time timeonsite;
    @Basic
    @Column(name = "ispublished")
    private Byte ispublished;
    @Basic
    @Column(name = "creater")
    private String creater;
    @Basic
    @Column(name = "createtime")
    private Timestamp createtime;
    @Basic
    @Column(name = "updater")
    private String updater;
    @Basic
    @Column(name = "updatetime")
    private Timestamp updatetime;
    @Basic
    @Column(name = "contclslevel")
    private Integer contclslevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getConttitle() {
        return conttitle;
    }

    public void setConttitle(String conttitle) {
        this.conttitle = conttitle;
    }

    public String getContkeys() {
        return contkeys;
    }

    public void setContkeys(String contkeys) {
        this.contkeys = contkeys;
    }

    public String getContdesc() {
        return contdesc;
    }

    public void setContdesc(String contdesc) {
        this.contdesc = contdesc;
    }

    public String getContcoverurl() {
        return contcoverurl;
    }

    public void setContcoverurl(String contcoverurl) {
        this.contcoverurl = contcoverurl;
    }

    public String getContvdourl() {
        return contvdourl;
    }

    public void setContvdourl(String contvdourl) {
        this.contvdourl = contvdourl;
    }

    public String getConthtml() {
        return conthtml;
    }

    public void setConthtml(String conthtml) {
        this.conthtml = conthtml;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getContpublicdate() {
        return contpublicdate;
    }

    public void setContpublicdate(Date contpublicdate) {
        this.contpublicdate = contpublicdate;
    }

    public Integer getAccesscount() {
        return accesscount;
    }

    public void setAccesscount(Integer accesscount) {
        this.accesscount = accesscount;
    }

    public Time getTimeonsite() {
        return timeonsite;
    }

    public void setTimeonsite(Time timeonsite) {
        this.timeonsite = timeonsite;
    }

    public Byte getIspublished() {
        return ispublished;
    }

    public void setIspublished(Byte ispublished) {
        this.ispublished = ispublished;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getContclslevel() {
        return contclslevel;
    }

    public void setContclslevel(Integer contclslevel) {
        this.contclslevel = contclslevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CmsArticle that = (CmsArticle) o;
        return id == that.id && Objects.equals(catid, that.catid) && Objects.equals(conttitle, that.conttitle) && Objects.equals(contkeys, that.contkeys) && Objects.equals(contdesc, that.contdesc) && Objects.equals(contcoverurl, that.contcoverurl) && Objects.equals(contvdourl, that.contvdourl) && Objects.equals(conthtml, that.conthtml) && Objects.equals(position, that.position) && Objects.equals(contpublicdate, that.contpublicdate) && Objects.equals(accesscount, that.accesscount) && Objects.equals(timeonsite, that.timeonsite) && Objects.equals(ispublished, that.ispublished) && Objects.equals(creater, that.creater) && Objects.equals(createtime, that.createtime) && Objects.equals(updater, that.updater) && Objects.equals(updatetime, that.updatetime) && Objects.equals(contclslevel, that.contclslevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, catid, conttitle, contkeys, contdesc, contcoverurl, contvdourl, conthtml, position, contpublicdate, accesscount, timeonsite, ispublished, creater, createtime, updater, updatetime, contclslevel);
    }
}
