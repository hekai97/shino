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
    @Column(name = "create_time")
    private Timestamp createTime;

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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suggested suggested = (Suggested) o;
        return id == suggested.id && Objects.equals(phone, suggested.phone) && Objects.equals(question, suggested.question) && Objects.equals(description, suggested.description) && Objects.equals(createTime, suggested.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, question, description, createTime);
    }
}
