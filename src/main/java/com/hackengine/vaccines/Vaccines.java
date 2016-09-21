/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.vaccines;

import com.hackengine.db.TableNames;

/**
 *
 * @author muslumoncel
 */
public class Vaccines {

    public static final String[] allVaccines = {
        "BCG",
        "DaBT IPA",
        "Varicella",
        "Kma4",
        "Hpa",
        "Influenza",
        "First Dabt Ipa Hib",
        "Second Dabt Ipa Hib",
        "Third Dabt Ipa Hib",
        "Fourth Dabt Ipa Hib",
        "Fifth Dabt Ipa Hib",
        "Sixth Dabt Ipa Hib",
        "First Kpa",
        "Second Kpa",
        "Third Kpa",
        "Fourth Kpa",
        "First Kkk",
        "Second Kkk",
        "First Hepatitis A",
        "Second Hepatitis A",
        "First Hepatitis B",
        "Second Hepatitis B",
        "Third Hepatitis B",
        "First Opa",
        "Second Opa",
        "First Rva",
        "Second Rva",
        "Third Rva"
    };

    public static final String[] vaccines = {
        TableNames.DABT_IPA_HIB,
        TableNames.HEPATITIS_A,
        TableNames.HEPATITIS_B,
        TableNames.KKK,
        TableNames.KPA,
        TableNames.OPA,
        TableNames.OTHER_VACCINES,
        TableNames.RVA
    };
}
