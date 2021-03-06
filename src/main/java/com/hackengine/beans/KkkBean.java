/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.Kkk;
import com.hackengine.messages.Messages;
import com.hackengine.tags.Tags;
import com.hackengine.transactions.Transactions;
import com.hackengine.utils.SessionUtils;
import com.hackengine.vaccines.Vaccines;
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
public class KkkBean {

    private Baby baby;

    private Transactions transaction = null;

    private List<Kkk> kkks = null;

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        transaction = new Transactions();
        kkks = transaction.kkks(baby.getID());
        
    }

    public List<Kkk> getKkks() {
        return kkks;
    }

    public void setKkks(List<Kkk> kkks) {
        this.kkks = kkks;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public void updateKkk(int item) {
        String msg = "";
        switch (item) {
            case 1:
                if (baby.getKkk().isFirstKkkStatus()) {
                    baby.getKkk().setFirstKkkStatus(false);
                } else {
                    baby.getKkk().setFirstKkkStatus(true);
                }
                msg = Vaccines.allVaccines[16];
                break;
            case 2:
                if (baby.getKkk().isSecondKkkStatus()) {
                    baby.getKkk().setSecondKkkStatus(false);
                } else {
                    baby.getKkk().setSecondKkkStatus(true);
                }
                msg = Vaccines.allVaccines[17];
        }
        if (transaction.updateKkk(baby.getKkk())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATED));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg + Messages.VACCINE_STATUS_UPDATE_ERROR));
        }
        kkks = transaction.kkks(baby.getID());
    }
}
