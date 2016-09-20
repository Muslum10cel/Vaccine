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
@Table(name = TableNames.OTHER_VACCINES)
public class OtherVaccines implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.BCG, nullable = false)
    private Date bcgDate;

    @Column(name = ColumnNames.BCG_STATUS, nullable = false)
    private boolean bcgStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = ColumnNames.VARICELLA, nullable = false)
    private Date varicellaDate;

    @Column(name = ColumnNames.VARICELLA_STATUS, nullable = false)
    private boolean varicellaStatus;

    @Column(name = ColumnNames.DABT_IPA, nullable = false)
    private String dabtIpa;

    @Column(name = ColumnNames.DABT_IPA_STATUS, nullable = false)
    private boolean dabtIpaStatus;

    @Column(name = ColumnNames.KMA4, nullable = false)
    private String kma4;

    @Column(name = ColumnNames.KMA4_STATUS, nullable = false)
    private boolean kma4Status;

    @Column(name = ColumnNames.HPA, nullable = false)
    private String hpa;

    @Column(name = ColumnNames.HPA_STATUS, nullable = false)
    private boolean hpaStatus;

    @Column(name = ColumnNames.INFLUENZA, nullable = false)
    private String influenza;

    @Column(name = ColumnNames.INFLUENZA_STATUS, nullable = false)
    private boolean influenzaStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnNames.BABY_ID)
    private Baby baby;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getBcgDate() {
        return bcgDate;
    }

    public void setBcgDate(Date bcgDate) {
        this.bcgDate = bcgDate;
    }

    public Date getVaricellaDate() {
        return varicellaDate;
    }

    public void setVaricellaDate(Date varicellaDate) {
        this.varicellaDate = varicellaDate;
    }

    public String getDabtIpa() {
        return dabtIpa;
    }

    public void setDabtIpa(String dabtIpa) {
        this.dabtIpa = dabtIpa;
    }

    public String getKma4() {
        return kma4;
    }

    public void setKma4(String kma4) {
        this.kma4 = kma4;
    }

    public String getHpa() {
        return hpa;
    }

    public void setHpa(String hpa) {
        this.hpa = hpa;
    }

    public String getInfluenza() {
        return influenza;
    }

    public void setInfluenza(String influenza) {
        this.influenza = influenza;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public boolean isBcgStatus() {
        return bcgStatus;
    }

    public void setBcgStatus(boolean bcgStatus) {
        this.bcgStatus = bcgStatus;
    }

    public boolean isVaricellaStatus() {
        return varicellaStatus;
    }

    public void setVaricellaStatus(boolean varicellaStatus) {
        this.varicellaStatus = varicellaStatus;
    }

    public boolean isDabtIpaStatus() {
        return dabtIpaStatus;
    }

    public void setDabtIpaStatus(boolean dabtIpaStatus) {
        this.dabtIpaStatus = dabtIpaStatus;
    }

    public boolean isKma4Status() {
        return kma4Status;
    }

    public void setKma4Status(boolean kma4Status) {
        this.kma4Status = kma4Status;
    }

    public boolean isHpaStatus() {
        return hpaStatus;
    }

    public void setHpaStatus(boolean hpaStatus) {
        this.hpaStatus = hpaStatus;
    }

    public boolean isInfluenzaStatus() {
        return influenzaStatus;
    }

    public void setInfluenzaStatus(boolean influenzaStatus) {
        this.influenzaStatus = influenzaStatus;
    }

    @Override
    public String toString() {
        return "OtherVaccines{" + "bcgDate=" + bcgDate + ", varicellaDate=" + varicellaDate + ", dabtIpa=" + dabtIpa + ", kma4=" + kma4 + ", hpa=" + hpa + ", influenza=" + influenza + '}';
    }
}
