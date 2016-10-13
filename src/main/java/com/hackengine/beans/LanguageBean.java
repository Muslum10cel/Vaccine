/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@SessionScoped
public class LanguageBean implements Serializable {

    private String localeCode;
    public static Locale locale;

    private static final Map<String, Object> countries;

    static {
        countries = new LinkedHashMap<>();
        countries.put("English", Locale.ENGLISH); //label, value
        countries.put("Türkçe", new Locale("tr"));
        locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
    }

    public Map<String, Object> getCountriesInMap() {
        return countries;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public void setLocale(Locale locale) {
        LanguageBean.locale = locale;
    }

    public void countryLocaleCodeChanged(ValueChangeEvent e) {

        String newLocaleValue = e.getNewValue().toString();
        for (Map.Entry<String, Object> entry : countries.entrySet()) {
            if (entry.getValue().toString().equals(newLocaleValue)) {
                locale = (Locale) entry.getValue();
            }
        }
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
