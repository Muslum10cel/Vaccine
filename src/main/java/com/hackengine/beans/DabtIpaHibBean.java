/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.DabtIpaHib;
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
public class DabtIpaHibBean implements Serializable {

    private Baby baby;

    private Transactions transaction = null;

    private List<DabtIpaHib> dabtIpaHibs = null;

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        transaction = new Transactions();
        dabtIpaHibs = transaction.dabtIpaHibs(baby.getID());
    }

    public List<DabtIpaHib> getDabtIpaHibs() {
        return dabtIpaHibs;
    }

    public void setDabtIpaHibs(List<DabtIpaHib> dabtIpaHibs) {
        this.dabtIpaHibs = dabtIpaHibs;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public void updateDabtIpaHib(int item) {
        String msg = "";
        switch (item) {
            case 1:
                if (baby.getDabtIpaHib().isFirstDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setFirstDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setFirstDabtIpaHibStatus(true);
                }
                msg = Vaccines.allVaccines[6];
                break;
            case 2:
                if (baby.getDabtIpaHib().isSecondDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setSecondDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setSecondDabtIpaHibStatus(true);
                }
                msg = Vaccines.allVaccines[7];
                break;
            case 3:
                if (baby.getDabtIpaHib().isThirdDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setThirdDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setThirdDabtIpaHibStatus(true);
                }
                msg = Vaccines.allVaccines[8];
                break;
            case 4:
                if (baby.getDabtIpaHib().isFourthDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setFourthDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setFourthDabtIpaHibStatus(true);
                }
                msg = Vaccines.allVaccines[9];
                break;
            case 5:
                if (baby.getDabtIpaHib().isFifthDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setFifthDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setFifthDabtIpaHibStatus(true);
                }
                msg = Vaccines.allVaccines[10];
                break;
            case 6:
                if (baby.getDabtIpaHib().isSixthDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setSixthDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setSixthDabtIpaHibStatus(true);
                }
                msg = Vaccines.allVaccines[11];
        }
        if (transaction.updateDabtIpaHib(baby.getDabtIpaHib())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATED));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATE_ERROR));
        }
        dabtIpaHibs = transaction.dabtIpaHibs(baby.getID());
    }
}
