/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.Kpa;
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
public class KpaBean implements Serializable {

    private Baby baby;

    private Transactions transaction = null;

    private List<Kpa> kpas = null;

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        kpas = Transactions.kpas(baby.getID());
        transaction = new Transactions();
    }

    public void setKpas(List<Kpa> kpas) {
        this.kpas = kpas;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public List<Kpa> getKpas() {
        return kpas;
    }

    public Baby getBaby() {
        return baby;
    }

    public void updateKpa(int item) {
        String msg = "";
        switch (item) {
            case 1:
                if (baby.getKpa().isFirstKpaStatus()) {
                    baby.getKpa().setFirstKpaStatus(false);
                } else {
                    baby.getKpa().setFirstKpaStatus(true);
                }
                msg = Vaccines.allVaccines[12];
                break;
            case 2:
                if (baby.getKpa().isSecondKpaStatus()) {
                    baby.getKpa().setSecondKpaStatus(false);
                } else {
                    baby.getKpa().setSecondKpaStatus(true);
                }
                msg = Vaccines.allVaccines[13];
                break;
            case 3:
                if (baby.getKpa().isThirdKpaStatus()) {
                    baby.getKpa().setThirdKpaStatus(false);
                } else {
                    baby.getKpa().setThirdKpaStatus(true);
                }
                msg = Vaccines.allVaccines[14];
                break;
            case 4:
                if (baby.getKpa().isFourthKpaStatus()) {
                    baby.getKpa().setFourthKpaStatus(false);
                } else {
                    baby.getKpa().setFourthKpaStatus(true);
                }
                msg = Vaccines.allVaccines[15];
        }
        if (transaction.updateKpa(baby.getKpa())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATED));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATE_ERROR));
        }
        kpas = Transactions.kpas(baby.getID());
    }
}
