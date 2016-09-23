/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.HepatitisB;
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
public class HepatitisBBean implements Serializable {

    private Baby baby;

    private Transactions transaction = null;

    private List<HepatitisB> hepatitisB = null;

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        hepatitisB = Transactions.hepatitisBs(baby.getID());
        transaction = new Transactions();
    }

    public void setHepatitisB(List<HepatitisB> hepatitisB) {
        this.hepatitisB = hepatitisB;
    }

    public List<HepatitisB> getHepatitisB() {
        return hepatitisB;
    }

    public void updateHepatitisB(int item) {
        String msg = "";
        switch (item) {
            case 1:
                if (baby.getHepatitisB().isFirstHepatitisBStatus()) {
                    baby.getHepatitisB().setFirstHepatitisBStatus(false);
                } else {
                    baby.getHepatitisB().setFirstHepatitisBStatus(true);
                }
                msg = Vaccines.allVaccines[20];
                break;
            case 2:
                if (baby.getHepatitisB().isSecondHepatitisBStatus()) {
                    baby.getHepatitisB().setSecondHepatitisBStatus(false);
                } else {
                    baby.getHepatitisB().setSecondHepatitisBStatus(true);
                }
                msg = Vaccines.allVaccines[21];
                break;
            case 3:
                if (baby.getHepatitisB().isThirdHepatitisBStatus()) {
                    baby.getHepatitisB().setThirdHepatitisBStatus(false);
                } else {
                    baby.getHepatitisB().setThirdHepatitisBStatus(true);
                }
                msg = Vaccines.allVaccines[22];
        }
        if (transaction.updateHepatitisB(baby.getHepatitisB())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATED));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATE_ERROR));
        }
        hepatitisB = Transactions.hepatitisBs(baby.getID());
    }
}
