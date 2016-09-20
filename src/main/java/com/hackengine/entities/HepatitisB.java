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
@Table(name = TableNames.HEPATITIS_B)
public class HepatitisB implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.FIRST_HEPATITIS_B, nullable = false)
    private Date firstHepatitsB;

    @Column(name = ColumnNames.FIRST_HEPATITIS_B_STATUS, nullable = false)
    private boolean firstHepatitisBStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.SECOND_HEPATITIS_B, nullable = false)
    private Date scondHepatitsB;

    @Column(name = ColumnNames.SECOND_HEPATITIS_B_STATUS, nullable = false)
    private boolean secondHepatitisBStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.THIRD_HEPATITIS_B, nullable = false)
    private Date thirdHepatitsB;

    @Column(name = ColumnNames.THIRD_HEPATITIS_B_STATUS, nullable = false)
    private boolean thirdHepatitisBStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnNames.BABY_ID)
    private Baby baby;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFirstHepatitsB() {
        return firstHepatitsB;
    }

    public void setFirstHepatitsB(Date firstHepatitsB) {
        this.firstHepatitsB = firstHepatitsB;
    }

    public boolean isFirstHepatitisBStatus() {
        return firstHepatitisBStatus;
    }

    public void setFirstHepatitisBStatus(boolean firstHepatitisBStatus) {
        this.firstHepatitisBStatus = firstHepatitisBStatus;
    }

    public Date getScondHepatitsB() {
        return scondHepatitsB;
    }

    public void setScondHepatitsB(Date scondHepatitsB) {
        this.scondHepatitsB = scondHepatitsB;
    }

    public boolean isSecondHepatitisBStatus() {
        return secondHepatitisBStatus;
    }

    public void setSecondHepatitisBStatus(boolean secondHepatitisBStatus) {
        this.secondHepatitisBStatus = secondHepatitisBStatus;
    }

    public Date getThirdHepatitsB() {
        return thirdHepatitsB;
    }

    public void setThirdHepatitsB(Date thirdHepatitsB) {
        this.thirdHepatitsB = thirdHepatitsB;
    }

    public boolean isThirdHepatitisBStatus() {
        return thirdHepatitisBStatus;
    }

    public void setThirdHepatitisBStatus(boolean thirdHepatitisBStatus) {
        this.thirdHepatitisBStatus = thirdHepatitisBStatus;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    @Override
    public String toString() {
        return "HepatitisB{" + "firstHepatitsB=" + firstHepatitsB + ", firstHepatitisBStatus=" + firstHepatitisBStatus + ", scondHepatitsB=" + scondHepatitsB + ", secondHepatitisBStatus=" + secondHepatitisBStatus + ", thirdHepatitsB=" + thirdHepatitsB + ", thirdHepatitisBStatus=" + thirdHepatitisBStatus + '}';
    }
}
