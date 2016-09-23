/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.OtherVaccines;
import com.hackengine.messages.Messages;
import com.hackengine.tags.Tags;
import com.hackengine.transactions.Transactions;
import com.hackengine.utils.SessionUtils;
import com.hackengine.vaccines.Vaccines;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@RequestScoped
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
        String msg = "";
        switch (item) {
            case 1:
                if (baby.getOtherVaccines().isBcgStatus()) {
                    baby.getOtherVaccines().setBcgStatus(false);
                } else {
                    baby.getOtherVaccines().setBcgStatus(true);
                }
                msg = Vaccines.allVaccines[0];
                break;
            case 2:
                if (baby.getOtherVaccines().isDabtIpaStatus()) {
                    baby.getOtherVaccines().setDabtIpaStatus(false);
                } else {
                    baby.getOtherVaccines().setDabtIpaStatus(true);
                }
                msg = Vaccines.allVaccines[1];
                break;
            case 3:
                if (baby.getOtherVaccines().isHpaStatus()) {
                    baby.getOtherVaccines().setHpaStatus(false);
                } else {
                    baby.getOtherVaccines().setHpaStatus(true);
                }
                msg = Vaccines.allVaccines[4];
                break;
            case 4:
                if (baby.getOtherVaccines().isInfluenzaStatus()) {
                    baby.getOtherVaccines().setInfluenzaStatus(false);
                } else {
                    baby.getOtherVaccines().setInfluenzaStatus(true);
                }
                msg = Vaccines.allVaccines[5];
                break;
            case 5:
                if (baby.getOtherVaccines().isKma4Status()) {
                    baby.getOtherVaccines().setKma4Status(false);
                } else {
                    baby.getOtherVaccines().setKma4Status(true);
                }
                msg = Vaccines.allVaccines[3];
                break;
            case 6:
                if (baby.getOtherVaccines().isVaricellaStatus()) {
                    baby.getOtherVaccines().setVaricellaStatus(false);
                } else {
                    baby.getOtherVaccines().setVaricellaStatus(true);
                }
                msg = Vaccines.allVaccines[2];
        }
        if (transaction.updateOtherVaccines(baby.getOtherVaccines())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATED));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATE_ERROR));
        }
        others = Transactions.otherVaccines(baby.getID());
    }
}
