/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.tags.Tags;
import com.hackengine.transactions.Transactions;
import com.hackengine.utils.SessionUtils;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    public String logOut() {
        Transactions.closeSession();
        SessionUtils.getSession().invalidate();
        return Tags.THANKS;
    }
}