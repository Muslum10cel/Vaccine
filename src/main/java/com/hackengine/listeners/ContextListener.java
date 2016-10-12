/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.listeners;

import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author muslumoncel
 */
@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Locale locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
        System.out.println("Locale is " + locale);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
