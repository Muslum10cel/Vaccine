/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.pages.Pages;
import com.hackengine.tags.Tags;
import com.hackengine.utils.SessionUtils;
import com.hackengine.vaccines.Vaccines;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@RequestScoped
public class DetailBean implements Serializable {

    private Baby baby = null;

    private MenuModel menuModel;

    public String[] getVaccines() {
        return Vaccines.vaccines;
    }

    @PostConstruct
    public void init() {
        baby = (Baby) SessionUtils.getSession().getAttribute(Tags.MAPPED_BY_BABY);
        menuModel = new DefaultMenuModel();

        DefaultSubMenu defaultSubMenu = new DefaultSubMenu(Tags.VACCINES);
        int i = 0;
        menuModel.addElement(defaultSubMenu);
        for (String vc : Vaccines.vaccines) {
            DefaultMenuItem item = new DefaultMenuItem(vc);
            item.setAjax(false);
            item.setOutcome(Pages.ALL_PAGES[i]);
            menuModel.addElement(item);
            i++;
        }
    }

    public Baby getBaby() {
        return baby;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

}
