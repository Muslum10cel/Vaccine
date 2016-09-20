/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.service;

import com.hackengine.entities.DabtIpaHib;
import com.hackengine.entities.HepatitisA;
import com.hackengine.entities.HepatitisB;
import com.hackengine.entities.Kkk;
import com.hackengine.entities.Kpa;
import com.hackengine.entities.Opa;
import com.hackengine.entities.OtherVaccines;
import com.hackengine.entities.Rva;
import com.hackengine.tags.Tags;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author muslumoncel
 */
public class Service {

    private static final Integer[] OPA_DATES = {180, 540};
    private static final Integer[] HEPATIT_A_DATES = {540, 720};
    private static final Integer[] HEPATIT_B_DATES = {0, 30, 180};
    private static final Integer[] BCG_DATES = {60};
    private static final Integer[] DABT_IPA_HIB_DATES = {60, 120, 180, 540};
    private static final Integer[] KPA_DATES = {60, 120, 180, 360};
    private static final Integer[] KKK_DATES = {360};
    private static final Integer[] VARICELLA_DATES = {360};
    private static final Integer[] RVA_DATES = {60, 120, 180};

    public final Opa createOpa(Date birthday) {
        Opa opa = new Opa();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, OPA_DATES[0]);
        opa.setFirstOpaDate(calendar.getTime());
        opa.setFirstOpaStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, OPA_DATES[1]);
        opa.setSecondOpaDate(calendar.getTime());
        opa.setSecondOpaStatus(false);
        return opa;
    }

    public final HepatitisA createHepatitisA(Date birthday) {
        HepatitisA hepatitisA = new HepatitisA();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, HEPATIT_A_DATES[0]);
        hepatitisA.setFirstHepatitisADate(calendar.getTime());
        hepatitisA.setFirstHepatitisAStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, HEPATIT_A_DATES[1]);
        hepatitisA.setSecondHepatitisADate(calendar.getTime());
        hepatitisA.setSecondHepatitisAStatus(false);

        return hepatitisA;
    }

    public final Rva createRva(Date birthday) {
        Rva rva = new Rva();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, RVA_DATES[0]);
        rva.setFirstRvaDate(calendar.getTime());
        rva.setFirstRvaStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, RVA_DATES[1]);
        rva.setSecondRvaDate(calendar.getTime());
        rva.setSecondRvaStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, RVA_DATES[2]);
        rva.setThirdRvaDate(calendar.getTime());
        rva.setThirdRvaStatus(false);

        return rva;
    }

    public final Kpa createKpa(Date birthday) {
        Kpa kpa = new Kpa();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, KPA_DATES[0]);
        kpa.setFirstKpaDate(calendar.getTime());
        kpa.setFirstKpaStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, KPA_DATES[1]);
        kpa.setSecondKpaDate(calendar.getTime());
        kpa.setSecondKpaStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, KPA_DATES[2]);
        kpa.setThirdKpaDate(calendar.getTime());
        kpa.setThirdKpaStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, KPA_DATES[3]);
        kpa.setFourthKpaDate(calendar.getTime());
        kpa.setFourthKpaStatus(false);

        return kpa;
    }

    public final Kkk createKkk(Date birthday) {
        Kkk kkk = new Kkk();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, KKK_DATES[0]);
        kkk.setFirstKkkDate(calendar.getTime());
        kkk.setFirstKkkStatus(false);

        kkk.setSecondKkkDate(Tags.SECOND_KKK);
        kkk.setSeconKkkStatus(false);

        return kkk;
    }

    public final HepatitisB createHepatitisB(Date birthday) {
        HepatitisB hepatitisB = new HepatitisB();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, HEPATIT_B_DATES[0]);
        hepatitisB.setFirstHepatitsB(calendar.getTime());
        hepatitisB.setFirstHepatitisBStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, HEPATIT_B_DATES[1]);
        hepatitisB.setScondHepatitsB(calendar.getTime());
        hepatitisB.setSecondHepatitisBStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, HEPATIT_B_DATES[2]);
        hepatitisB.setThirdHepatitsB(calendar.getTime());
        hepatitisB.setThirdHepatitisBStatus(false);

        return hepatitisB;
    }

    public final DabtIpaHib createDabtIpaHib(Date birthday) {
        DabtIpaHib dabtIpaHib = new DabtIpaHib();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, DABT_IPA_HIB_DATES[0]);
        dabtIpaHib.setFirstDabtIpaHib(calendar.getTime());
        dabtIpaHib.setFirstDabtIpaHibStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, DABT_IPA_HIB_DATES[1]);
        dabtIpaHib.setSecondDabtIpaHib(calendar.getTime());
        dabtIpaHib.setSecondDabtIpaHibStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, DABT_IPA_HIB_DATES[2]);
        dabtIpaHib.setThirdDabtIpaHib(calendar.getTime());
        dabtIpaHib.setThirdDabtIpaHibStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, DABT_IPA_HIB_DATES[3]);
        dabtIpaHib.setFourthDabtIpaHib(calendar.getTime());
        dabtIpaHib.setFourthDabtIpaHibStatus(false);

        dabtIpaHib.setFifthDabtIpaHib(Tags.FIFTH_DABT_IPA_HIB);
        dabtIpaHib.setFifthDabtIpaHibStatus(false);

        dabtIpaHib.setSixthDabtIpaHib(Tags.SIXTH_DABT_IPA_HIB);
        dabtIpaHib.setSixthDabtIpaHibStatus(false);

        return dabtIpaHib;
    }

    public final OtherVaccines createOtherVaccines(Date birthday) {
        OtherVaccines otherVaccines = new OtherVaccines();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, BCG_DATES[0]);
        otherVaccines.setBcgDate(calendar.getTime());
        otherVaccines.setBcgStatus(false);

        calendar.setTime(birthday);
        calendar.add(Calendar.DATE, VARICELLA_DATES[0]);
        otherVaccines.setVaricellaDate(calendar.getTime());
        otherVaccines.setVaricellaStatus(false);

        otherVaccines.setDabtIpa(Tags.DABT_IPA);
        otherVaccines.setDabtIpaStatus(false);

        otherVaccines.setKma4(Tags.KMA4);
        otherVaccines.setKma4Status(false);

        otherVaccines.setHpa(Tags.HPA);
        otherVaccines.setHpaStatus(false);

        otherVaccines.setInfluenza(Tags.INFLUENZA);
        otherVaccines.setInfluenzaStatus(false);

        return otherVaccines;
    }
}
