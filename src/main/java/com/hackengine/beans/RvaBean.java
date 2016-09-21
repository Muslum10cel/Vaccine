/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.Rva;
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
public class RvaBean implements Serializable {

    private Baby baby;

    private Transactions transaction = null;

    private List<Rva> rvas = null;

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        rvas = Transactions.rvas(baby.getID());
        transaction = new Transactions();
    }

    public List<Rva> getRvas() {
        return rvas;
    }

    public void setRvas(List<Rva> rvas) {
        this.rvas = rvas;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public void updateRva(int item) {
        switch (item) {
            case 1:
                if (baby.getRva().isFirstRvaStatus()) {
                    baby.getRva().setFirstRvaStatus(false);
                } else {
                    baby.getRva().setFirstRvaStatus(true);
                }
                break;
            case 2:
                if (baby.getRva().isSecondRvaStatus()) {
                    baby.getRva().setSecondRvaStatus(false);
                } else {
                    baby.getRva().setSecondRvaStatus(true);
                }
                break;
            case 3:
                if (baby.getRva().isThirdRvaStatus()) {
                    baby.getRva().setThirdRvaStatus(false);
                } else {
                    baby.getRva().setThirdRvaStatus(true);
                }
        }
        transaction.updateRva(baby.getRva());
        rvas = Transactions.rvas(baby.getID());
    }
}
