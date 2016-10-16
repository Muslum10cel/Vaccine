/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.filenames.Files;
import com.hackengine.tags.Tags;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@SessionScoped
public class InfoBean implements Serializable {

    private Locale locale;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
    }

    public String getInfo() throws IOException {

        if (isLocaleEn()) {
            return readFromFile(0, 0);
        } else if (isLocaleTR()) {
            return readFromFile(0, 1);
        }
        return null;
    }

    public String getInOurCountry() throws IOException {

        if (isLocaleEn()) {
            return readFromFile(1, 0);
        } else if (isLocaleTR()) {
            return readFromFile(1, 1);
        }
        return null;
    }

    public String getAims() throws IOException {

        if (isLocaleEn()) {
            return readFromFile(2, 0);
        } else if (isLocaleTR()) {
            return readFromFile(2, 1);
        }
        return null;
    }

    public String getHepatitisB() throws IOException {

        if (isLocaleEn()) {
            return readFromFile(3, 0);
        } else if (isLocaleTR()) {
            return readFromFile(3, 1);
        }
        return null;
    }

    public String getBcg() throws IOException {

        if (isLocaleEn()) {
            return readFromFile(4, 0);
        } else if (isLocaleTR()) {
            return readFromFile(4, 1);
        }
        return null;
    }

    public String getDabtIpaHib() throws IOException {

        if (isLocaleEn()) {
            return readFromFile(5, 0);
        } else if (isLocaleTR()) {
            return readFromFile(5, 1);
        }
        return null;
    }

    public String getOpa() throws IOException {

        if (isLocaleEn()) {
            return readFromFile(6, 0);
        } else if (isLocaleTR()) {
            return readFromFile(6, 1);
        }
        return null;
    }

    public String getKpa() throws IOException {

        if (isLocaleEn()) {
            return readFromFile(7, 0);
        } else if (isLocaleTR()) {
            return readFromFile(7, 1);
        }
        return null;
    }

    public String getKkk() throws IOException {

        if (isLocaleEn()) {
            return readFromFile(8, 0);
        } else if (isLocaleTR()) {
            return readFromFile(8, 1);
        }
        return null;
    }

    public String getHepatitisA() throws IOException {

        if (isLocaleEn()) {
            return readFromFile(9, 0);
        } else if (isLocaleTR()) {
            return readFromFile(9, 1);
        }
        return null;
    }

    public String getRva() throws IOException {

        if (isLocaleEn()) {
            return readFromFile(10, 0);
        } else if (isLocaleTR()) {
            return readFromFile(10, 1);
        }
        return null;
    }

    private String readFromFile(int file, int lang) throws IOException {

        StringBuilder builder = new StringBuilder();

        switch (lang) {
            case 0:
                builder.append(Tags.EN_RESOURCES);
                break;
            case 1:
                builder.append(Tags.TR_RESOURCES);
        }

        switch (file) {
            case 0:
                builder.append(Files.WHAT_IS_VACCINATION);
                break;
            case 1:
                builder.append(Files.IN_OUR_COUNTRY);
                break;
            case 2:
                builder.append(Files.AIMS);
                break;
            case 3:
                builder.append(Files.HEPATITIS_B);
                break;
            case 4:
                builder.append(Files.BCG);
                break;
            case 5:
                builder.append(Files.DABT_IPA_HIB);
                break;
            case 6:
                builder.append(Files.OPA);
                break;
            case 7:
                builder.append(Files.KPA);
                break;
            case 8:
                builder.append(Files.KKK);
                break;
            case 9:
                builder.append(Files.HEPATITIS_A);
                break;
            case 10:
                builder.append(Files.RVA);
                break;
        }

        InputStreamReader reader = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(builder.toString()));
        BufferedReader bufferedReader = new BufferedReader(reader);
        builder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line);
            builder.append(Tags.NEW_LINE);
        }
        return builder.toString();
    }

    private boolean isLocaleEn() {
        return locale.toString().equals(Tags.EN);
    }

    private boolean isLocaleTR() {
        return locale.toString().equals(Tags.TR);
    }
}
