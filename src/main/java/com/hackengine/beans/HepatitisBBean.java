/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.HepatitisB;
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
        switch (item) {
            case 1:
                if (baby.getHepatitisB().isFirstHepatitisBStatus()) {
                    baby.getHepatitisB().setFirstHepatitisBStatus(false);
                } else {
                    baby.getHepatitisB().setFirstHepatitisBStatus(true);
                }
                break;
            case 2:
                if (baby.getHepatitisB().isSecondHepatitisBStatus()) {
                    baby.getHepatitisB().setSecondHepatitisBStatus(false);
                } else {
                    baby.getHepatitisB().setSecondHepatitisBStatus(true);
                }
                break;
            case 3:
                if (baby.getHepatitisB().isThirdHepatitisBStatus()) {
                    baby.getHepatitisB().setThirdHepatitisBStatus(false);
                } else {
                    baby.getHepatitisB().setThirdHepatitisBStatus(true);
                }
        }
        transaction.updateHepatitisB(baby.getHepatitisB());
        hepatitisB = Transactions.hepatitisBs(baby.getID());
    }
}
