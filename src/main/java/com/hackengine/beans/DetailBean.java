/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.DabtIpaHib;
import com.hackengine.entities.HepatitisA;
import com.hackengine.entities.HepatitisB;
import com.hackengine.entities.Kkk;
import com.hackengine.entities.Kpa;
import com.hackengine.entities.Opa;
import com.hackengine.entities.OtherVaccines;
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
public class DetailBean implements Serializable {

    private Baby baby;

    private Transactions transaction = null;

    private List<DabtIpaHib> dabtIpaHibs = null;

    private List<HepatitisA> hepatitisA = null;

    private List<HepatitisB> hepatitisB = null;

    private List<Kkk> kkks = null;

    private List<Kpa> kpas = null;

    private List<Opa> opas = null;

    private List<OtherVaccines> others = null;

    private List<Rva> rvas = null;

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        dabtIpaHibs = Transactions.dabtIpaHibs(baby.getID());
        hepatitisA = Transactions.hepatitisAs(baby.getID());
        hepatitisB = Transactions.hepatitisBs(baby.getID());
        kkks = Transactions.kkks(baby.getID());
        kpas = Transactions.kpas(baby.getID());
        opas = Transactions.opas(baby.getID());
        others = Transactions.otherVaccines(baby.getID());
        rvas = Transactions.rvas(baby.getID());
        transaction = new Transactions();
    }

    public List<DabtIpaHib> getDabtIpaHibs() {
        return dabtIpaHibs;
    }

    public void setDabtIpaHibs(List<DabtIpaHib> dabtIpaHibs) {
        this.dabtIpaHibs = dabtIpaHibs;
    }

    public List<HepatitisA> getHepatitisA() {
        return hepatitisA;
    }

    public void setHepatitisA(List<HepatitisA> hepatitisA) {
        this.hepatitisA = hepatitisA;
    }

    public void setHepatitisB(List<HepatitisB> hepatitisB) {
        this.hepatitisB = hepatitisB;
    }

    public List<HepatitisB> getHepatitisB() {
        return hepatitisB;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public List<Kkk> getKkks() {
        return kkks;
    }

    public void setKkks(List<Kkk> kkks) {
        this.kkks = kkks;
    }

    public List<Kpa> getKpas() {
        return kpas;
    }

    public void setKpas(List<Kpa> kpas) {
        this.kpas = kpas;
    }

    public List<Opa> getOpas() {
        return opas;
    }

    public void setOpas(List<Opa> opas) {
        this.opas = opas;
    }

    public List<OtherVaccines> getOthers() {
        return others;
    }

    public void setOthers(List<OtherVaccines> others) {
        this.others = others;
    }

    public List<Rva> getRvas() {
        return rvas;
    }

    public void setRvas(List<Rva> rvas) {
        this.rvas = rvas;
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

    public void updateOpa(int item) {
        switch (item) {
            case 1:
                if (baby.getOpa().isFirstOpaStatus()) {
                    baby.getOpa().setFirstOpaStatus(false);
                } else {
                    baby.getOpa().setFirstOpaStatus(true);
                }
                break;
            case 2:
                if (baby.getOpa().isSecondOpaStatus()) {
                    baby.getOpa().setSecondOpaStatus(false);
                } else {
                    baby.getOpa().setSecondOpaStatus(true);
                }
        }
        transaction.updateOpa(baby.getOpa());
        opas = Transactions.opas(baby.getID());
    }

    public void updateOtherVaccines(int item) {
        switch (item) {
            case 1:
                if (baby.getOtherVaccines().isBcgStatus()) {
                    baby.getOtherVaccines().setBcgStatus(false);
                } else {
                    baby.getOtherVaccines().setBcgStatus(true);
                }
                break;
            case 2:
                if (baby.getOtherVaccines().isDabtIpaStatus()) {
                    baby.getOtherVaccines().setDabtIpaStatus(false);
                } else {
                    baby.getOtherVaccines().setDabtIpaStatus(true);
                }
                break;
            case 3:
                if (baby.getOtherVaccines().isHpaStatus()) {
                    baby.getOtherVaccines().setHpaStatus(false);
                } else {
                    baby.getOtherVaccines().setHpaStatus(true);
                }
                break;
            case 4:
                if (baby.getOtherVaccines().isInfluenzaStatus()) {
                    baby.getOtherVaccines().setInfluenzaStatus(false);
                } else {
                    baby.getOtherVaccines().setInfluenzaStatus(true);
                }
                break;
            case 5:
                if (baby.getOtherVaccines().isKma4Status()) {
                    baby.getOtherVaccines().setKma4Status(false);
                } else {
                    baby.getOtherVaccines().setKma4Status(true);
                }
                break;
            case 6:
                if (baby.getOtherVaccines().isVaricellaStatus()) {
                    baby.getOtherVaccines().setVaricellaStatus(false);
                } else {
                    baby.getOtherVaccines().setVaricellaStatus(true);
                }
        }
        transaction.updateOtherVaccines(baby.getOtherVaccines());
        others = Transactions.otherVaccines(baby.getID());
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
