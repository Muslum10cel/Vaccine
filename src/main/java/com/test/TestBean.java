/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@SessionScoped
public class TestBean {

    @PostConstruct
    public void init() {
        try {
            getReadFromFile();
        } catch (IOException ex) {
            Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getReadFromFile() throws IOException {
        InputStreamReader inputStream = null;
        Locale locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
        if (locale.toString().equals("en")) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/file/en/whatisvaccination.txt"));
        } else if (locale.toString().equals("tr")) {
            inputStream = new InputStreamReader(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/file/tr/whatisvaccination.txt"));
        }

        BufferedReader bufferedReader = new BufferedReader(inputStream);
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
