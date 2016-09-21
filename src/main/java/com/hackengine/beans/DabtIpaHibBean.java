/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.DabtIpaHib;
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
public class DabtIpaHibBean implements Serializable {

    private Baby baby;

    private Transactions transaction = null;

    private List<DabtIpaHib> dabtIpaHibs = null;

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        dabtIpaHibs = Transactions.dabtIpaHibs(baby.getID());
        transaction = new Transactions();
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
        switch (item) {
            case 1:
                if (baby.getDabtIpaHib().isFirstDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setFirstDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setFirstDabtIpaHibStatus(true);
                }
                break;
            case 2:
                if (baby.getDabtIpaHib().isSecondDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setSecondDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setSecondDabtIpaHibStatus(true);
                }
                break;
            case 3:
                if (baby.getDabtIpaHib().isThirdDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setThirdDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setThirdDabtIpaHibStatus(true);
                }
                break;
            case 4:
                if (baby.getDabtIpaHib().isFourthDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setFourthDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setFourthDabtIpaHibStatus(true);
                }
                break;
            case 5:
                if (baby.getDabtIpaHib().isFifthDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setFifthDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setFifthDabtIpaHibStatus(true);
                }
                break;
            case 6:
                if (baby.getDabtIpaHib().isSixthDabtIpaHibStatus()) {
                    baby.getDabtIpaHib().setSixthDabtIpaHibStatus(false);
                } else {
                    baby.getDabtIpaHib().setSixthDabtIpaHibStatus(true);
                }
        }
        transaction.updateDabtIpaHib(baby.getDabtIpaHib());
        dabtIpaHibs = Transactions.dabtIpaHibs(baby.getID());
    }
}
