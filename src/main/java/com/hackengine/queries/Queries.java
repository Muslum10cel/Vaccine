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

    public static final String LOG_IN_QUERY = "FROM User U WHERE U.username =:username";
    public static final String GET_USERS = "FROM User U WHERE U.logLevel =:log_level";
    public static final String GET_BABIES = "FROM Baby B WHERE B.user.ID =:user_id";
    public static final String GET_COMMENTS = "FROM Comment C ORDER BY C.commentDate DESC";
    public static final String GET_DABT_IPA_HIB = "FROM DabtIpaHib DIH WHERE DIH.baby.ID =:baby_id";
    public static final String GET_HEPATITIS_A = "FROM HepatitisA HA WHERE HA.baby.ID =:baby_id";
    public static final String GET_HEPATITIS_B = "FROM HepatitisB HB WHERE HB.baby.ID =:baby_id";
    public static final String GET_OPA = "FROM Opa O WHERE O.baby.ID =:baby_id";
    public static final String GET_KPA = "FROM Kpa K WHERE K.baby.ID =:baby_id";
    public static final String GET_KKK = "FROM Kkk KK WHERE KK.baby.ID =:baby_id";
    public static final String GET_RVA = "FROM Rva R WHERE R.baby.ID =:baby_id";
    public static final String GET_OTHER_VACCINES = "FROM OtherVaccines OV WHERE OV.baby.ID =:baby_id";
}