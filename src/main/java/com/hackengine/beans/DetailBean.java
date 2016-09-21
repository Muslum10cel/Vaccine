/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.pages.Pages;
import com.hackengine.tags.Tags;
import com.hackengine.vaccines.Vaccines;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@SessionScoped
public class DetailBean implements Serializable {

    public String[] getVaccines() {
        return Vaccines.vaccines;
    }

    public String displayDetailsOfVaccine(String vaccine) {
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
}
