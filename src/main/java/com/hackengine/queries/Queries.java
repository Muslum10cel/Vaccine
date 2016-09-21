/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.queries;

/**
 *
 * @author muslumoncel
 */
public class Queries {

    public static final String LOG_IN_QUERY = "FROM User U WHERE U.username = ?";
    public static final String GET_USERS = "FROM User U WHERE U.logLevel = ?";
    public static final String GET_BABIES = "FROM Baby B WHERE B.user.ID = ?";
    public static final String GET_COMMENTS = "FROM Comment C";
    public static final String GET_DABT_IPA_HIB = "FROM DabtIpaHib DIH WHERE DIH.baby.ID = ?";
}
