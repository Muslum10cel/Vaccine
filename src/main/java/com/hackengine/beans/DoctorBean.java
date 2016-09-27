/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Comment;
import com.hackengine.genders.Gender;
import com.hackengine.tags.Tags;
import com.hackengine.transactions.Transactions;
import com.hackengine.utils.SessionUtils;
import com.hackengine.vaccines.Vaccines;
import java.io.Serializable;
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
public class DoctorBean implements Serializable {

    private List<Comment> comments;

    private Transactions transaction = null;

    @PostConstruct
    public void init() {
        transaction = new Transactions();
        comments = transaction.getComments();
    }

    public Gender[] getGenders() {
        return Gender.values();
    }

    public String[] getVaccines() {
        return Vaccines.allVaccines;
    }

    public String logOut() {
        transaction.closeSession();
        SessionUtils.getSession().invalidate();
        return Tags.THANKS;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void deleteComment(Comment comment) {
        transaction.deleteComment(comment);
        comments = transaction.getComments();
    }

    public void newComments() {
        comments = transaction.getComments();
    }
}
