/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.Kpa;
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
        switch (item) {
            case 1:
                if (baby.getKpa().isFirstKpaStatus()) {
                    baby.getKpa().setFirstKpaStatus(false);
                } else {
                    baby.getKpa().setFirstKpaStatus(true);
                }
                break;
            case 2:
                if (baby.getKpa().isSecondKpaStatus()) {
                    baby.getKpa().setSecondKpaStatus(false);
                } else {
                    baby.getKpa().setSecondKpaStatus(true);
                }
                break;
            case 3:
                if (baby.getKpa().isThirdKpaStatus()) {
                    baby.getKpa().setThirdKpaStatus(false);
                } else {
                    baby.getKpa().setThirdKpaStatus(true);
                }
                break;
            case 4:
                if (baby.getKpa().isFourthKpaStatus()) {
                    baby.getKpa().setFourthKpaStatus(false);
                } else {
                    baby.getKpa().setFourthKpaStatus(true);
                }
        }
        transaction.updateKpa(baby.getKpa());
        kpas = Transactions.kpas(baby.getID());
    }
}
