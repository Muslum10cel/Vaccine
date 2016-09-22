/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.Opa;
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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@SessionScoped
public class OpaBean implements Serializable {

    private Baby baby;

    private Transactions transaction = null;

    private List<Opa> opas = null;

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        opas = Transactions.opas(baby.getID());
        transaction = new Transactions();
    }

    public List<Opa> getOpas() {
        return opas;
    }

    public void setOpas(List<Opa> opas) {
        this.opas = opas;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public void updateOpa(int item) {
        String msg = "";
        switch (item) {
            case 1:
                if (baby.getOpa().isFirstOpaStatus()) {
                    baby.getOpa().setFirstOpaStatus(false);
                } else {
                    baby.getOpa().setFirstOpaStatus(true);
                }
                msg = Vaccines.allVaccines[23];
                break;
            case 2:
                if (baby.getOpa().isSecondOpaStatus()) {
                    baby.getOpa().setSecondOpaStatus(false);
                } else {
                    baby.getOpa().setSecondOpaStatus(true);
                }
                msg = Vaccines.allVaccines[24];

        }
        if (transaction.updateOpa(baby.getOpa())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATED));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATE_ERROR));
        }
        opas = Transactions.opas(baby.getID());
    }

}
