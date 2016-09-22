/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.Comment;
import com.hackengine.tags.Tags;
import com.hackengine.transactions.Transactions;
import com.hackengine.utils.SessionUtils;
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
        comments = Transactions.getComments();
    }

    public String logOut() {
        Transactions.closeSession();
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
        comments = Transactions.getComments();
    }
    
    public void newComments(){
        comments = Transactions.getComments();
    }
}
