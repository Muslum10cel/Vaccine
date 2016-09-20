/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.entities;

import com.hackengine.db.ColumnNames;
import com.hackengine.db.TableNames;
import com.hackengine.genders.Gender;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author muslumoncel
 */
@Entity
@Table(name = TableNames.COMMENT)
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name = ColumnNames.VACCINE_NAME, nullable = false)
    private String vaccineName;

    @Enumerated(EnumType.STRING)
    @Column(name = ColumnNames.GENDER, nullable = false)
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ColumnNames.COMMENT_DATE, nullable = false)
    private Date commentDate;

    @Column(name = ColumnNames.COMMENT, nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = ColumnNames.USER_ID)
    private User user;

    public Comment() {
    }

    public Comment(String vaccineName, Gender gender, Date commentDate, String comment) {
        this.vaccineName = vaccineName;
        this.gender = gender;
        this.commentDate = commentDate;
        this.comment = comment;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" + "vaccineName=" + vaccineName + ", gender=" + gender + ", commentDate=" + commentDate + ", comment=" + comment + '}';
    }
}