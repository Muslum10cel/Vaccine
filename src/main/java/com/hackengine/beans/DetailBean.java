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
import com.hackengine.pages.Pages;
import com.hackengine.tags.Tags;
import com.hackengine.transactions.Transactions;
import com.hackengine.utils.SessionUtils;
import com.hackengine.vaccines.Vaccines;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@RequestScoped
public class DetailBean implements Serializable {

    private Baby baby = null;

    private Transactions transaction = null;

    private MenuModel menuModel;

    private PieChartModel dabtPie;

    private PieChartModel hepaPie;

    private PieChartModel hepbPie;

    private PieChartModel kkkPie;

    private PieChartModel kpaPie;

    private PieChartModel opaPie;

    private PieChartModel rvaPie;

    private PieChartModel otherPie;

    private int dabtDelayed;

    private int hepaDelayed;

    private int hepbDelayed;

    private int kkkDelayed;

    private int kpaDelayed;

    private int opaDelayed;

    private int rvaDelayed;

    private int otherDelayed;

    private static final Calendar calendar = Calendar.getInstance();

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        transaction = new Transactions();
        createDabtPie();
        createHepaPie();
        createHepbPie();
        createKkkPie();
        createKpaPie();
        createOpaPie();
        createRvaPie();
        createOthersPie();
    }

    public Baby getBaby() {
        return baby;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public PieChartModel getDabtPie() {
        return dabtPie;
    }

    public PieChartModel getHepbPie() {
        return hepbPie;
    }

    public PieChartModel getHepaPie() {
        return hepaPie;
    }

    public PieChartModel getKkkPie() {
        return kkkPie;
    }

    public PieChartModel getKpaPie() {
        return kpaPie;
    }

    public PieChartModel getOpaPie() {
        return opaPie;
    }

    public PieChartModel getRvaPie() {
        return rvaPie;
    }

    public PieChartModel getOtherPie() {
        return otherPie;
    }

    public int getDabtDelayed() {
        return dabtDelayed;
    }

    public int getHepaDelayed() {
        return hepaDelayed;
    }

    public int getHepbDelayed() {
        return hepbDelayed;
    }

    public int getKkkDelayed() {
        return kkkDelayed;
    }

    public int getKpaDelayed() {
        return kpaDelayed;
    }

    public int getOpaDelayed() {
        return opaDelayed;
    }

    public int getRvaDelayed() {
        return rvaDelayed;
    }

    public int getOtherDelayed() {
        return otherDelayed;
    }
    
    public String goToDetail(String vaccine) {
        switch (vaccine) {
            case Tags.DABT_IPA_HIB:
                return Pages.DABT_IPA_HIB_PAGE;
            case Tags.HEPATITIS_A:
                return Pages.HEPATITIS_A_PAGE;
            case Tags.HEPATITIS_B:
                return Pages.HEPATITIS_B_PAGE;
            case Tags.KKK:
                return Pages.KKK_PAGE;
            case Tags.KPA:
                return Pages.KPA_PAGE;
            case Tags.OPA:
                return Pages.OPA_PAGE;
            case Tags.RVA:
                return Pages.RVA_PAGE;
            case Tags.OTHERS:
                return Pages.OTHERS_PAGE;
        }
        return null;
    }

    private void createDabtPie() {
        dabtPie = new PieChartModel();

        List<DabtIpaHib> dab = transaction.dabtIpaHibs(baby.getID());

        int count = 0;
        for (DabtIpaHib dab1 : dab) {
            if (dab1.isFirstDabtIpaHibStatus()) {
                ++count;
            }
            if (dab1.isSecondDabtIpaHibStatus()) {
                ++count;
            }
            if (dab1.isThirdDabtIpaHibStatus()) {
                ++count;
            }
            if (dab1.isFourthDabtIpaHibStatus()) {
                ++count;
            }
            if (dab1.isFifthDabtIpaHibStatus()) {
                ++count;
            }
            if (dab1.isSixthDabtIpaHibStatus()) {
                ++count;
            }
        }
        for (DabtIpaHib dab1 : dab) {
            Calendar temp = Calendar.getInstance();
            temp.setTime(dab1.getFirstDabtIpaHib());
            if (calendar.after(temp) && !dab1.isFirstDabtIpaHibStatus()) {
                ++dabtDelayed;
            }
            temp.setTime(dab1.getSecondDabtIpaHib());
            if (calendar.after(temp) && !dab1.isSecondDabtIpaHibStatus()) {
                ++dabtDelayed;
            }
            temp.setTime(dab1.getThirdDabtIpaHib());
            if (calendar.after(temp) && !dab1.isThirdDabtIpaHibStatus()) {
                ++dabtDelayed;
            }
            temp.setTime(dab1.getFourthDabtIpaHib());
            if (calendar.after(temp) && dab1.isFourthDabtIpaHibStatus()) {
                ++dabtDelayed;
            }
        }

        dabtPie.set(Tags.DONE, count);
        dabtPie.set(Tags.REMAIN, 6 - count);
        dabtPie.setLegendPosition(Tags.LEGEND_POSITION);
        dabtPie.setTitle(Vaccines.vaccines[0]);
    }

    private void createHepaPie() {
        hepaPie = new PieChartModel();
        List<HepatitisA> hepatitisAs = transaction.hepatitisAs(baby.getID());
        int count = 0;
        for (HepatitisA ha : hepatitisAs) {
            if (ha.isFirstHepatitisAStatus()) {
                ++count;
            }
            if (ha.isSecondHepatitisAStatus()) {
                ++count;
            }
        }

        for (HepatitisA a : hepatitisAs) {
            Calendar temp = Calendar.getInstance();
            temp.setTime(a.getFirstHepatitisADate());
            if (calendar.after(temp) && !a.isFirstHepatitisAStatus()) {
                ++hepaDelayed;
            }
            temp.setTime(a.getSecondHepatitisADate());
            if (calendar.after(temp) && !a.isSecondHepatitisAStatus()) {
                ++hepaDelayed;
            }
        }

        hepaPie.set(Tags.DONE, count);
        hepaPie.set(Tags.REMAIN, 2 - count);
        hepaPie.setLegendPosition(Tags.LEGEND_POSITION);
        hepaPie.setTitle(Vaccines.vaccines[1]);
    }

    private void createHepbPie() {
        hepbPie = new PieChartModel();
        List<HepatitisB> hepatitisBs = transaction.hepatitisBs(baby.getID());
        int count = 0;
        for (HepatitisB hb : hepatitisBs) {
            if (hb.isFirstHepatitisBStatus()) {
                ++count;
            }
            if (hb.isSecondHepatitisBStatus()) {
                ++count;
            }
            if (hb.isThirdHepatitisBStatus()) {
                ++count;
            }
        }

        for (HepatitisB hb : hepatitisBs) {
            Calendar temp = Calendar.getInstance();
            temp.setTime(hb.getFirstHepatitisBDate());
            if (calendar.after(temp) && !hb.isFirstHepatitisBStatus()) {
                ++hepbDelayed;
            }
            temp.setTime(hb.getSecondHepatitisBDate());
            if (calendar.after(temp) && !hb.isSecondHepatitisBStatus()) {
                ++hepbDelayed;
            }
            temp.setTime(hb.getThirdHepatitisBDate());
            if (calendar.after(temp) && !hb.isThirdHepatitisBStatus()) {
                ++hepbDelayed;
            }
        }

        hepbPie.set(Tags.DONE, count);
        hepbPie.set(Tags.REMAIN, 3 - count);
        hepbPie.setLegendPosition(Tags.LEGEND_POSITION);
        hepbPie.setTitle(Vaccines.vaccines[2]);
    }

    private void createKkkPie() {
        kkkPie = new PieChartModel();
        List<Kkk> kkks = transaction.kkks(baby.getID());
        int count = 0;
        for (Kkk k : kkks) {
            if (k.isFirstKkkStatus()) {
                ++count;
            }
            if (k.isSecondKkkStatus()) {
                ++count;
            }
        }
        for (Kkk k : kkks) {
            Calendar temp = Calendar.getInstance();
            temp.setTime(k.getFirstKkkDate());
            if (calendar.after(temp) && !k.isFirstKkkStatus()) {
                ++kkkDelayed;
            }
        }
        kkkPie.set(Tags.DONE, count);
        kkkPie.set(Tags.REMAIN, 2 - count);
        kkkPie.setLegendPosition(Tags.LEGEND_POSITION);
        kkkPie.setTitle(Vaccines.vaccines[3]);
    }

    private void createKpaPie() {
        kpaPie = new PieChartModel();
        List<Kpa> kpas = transaction.kpas(baby.getID());
        int count = 0;
        for (Kpa k : kpas) {
            if (k.isFirstKpaStatus()) {
                ++count;
            }
            if (k.isSecondKpaStatus()) {
                ++count;
            }
            if (k.isThirdKpaStatus()) {
                ++count;
            }
            if (k.isFourthKpaStatus()) {
                ++count;
            }
        }

        for (Kpa k : kpas) {
            Calendar temp = Calendar.getInstance();
            temp.setTime(k.getFirstKpaDate());
            if (calendar.after(temp) && !k.isFirstKpaStatus()) {
                ++kpaDelayed;
            }
            temp.setTime(k.getSecondKpaDate());
            if (calendar.after(temp) && !k.isSecondKpaStatus()) {
                ++kpaDelayed;
            }
            temp.setTime(k.getThirdKpaDate());
            if (calendar.after(temp) && !k.isThirdKpaStatus()) {
                ++kpaDelayed;
            }
            temp.setTime(k.getFourthKpaDate());
            if (calendar.after(temp) && !k.isFourthKpaStatus()) {
                ++kpaDelayed;
            }
        }

        kpaPie.set(Tags.DONE, count);
        kpaPie.set(Tags.REMAIN, 4 - count);
        kpaPie.setLegendPosition(Tags.LEGEND_POSITION);
        kpaPie.setTitle(Vaccines.vaccines[4]);
    }

    private void createOpaPie() {
        opaPie = new PieChartModel();
        List<Opa> opas = transaction.opas(baby.getID());
        int count = 0;
        for (Opa o : opas) {
            if (o.isFirstOpaStatus()) {
                ++count;
            }
            if (o.isSecondOpaStatus()) {
                ++count;
            }
        }

        for (Opa o : opas) {
            Calendar temp = Calendar.getInstance();
            temp.setTime(o.getFirstOpaDate());
            if (calendar.after(temp) && !o.isFirstOpaStatus()) {
                ++opaDelayed;
            }
            temp.setTime(o.getSecondOpaDate());
            if (calendar.after(temp) && !o.isSecondOpaStatus()) {
                ++opaDelayed;
            }
        }
        opaPie.set(Tags.DONE, count);
        opaPie.set(Tags.REMAIN, 2 - count);
        opaPie.setLegendPosition(Tags.LEGEND_POSITION);
        opaPie.setTitle(Vaccines.vaccines[5]);
    }

    private void createRvaPie() {
        rvaPie = new PieChartModel();
        List<Rva> rvas = transaction.rvas(baby.getID());
        int count = 0;
        for (Rva rva : rvas) {
            if (rva.isFirstRvaStatus()) {
                ++count;
            }
            if (rva.isSecondRvaStatus()) {
                ++count;
            }
            if (rva.isThirdRvaStatus()) {
                ++count;
            }
        }

        for (Rva rva : rvas) {
            Calendar temp = Calendar.getInstance();
            temp.setTime(rva.getFirstRvaDate());
            if (calendar.after(temp) && !rva.isFirstRvaStatus()) {
                ++rvaDelayed;
            }
            temp.setTime(rva.getSecondRvaDate());
            if (calendar.after(temp) && !rva.isSecondRvaStatus()) {
                ++rvaDelayed;
            }
            temp.setTime(rva.getThirdRvaDate());
            if (calendar.after(temp) && !rva.isThirdRvaStatus()) {
                ++rvaDelayed;
            }
        }
        rvaPie.set(Tags.DONE, count);
        rvaPie.set(Tags.REMAIN, 3 - count);
        rvaPie.setLegendPosition(Tags.LEGEND_POSITION);
        rvaPie.setTitle(Vaccines.vaccines[6]);
    }

    private void createOthersPie() {
        otherPie = new PieChartModel();
        List<OtherVaccines> others = transaction.otherVaccines(baby.getID());
        int count = 0;
        for (OtherVaccines ov : others) {
            if (ov.isBcgStatus()) {
                ++count;
            }
            if (ov.isDabtIpaStatus()) {
                ++count;
            }
            if (ov.isHpaStatus()) {
                ++count;
            }
            if (ov.isInfluenzaStatus()) {
                ++count;
            }
            if (ov.isKma4Status()) {
                ++count;
            }
            if (ov.isVaricellaStatus()) {
                ++count;
            }
        }
        for (OtherVaccines ov : others) {
            Calendar temp = Calendar.getInstance();
            temp.setTime(ov.getBcgDate());
            if (calendar.after(temp) && !ov.isBcgStatus()) {
                ++otherDelayed;
            }
            temp.setTime(ov.getVaricellaDate());
            if (calendar.after(temp) && !ov.isVaricellaStatus()) {
                ++otherDelayed;
            }
        }
        otherPie.set(Tags.DONE, count);
        otherPie.set(Tags.REMAIN, 6 - count);
        otherPie.setLegendPosition(Tags.LEGEND_POSITION);
        otherPie.setTitle(Vaccines.vaccines[7]);
    }
}
