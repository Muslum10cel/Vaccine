/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.Kkk;
import com.hackengine.tags.Tags;
import com.hackengine.transactions.Transactions;
import com.hackengine.utils.SessionUtils;
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
public class KkkBean {

    private Baby baby;

    private Transactions transaction = null;

    private List<Kkk> kkks = null;

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        kkks = Transactions.kkks(baby.getID());
        transaction = new Transactions();
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
        switch (item) {
            case 1:
                if (baby.getKkk().isFirstKkkStatus()) {
                    baby.getKkk().setFirstKkkStatus(false);
                } else {
                    baby.getKkk().setFirstKkkStatus(true);
                }
                break;
            case 2:
                if (baby.getKkk().isSecondKkkStatus()) {
                    baby.getKkk().setSecondKkkStatus(false);
                } else {
                    baby.getKkk().setSecondKkkStatus(true);
                }
        }
        transaction.updateKkk(baby.getKkk());
        kkks = Transactions.kkks(baby.getID());
    }
}
