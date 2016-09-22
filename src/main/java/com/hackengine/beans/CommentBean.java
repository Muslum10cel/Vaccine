/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Comment;
import com.hackengine.entities.User;
import com.hackengine.genders.Gender;
import com.hackengine.tags.Tags;
import com.hackengine.transactions.Transactions;
import com.hackengine.utils.SessionUtils;
import com.hackengine.vaccines.Vaccines;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@SessionScoped
public class CommentBean implements Serializable {

    private String comment;

    private Gender gender;

    private String vaccinename;

    private Transactions transaction = null;

    private User user = null;

    @PostConstruct
    public void init() {
        user = (User) SessionUtils.getSession().getAttribute(Tags.LOGGED_USER);
        transaction = new Transactions();
    }

    public CommentBean() {
    }

    public Gender[] getGenders() {
        return Gender.values();
    }

    public String getComment() {
        return comment;
    }

    public Gender getGender() {
        return gender;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setVaccinename(String vaccinename) {
        this.vaccinename = vaccinename;
    }

    public String getVaccinename() {
        return vaccinename;
    }

    public String[] getVaccines() {
        return Vaccines.allVaccines;
    }

    public void addComment() {
        boolean result = transaction.addComment(user, new Comment(vaccinename, gender, new Date(), comment));
        if (result) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Comment Uploaded Successfully."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Comment Could not Be Uploaded!"));
        }
    }
}
