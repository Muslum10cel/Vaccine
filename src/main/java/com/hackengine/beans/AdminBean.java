/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.entities.User;
import com.hackengine.loglevel.LogLevel;
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
public class AdminBean implements Serializable{

    private Transactions transaction = null;

    private List<User> doctors;

    private List<User> users;

    private String doctorusername;

    private String doctorpassword;

    private String doctormail;

    private String doctorfullname;

    public List<User> getDoctors() {
        return doctors;
    }

    public List<User> getUsers() {
        return users;
    }

    @PostConstruct
    public void init() {
        transaction = new Transactions();
        doctors = Transactions.getDoctors();
        users = Transactions.getNormalUsers();
    }

    public String logOut() {
        Transactions.closeSession();
        SessionUtils.getSession().invalidate();
        return Tags.THANKS;
    }

    public String getDoctorusername() {
        return doctorusername;
    }

    public void setDoctorusername(String doctorusername) {
        this.doctorusername = doctorusername;
    }

    public String getDoctorpassword() {
        return doctorpassword;
    }

    public void setDoctorpassword(String doctorpassword) {
        this.doctorpassword = doctorpassword;
    }

    public String getDoctormail() {
        return doctormail;
    }

    public void setDoctormail(String doctormail) {
        this.doctormail = doctormail;
    }

    public String getDoctorfullname() {
        return doctorfullname;
    }

    public void setDoctorfullname(String doctorfullname) {
        this.doctorfullname = doctorfullname;
    }

    public void addDoctor() {
        transaction.addDoctor(new User(doctorusername, doctorpassword, doctormail, doctorfullname, LogLevel.DOCTOR, new Date()));
        doctors = Transactions.getDoctors();
    }

    public void deleteDoctor(User doctor) {
        transaction.deleteUser(doctor);
        doctors = Transactions.getDoctors();
    }

    public void deleteUser(User user) {
        transaction.deleteUser(user);
        users = Transactions.getNormalUsers();
    }
}