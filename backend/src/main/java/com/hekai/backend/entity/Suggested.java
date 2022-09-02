package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Suggested {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "question")
    private String question;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "createtime")
    private Timestamp createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suggested suggested = (Suggested) o;
        return id == suggested.id && Objects.equals(phone, suggested.phone) && Objects.equals(question, suggested.question) && Objects.equals(description, suggested.description) && Objects.equals(createtime, suggested.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, question, description, createtime);
    }
}
