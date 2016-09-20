/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.User;
import com.hackengine.loglevel.LogLevel;
import com.hackengine.transactions.Transactions;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@RequestScoped
public class RegisterBean {

    private String username;

    private String password;

    private String email;

    private String fullname;

    private Transactions transaction;

    @PostConstruct
    public void init() {
        transaction = new Transactions();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String register() {
        return transaction.register(new User(username, password, email, fullname, LogLevel.USER, new Date()));
    }
}