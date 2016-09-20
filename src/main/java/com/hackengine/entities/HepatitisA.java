/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.entities;

import com.hackengine.db.ColumnNames;
import com.hackengine.db.TableNames;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author muslumoncel
 */
@Entity
@Table(name = TableNames.HEPATITIS_A)
public class HepatitisA implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.FIRST_HEPATITIS_A, nullable = false)
    private Date firstHepatitisADate;

    @Column(name = ColumnNames.FIRST_HEPATITIS_A_STATUS, nullable = false)
    private boolean firstHepatitisAStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.SECOND_HEPATITIS_A, nullable = false)
    private Date secondHepatitisADate;

    @Column(name = ColumnNames.SECOND_HEPATITIS_A_STATUS, nullable = false)
    private boolean secondHepatitisAStatus;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnNames.BABY_ID)
    private Baby baby;

    public int getID() {
        return ID;
    }

    public Date getFirstHepatitisADate() {
        return firstHepatitisADate;
    }

    public boolean isFirstHepatitisAStatus() {
        return firstHepatitisAStatus;
    }

    public Date getSecondHepatitisADate() {
        return secondHepatitisADate;
    }

    public boolean isSecondHepatitisAStatus() {
        return secondHepatitisAStatus;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstHepatitisADate(Date firstHepatitisADate) {
        this.firstHepatitisADate = firstHepatitisADate;
    }

    public void setFirstHepatitisAStatus(boolean firstHepatitisAStatus) {
        this.firstHepatitisAStatus = firstHepatitisAStatus;
    }

    public void setSecondHepatitisADate(Date secondHepatitisADate) {
        this.secondHepatitisADate = secondHepatitisADate;
    }

    public void setSecondHepatitisAStatus(boolean secondHepatitisAStatus) {
        this.secondHepatitisAStatus = secondHepatitisAStatus;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    @Override
    public String toString() {
        return "HepatitisA{" + "firstHepatitisADate=" + firstHepatitisADate + ", firstHepatitisAStatus=" + firstHepatitisAStatus + ", secondHepatitisADate=" + secondHepatitisADate + ", secondHepatitisAStatus=" + secondHepatitisAStatus + '}';
    }
}
