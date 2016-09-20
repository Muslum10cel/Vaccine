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
@Table(name = TableNames.OPA)
public class Opa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.FIRST_OPA, nullable = false)
    private Date firstOpaDate;

    @Column(name = ColumnNames.FIRST_OPA_STATUS, nullable = false)
    private boolean firstOpaStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.SECOND_OPA, nullable = false)
    private Date secondOpaDate;

    @Column(name = ColumnNames.SECOND_OPA_STATUS, nullable = false)
    private boolean secondOpaStatus;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnNames.BABY_ID)
    private Baby baby;
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFirstOpaDate() {
        return firstOpaDate;
    }

    public void setFirstOpaDate(Date firstOpaDate) {
        this.firstOpaDate = firstOpaDate;
    }

    public boolean isFirstOpaStatus() {
        return firstOpaStatus;
    }

    public void setFirstOpaStatus(boolean firstOpaStatus) {
        this.firstOpaStatus = firstOpaStatus;
    }

    public Date getSecondOpaDate() {
        return secondOpaDate;
    }

    public void setSecondOpaDate(Date secondOpaDate) {
        this.secondOpaDate = secondOpaDate;
    }

    public boolean isSecondOpaStatus() {
        return secondOpaStatus;
    }

    public void setSecondOpaStatus(boolean secondOpaStatus) {
        this.secondOpaStatus = secondOpaStatus;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public Baby getBaby() {
        return baby;
    }

    @Override
    public String toString() {
        return "Opa{" + "firstOpaDate=" + firstOpaDate + ", firstOpaStatus=" + firstOpaStatus + ", secondOpaDate=" + secondOpaDate + ", secondOpaStatus=" + secondOpaStatus + '}';
    }
}
