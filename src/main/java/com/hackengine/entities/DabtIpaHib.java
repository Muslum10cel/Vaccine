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
@Table(name = TableNames.DABT_IPA_HIB)
public class DabtIpaHib implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.FIRST_DABT_IPA_HIB, nullable = false)
    private Date firstDabtIpaHib;

    @Column(name = ColumnNames.FIRST_DABT_IPA_HIB_STATUS, nullable = false)
    private boolean firstDabtIpaHibStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.SECOND_DABT_IPA_HIB, nullable = false)
    private Date secondDabtIpaHib;

    @Column(name = ColumnNames.SECOND_DABT_IPA_HIB_STATUS, nullable = false)
    private boolean secondDabtIpaHibStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.THIRD_DABT_IPA_HIB, nullable = false)
    private Date thirdDabtIpaHib;

    @Column(name = ColumnNames.THIRD_DABT_IPA_HIB_STATUS, nullable = false)
    private boolean thirdDabtIpaHibStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.FOURTH_DABT_IPA_HIB, nullable = false)
    private Date fourthDabtIpaHib;

    @Column(name = ColumnNames.FOURTH_DABT_IPA_HIB_STATUS, nullable = false)
    private boolean fourthDabtIpaHibStatus;

    @Column(name = ColumnNames.FIFTH_DABT_IPA_HIB, nullable = false)
    private String fifthDabtIpaHib;

    @Column(name = ColumnNames.FIFTH_DABT_IPA_HIB_STATUS, nullable = false)
    private boolean fifthDabtIpaHibStatus;

    @Column(name = ColumnNames.SIXTH_DABT_IPA_HIB, nullable = false)
    private String sixthDabtIpaHib;

    @Column(name = ColumnNames.SIXTH_DABT_IPA_HIB_STATUS, nullable = false)
    private boolean sixthDabtIpaHibStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnNames.BABY_ID)
    private Baby baby;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFirstDabtIpaHib() {
        return firstDabtIpaHib;
    }

    public void setFirstDabtIpaHib(Date firstDabtIpaHib) {
        this.firstDabtIpaHib = firstDabtIpaHib;
    }

    public boolean isFirstDabtIpaHibStatus() {
        return firstDabtIpaHibStatus;
    }

    public void setFirstDabtIpaHibStatus(boolean firstDabtIpaHibStatus) {
        this.firstDabtIpaHibStatus = firstDabtIpaHibStatus;
    }

    public Date getSecondDabtIpaHib() {
        return secondDabtIpaHib;
    }

    public void setSecondDabtIpaHib(Date secondDabtIpaHib) {
        this.secondDabtIpaHib = secondDabtIpaHib;
    }

    public boolean isSecondDabtIpaHibStatus() {
        return secondDabtIpaHibStatus;
    }

    public void setSecondDabtIpaHibStatus(boolean secondDabtIpaHibStatus) {
        this.secondDabtIpaHibStatus = secondDabtIpaHibStatus;
    }

    public Date getThirdDabtIpaHib() {
        return thirdDabtIpaHib;
    }

    public void setThirdDabtIpaHib(Date thirdDabtIpaHib) {
        this.thirdDabtIpaHib = thirdDabtIpaHib;
    }

    public boolean isThirdDabtIpaHibStatus() {
        return thirdDabtIpaHibStatus;
    }

    public void setThirdDabtIpaHibStatus(boolean thirdDabtIpaHibStatus) {
        this.thirdDabtIpaHibStatus = thirdDabtIpaHibStatus;
    }

    public Date getFourthDabtIpaHib() {
        return fourthDabtIpaHib;
    }

    public void setFourthDabtIpaHib(Date fourthDabtIpaHib) {
        this.fourthDabtIpaHib = fourthDabtIpaHib;
    }

    public boolean isFourthDabtIpaHibStatus() {
        return fourthDabtIpaHibStatus;
    }

    public void setFourthDabtIpaHibStatus(boolean fourthDabtIpaHibStatus) {
        this.fourthDabtIpaHibStatus = fourthDabtIpaHibStatus;
    }

    public boolean isFifthDabtIpaHibStatus() {
        return fifthDabtIpaHibStatus;
    }

    public void setFifthDabtIpaHibStatus(boolean fifthDabtIpaHibStatus) {
        this.fifthDabtIpaHibStatus = fifthDabtIpaHibStatus;
    }

    public boolean isSixthDabtIpaHibStatus() {
        return sixthDabtIpaHibStatus;
    }

    public void setSixthDabtIpaHibStatus(boolean sixthDabtIpaHibStatus) {
        this.sixthDabtIpaHibStatus = sixthDabtIpaHibStatus;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public String getFifthDabtIpaHib() {
        return fifthDabtIpaHib;
    }

    public void setFifthDabtIpaHib(String fifthDabtIpaHib) {
        this.fifthDabtIpaHib = fifthDabtIpaHib;
    }

    public String getSixthDabtIpaHib() {
        return sixthDabtIpaHib;
    }

    public void setSixthDabtIpaHib(String sixthDabtIpaHib) {
        this.sixthDabtIpaHib = sixthDabtIpaHib;
    }

    @Override
    public String toString() {
        return "DabtIpaHib{" + "firstDabtIpaHib=" + firstDabtIpaHib + ", firstDabtIpaHibStatus=" + firstDabtIpaHibStatus + ", secondDabtIpaHib=" + secondDabtIpaHib + ", secondDabtIpaHibStatus=" + secondDabtIpaHibStatus + ", thirdDabtIpaHib=" + thirdDabtIpaHib + ", thirdDabtIpaHibStatus=" + thirdDabtIpaHibStatus + ", fourthDabtIpaHib=" + fourthDabtIpaHib + ", fourthDabtIpaHibStatus=" + fourthDabtIpaHibStatus + ", fifthDabtIpaHib=" + fifthDabtIpaHib + ", fifthDabtIpaHibStatus=" + fifthDabtIpaHibStatus + ", sixthDabtIpaHib=" + sixthDabtIpaHib + ", sixthDabtIpaHibStatus=" + sixthDabtIpaHibStatus + '}';
    }
}
