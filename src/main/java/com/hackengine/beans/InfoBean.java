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
        InputStreamReader inputStream = null;

        if (isLocaleEn()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.EN_RESOURCES + Files.WHAT_IS_VACCINATION));
        } else if (isLocaleTR()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.TR_RESOURCES + Files.WHAT_IS_VACCINATION));
        }

        return readFromFile(inputStream);
    }

    public String getInOurCountry() throws IOException {
        InputStreamReader inputStream = null;

        if (isLocaleEn()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.EN_RESOURCES + Files.IN_OUR_COUNTRY));
        } else if (isLocaleTR()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.TR_RESOURCES + Files.IN_OUR_COUNTRY));
        }

        return readFromFile(inputStream);
    }

    public String getAims() throws IOException {
        InputStreamReader inputStream = null;

        if (isLocaleEn()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.EN_RESOURCES + Files.AIMS));
        } else if (isLocaleTR()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.TR_RESOURCES + Files.AIMS));
        }
        return readFromFile(inputStream);
    }

    public String getHepatitisB() throws IOException {
        InputStreamReader inputStream = null;
        if (isLocaleEn()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.EN_RESOURCES + Files.HEPATITIS_B));
        } else if (isLocaleTR()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.EN_RESOURCES + Files.HEPATITIS_B));
        }

        return readFromFile(inputStream);
    }

    public String getBcg() throws IOException {
        InputStreamReader inputStream = null;

        if (isLocaleEn()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.EN_RESOURCES + Files.BCG));
        } else if (isLocaleTR()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.EN_RESOURCES + Files.BCG));
        }

        return readFromFile(inputStream);
    }

     public String getDabtIpaHib() throws IOException {
        InputStreamReader inputStream = null;

        if (isLocaleEn()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.EN_RESOURCES + Files.DABT_IPA_HIB));
        } else if (isLocaleTR()) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(Tags.EN_RESOURCES + Files.DABT_IPA_HIB));
        }

        return readFromFile(inputStream);
    }
    
    private String readFromFile(InputStreamReader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder builder = new StringBuilder();
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
