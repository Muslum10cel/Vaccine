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
@Table(name = TableNames.KPA)
public class Kpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.FIRST_KPA, nullable = false)
    private Date firstKpaDate;

    @Column(name = ColumnNames.FIRST_KPA_STATUS, nullable = false)
    private boolean firstKpaStatus;
    
    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.SECOND_KPA, nullable = false)
    private Date secondKpaDate;

    @Column(name = ColumnNames.SECOND_KPA_STATUS, nullable = false)
    private boolean secondKpaStatus;
    
    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.THIRD_KPA, nullable = false)
    private Date thirdKpaDate;

    @Column(name = ColumnNames.THIRD_KPA_STATUS, nullable = false)
    private boolean thirdKpaStatus;
    
    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.FOURTH_KPA, nullable = false)
    private Date fourthKpaDate;

    @Column(name = ColumnNames.FOURTH_KPA_STATUS, nullable = false)
    private boolean fourthKpaStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnNames.BABY_ID)
    private Baby baby;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFirstKpaDate() {
        return firstKpaDate;
    }

    public void setFirstKpaDate(Date firstKpaDate) {
        this.firstKpaDate = firstKpaDate;
    }

    public boolean isFirstKpaStatus() {
        return firstKpaStatus;
    }

    public void setFirstKpaStatus(boolean firstKpaStatus) {
        this.firstKpaStatus = firstKpaStatus;
    }

    public Date getSecondKpaDate() {
        return secondKpaDate;
    }

    public void setSecondKpaDate(Date secondKpaDate) {
        this.secondKpaDate = secondKpaDate;
    }

    public boolean isSecondKpaStatus() {
        return secondKpaStatus;
    }

    public void setSecondKpaStatus(boolean secondKpaStatus) {
        this.secondKpaStatus = secondKpaStatus;
    }

    public Date getThirdKpaDate() {
        return thirdKpaDate;
    }

    public void setThirdKpaDate(Date thirdKpaDate) {
        this.thirdKpaDate = thirdKpaDate;
    }

    public boolean isThirdKpaStatus() {
        return thirdKpaStatus;
    }

    public void setThirdKpaStatus(boolean thirdKpaStatus) {
        this.thirdKpaStatus = thirdKpaStatus;
    }

    public Date getFourthKpaDate() {
        return fourthKpaDate;
    }

    public void setFourthKpaDate(Date fourthKpaDate) {
        this.fourthKpaDate = fourthKpaDate;
    }

    public boolean isFourthKpaStatus() {
        return fourthKpaStatus;
    }

    public void setFourthKpaStatus(boolean fourthKpaStatus) {
        this.fourthKpaStatus = fourthKpaStatus;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    @Override
    public String toString() {
        return "Kpa{" + "firstKpaDate=" + firstKpaDate + ", firstKpaStatus=" + firstKpaStatus + ", secondKpaDate=" + secondKpaDate + ", secondKpaStatus=" + secondKpaStatus + ", thirdKpaDate=" + thirdKpaDate + ", thirdKpaStatus=" + thirdKpaStatus + ", fourthKpaDate=" + fourthKpaDate + ", fourthKpaStatus=" + fourthKpaStatus + '}';
    }
}
