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
@Table(name = TableNames.RVA)
public class Rva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.FIRST_RVA, nullable = false)
    private Date firstRvaDate;

    @Column(name = ColumnNames.FIRST_RVA_STATUS, nullable = false)
    private boolean firstRvaStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.SECOND_RVA, nullable = false)
    private Date secondRvaDate;

    @Column(name = ColumnNames.SECOND_RVA_STATUS, nullable = false)
    private boolean secondRvaStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.THIRD_RVA, nullable = false)
    private Date thirdRvaDate;

    @Column(name = ColumnNames.THIRD_RVA_STATUS, nullable = false)
    private boolean thirdRvaStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnNames.BABY_ID)
    private Baby baby;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFirstRvaDate() {
        return firstRvaDate;
    }

    public void setFirstRvaDate(Date firstRvaDate) {
        this.firstRvaDate = firstRvaDate;
    }

    public boolean isFirstRvaStatus() {
        return firstRvaStatus;
    }

    public void setFirstRvaStatus(boolean firstRvaStatus) {
        this.firstRvaStatus = firstRvaStatus;
    }

    public Date getSecondRvaDate() {
        return secondRvaDate;
    }

    public void setSecondRvaDate(Date secondRvaDate) {
        this.secondRvaDate = secondRvaDate;
    }

    public boolean isSecondRvaStatus() {
        return secondRvaStatus;
    }

    public void setSecondRvaStatus(boolean secondRvaStatus) {
        this.secondRvaStatus = secondRvaStatus;
    }

    public Date getThirdRvaDate() {
        return thirdRvaDate;
    }

    public void setThirdRvaDate(Date thirdRvaDate) {
        this.thirdRvaDate = thirdRvaDate;
    }

    public boolean isThirdRvaStatus() {
        return thirdRvaStatus;
    }

    public void setThirdRvaStatus(boolean thirdRvaStatus) {
        this.thirdRvaStatus = thirdRvaStatus;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    @Override
    public String toString() {
        return "Rva{" + "firstRvaDate=" + firstRvaDate + ", firstRvaStatus=" + firstRvaStatus + ", secondRvaDate=" + secondRvaDate + ", secondRvaStatus=" + secondRvaStatus + ", thirdRvaDate=" + thirdRvaDate + ", thirdRvaStatus=" + thirdRvaStatus + '}';
    }
}
