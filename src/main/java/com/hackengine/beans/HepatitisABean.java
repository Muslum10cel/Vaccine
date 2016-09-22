/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.HepatitisA;
import com.hackengine.tags.Tags;
import com.hackengine.transactions.Transactions;
import com.hackengine.utils.SessionUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@RequestScoped
public class HepatitisABean implements Serializable {

    private Baby baby;

    private Transactions transaction = null;

    private List<HepatitisA> hepatitisA = null;

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        hepatitisA = Transactions.hepatitisAs(baby.getID());
        transaction = new Transactions();
    }

    public List<HepatitisA> getHepatitisA() {
        return hepatitisA;
    }

    public void setHepatitisA(List<HepatitisA> hepatitisA) {
        this.hepatitisA = hepatitisA;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }
    
    public void updateHepatitisA(int item) {
        switch (item) {
            case 1:
                if (baby.getHepatitisA().isFirstHepatitisAStatus()) {
                    baby.getHepatitisA().setFirstHepatitisAStatus(false);
                } else {
                    baby.getHepatitisA().setFirstHepatitisAStatus(true);
                }
                break;
            case 2:
                if (baby.getHepatitisA().isSecondHepatitisAStatus()) {
                    baby.getHepatitisA().setSecondHepatitisAStatus(false);
                } else {
                    baby.getHepatitisA().setSecondHepatitisAStatus(true);
                }
        }
        transaction.updateHepatitisA(baby.getHepatitisA());
        hepatitisA = Transactions.hepatitisAs(baby.getID());
    }
}