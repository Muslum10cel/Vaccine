/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.entities;

import com.hackengine.db.ColumnNames;
import com.hackengine.db.TableNames;
import com.hackengine.genders.Gender;
import com.hackengine.tags.Tags;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author muslumoncel
 */
@Entity
@Table(name = TableNames.BABIES)
public class Baby implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name = ColumnNames.BABY_NAME, nullable = false)
    private String babyName;

    @Enumerated(EnumType.STRING)
    @Column(name = ColumnNames.GENDER, nullable = false)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.DATE_OF_BIRTH, nullable = false)
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = ColumnNames.USER_ID)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = Tags.MAPPED_BY_BABY, cascade = CascadeType.ALL)
    private Opa opa;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = Tags.MAPPED_BY_BABY, cascade = CascadeType.ALL)
    private HepatitisA hepatitisA;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = Tags.MAPPED_BY_BABY, cascade = CascadeType.ALL)
    private Rva rva;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = Tags.MAPPED_BY_BABY, cascade = CascadeType.ALL)
    private Kpa kpa;
    
     @OneToOne(fetch = FetchType.LAZY, mappedBy = Tags.MAPPED_BY_BABY, cascade = CascadeType.ALL)
    private Kkk kkk;
    
    public Baby() {
    }

    public Baby(String babyName, Gender gender, Date dateOfBirth) {
        this.babyName = babyName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Opa getOpa() {
        return opa;
    }

    public void setOpa(Opa opa) {
        this.opa = opa;
    }

    public void setHepatitisA(HepatitisA hepatitisA) {
        this.hepatitisA = hepatitisA;
    }

    public HepatitisA getHepatitisA() {
        return hepatitisA;
    }

    public void setRva(Rva rva) {
        this.rva = rva;
    }

    public Rva getRva() {
        return rva;
    }

    public void setKpa(Kpa kpa) {
        this.kpa = kpa;
    }

    public Kpa getKpa() {
        return kpa;
    }

    public void setKkk(Kkk kkk) {
        this.kkk = kkk;
    }

    public Kkk getKkk() {
        return kkk;
    }

    @Override
    public String toString() {
        return "Baby{" + "babyName=" + babyName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + '}';
    }
}
