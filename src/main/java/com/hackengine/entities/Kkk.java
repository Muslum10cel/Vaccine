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
@Table(name = TableNames.KKK)
public class Kkk implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.FIRST_KKK, nullable = false)
    private Date firstKkkDate;

    @Column(name = ColumnNames.FIRST_KKK_STATUS, nullable = false)
    private boolean firstKkkStatus;

    @Column(name = ColumnNames.SECOND_KKK, nullable = false)
    private String secondKkkDate;

    @Column(name = ColumnNames.SECOND_KKK_STATUS, nullable = false)
    private boolean secondKkkStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnNames.BABY_ID)
    private Baby baby;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFirstKkkDate() {
        return firstKkkDate;
    }

    public void setFirstKkkDate(Date firstKkkDate) {
        this.firstKkkDate = firstKkkDate;
    }

    public boolean isFirstKkkStatus() {
        return firstKkkStatus;
    }

    public void setFirstKkkStatus(boolean firstKkkStatus) {
        this.firstKkkStatus = firstKkkStatus;
    }

    public String getSecondKkkDate() {
        return secondKkkDate;
    }

    public void setSecondKkkDate(String secondKkkDate) {
        this.secondKkkDate = secondKkkDate;
    }

    public boolean isSecondKkkStatus() {
        return secondKkkStatus;
    }

    public void setSecondKkkStatus(boolean secondKkkStatus) {
        this.secondKkkStatus = secondKkkStatus;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    @Override
    public String toString() {
        return "Kkk{" + "firstKkkDate=" + firstKkkDate + ", firstKkkStatus=" + firstKkkStatus + ", secondKkkDate=" + secondKkkDate + ", seconKkkStatus=" + secondKkkStatus + '}';
    }
}
