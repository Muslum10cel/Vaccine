/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.entities;

import com.hackengine.db.ColumnNames;
import com.hackengine.db.TableNames;
import com.hackengine.loglevel.LogLevel;
import com.hackengine.tags.Tags;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author muslumoncel
 */
@Entity
@Table(name = TableNames.USER)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name = ColumnNames.USERNAME, nullable = false, unique = true)
    private String username;

    @Column(name = ColumnNames.PASSWORD, nullable = false)
    private String password;

    @Column(name = ColumnNames.E_MAIL, nullable = false, unique = true)
    private String email;

    @Column(name = ColumnNames.FULL_NAME, nullable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = ColumnNames.LOG_LEVEL, nullable = false)
    private LogLevel logLevel;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ColumnNames.JOINED_DATE, nullable = false)
    private Date joinedDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = Tags.MAPPED_BY_USER, cascade = CascadeType.ALL)
    private List<Baby> babies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = Tags.MAPPED_BY_USER, cascade = CascadeType.ALL)
    private List<Comment> comments;

    public User() {
    }

    public User(String username, String password, String email, String fullName, LogLevel logLevel, Date joinedDate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.logLevel = logLevel;
        this.joinedDate = joinedDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public List<Baby> getBabies() {
        return babies;
    }

    public void setBabies(List<Baby> babies) {
        this.babies = babies;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", email=" + email + ", fullName=" + fullName + ", logLevel=" + logLevel + ", joinedDate=" + joinedDate + '}';
    }
}
