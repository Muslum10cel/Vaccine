/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.OtherVaccines;
import com.hackengine.tags.Tags;
import com.hackengine.transactions.Transactions;
import com.hackengine.utils.SessionUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@SessionScoped
public class OtherVaccinesBean implements Serializable {

    private Baby baby;

    private Transactions transaction = null;

    private List<OtherVaccines> others = null;

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        others = Transactions.otherVaccines(baby.getID());
        transaction = new Transactions();
    }

    public List<OtherVaccines> getOthers() {
        return others;
    }

    public void setOthers(List<OtherVaccines> others) {
        this.others = others;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }
    
    public void updateOtherVaccines(int item) {
        switch (item) {
            case 1:
                if (baby.getOtherVaccines().isBcgStatus()) {
                    baby.getOtherVaccines().setBcgStatus(false);
                } else {
                    baby.getOtherVaccines().setBcgStatus(true);
                }
                break;
            case 2:
                if (baby.getOtherVaccines().isDabtIpaStatus()) {
                    baby.getOtherVaccines().setDabtIpaStatus(false);
                } else {
                    baby.getOtherVaccines().setDabtIpaStatus(true);
                }
                break;
            case 3:
                if (baby.getOtherVaccines().isHpaStatus()) {
                    baby.getOtherVaccines().setHpaStatus(false);
                } else {
                    baby.getOtherVaccines().setHpaStatus(true);
                }
                break;
            case 4:
                if (baby.getOtherVaccines().isInfluenzaStatus()) {
                    baby.getOtherVaccines().setInfluenzaStatus(false);
                } else {
                    baby.getOtherVaccines().setInfluenzaStatus(true);
                }
                break;
            case 5:
                if (baby.getOtherVaccines().isKma4Status()) {
                    baby.getOtherVaccines().setKma4Status(false);
                } else {
                    baby.getOtherVaccines().setKma4Status(true);
                }
                break;
            case 6:
                if (baby.getOtherVaccines().isVaricellaStatus()) {
                    baby.getOtherVaccines().setVaricellaStatus(false);
                } else {
                    baby.getOtherVaccines().setVaricellaStatus(true);
                }
        }
        transaction.updateOtherVaccines(baby.getOtherVaccines());
        others = Transactions.otherVaccines(baby.getID());
    }
}
