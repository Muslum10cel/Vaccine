/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Baby;
import com.hackengine.entities.User;
import com.hackengine.genders.Gender;
import com.hackengine.pages.Pages;
import com.hackengine.tags.Tags;
import com.hackengine.transactions.Transactions;
import com.hackengine.utils.SessionUtils;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@SessionScoped
public class BabyBean implements Serializable {

    private Transactions transaction = null;

    private User user = null;

    private String babyname;

    private Date birthday;

    private Gender gender;

    private List<Baby> babies;

    @PostConstruct
    public void init() {
        user = (User) SessionUtils.getSession().getAttribute(Tags.LOGGED_USER);
        transaction = new Transactions();
        babies = transaction.getBabies(user.getID());
    }

    public List<Baby> getBabies() {
        return babies;
    }

    public void setBabies(List<Baby> babies) {
        this.babies = babies;
    }

    public String getBabyname() {
        return babyname;
    }

    public void setBabyname(String babyname) {
        this.babyname = babyname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender[] getGenders() {
        return Gender.values();
    }

    public void addBaby() {
        transaction.mapBabyToUser(user, new Baby(babyname, gender, birthday));
        babies = transaction.getBabies(user.getID());
    }

    public void deleteBaby(Baby baby) {
        transaction.deleteBaby(baby);
        babies = transaction.getBabies(user.getID());
    }

    public String goToDetails(Baby baby) {
        SessionUtils.getSession().setAttribute(Tags.MAPPED_BY_BABY, baby);
        return Pages.DETAILS_PAGE;
    }
}
