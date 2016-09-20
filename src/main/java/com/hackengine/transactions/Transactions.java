/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.transactions;

import com.hackengine.entities.Baby;
import com.hackengine.entities.Comment;
import com.hackengine.entities.HepatitisA;
import com.hackengine.entities.Kkk;
import com.hackengine.entities.Kpa;
import com.hackengine.entities.Opa;
import com.hackengine.entities.Rva;
import com.hackengine.entities.User;
import com.hackengine.loglevel.LogLevel;
import com.hackengine.queries.Queries;
import com.hackengine.tags.Tags;
import com.hackengine.utils.SessionUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author muslumoncel
 */
public class Transactions {

    private final Integer[] OPA_DATES = {180, 540};
    private final Integer[] HEPATIT_A_DATES = {540, 720};
    private final Integer[] HEPATIT_B_DATES = {0, 30, 180};
    private final Integer[] BCG_DATES = {60};
    private final Integer[] DaBT_IPA_HIB_DATES = {60, 120, 180, 540};
    private final Integer[] KPA_DATES = {60, 120, 180, 360};
    private final Integer[] KKK_DATES = {360};
    private final Integer[] VARICELLA_DATES = {360};
    private final Integer[] RVA_DATES = {60, 120, 180};

    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private static Session session = null;

    private void openSession() {
        session = factory.openSession();
    }

    public String register(User user) {
        try {
            openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return Tags.SUCCESS;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return Tags.FAIL;
    }

    public String logIn(String username, String password) {
        openSession();
        User u = (User) session.createQuery(Queries.LOG_IN_QUERY).setString(0, username).uniqueResult();
        if (u != null && u.getPassword().equals(password)) {
            SessionUtils.getSession().setAttribute(Tags.LOGGED_USER, u);
            switch (u.getLogLevel()) {
                case USER:
                    return Tags.USER_PAGE;
                case DOCTOR:
                    return Tags.DOCTOR_PAGE;
                case ADMIN:
                    return Tags.ADMIN_PAGE;
            }
        }
        return Tags.FAIL;
    }

    public static List<User> getDoctors() {
        return session.createQuery(Queries.GET_USERS).setString(0, LogLevel.DOCTOR.name()).list();
    }

    public static List<User> getNormalUsers() {
        return session.createQuery(Queries.GET_USERS).setString(0, LogLevel.USER.name()).list();
    }

    public static List<Baby> getBabies(int id) {
        return session.createQuery(Queries.GET_BABIES).setInteger(0, id).list();
    }

    public static List<Comment> getComments() {
        return session.createQuery(Queries.GET_COMMENTS).list();
    }

    public void addDoctor(User doctor) {
        try {
            openSession();
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void deleteUser(User user) {
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void deleteBaby(Baby baby) {
        try {
            session.beginTransaction();
            session.delete(baby);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void mapBabyToUser(User user, Baby baby) {
        Date birthday = baby.getDateOfBirth();
        Opa opa = createOpa(birthday);
        HepatitisA hepatitisA = createHepatitisA(birthday);
        Rva rva = createRva(birthday);
        Kpa kpa = createKpa(birthday);
        Kkk kkk = createKkk(birthday);
        try {
            openSession();
            session.beginTransaction();
            session.save(baby);
            opa.setBaby(baby);
            hepatitisA.setBaby(baby);
            rva.setBaby(baby);
            kpa.setBaby(baby);
            kkk.setBaby(baby);
            baby.setUser(user);
            baby.setOpa(opa);
            baby.setHepatitisA(hepatitisA);
            baby.setRva(rva);
            baby.setKpa(kpa);
            baby.setKkk(kkk);
            user.getBabies().add(baby);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void addComment(User user, Comment comment) {
        try {
            openSession();
            session.beginTransaction();
            session.save(comment);
            comment.setUser(user);
            user.getComments().add(comment);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void deleteComment(Comment comment) {
        try {
            session.beginTransaction();
            session.delete(comment);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private Opa createOpa(Date birthday) {
        Opa opa = new Opa();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, OPA_DATES[0]);
        opa.setFirstOpaDate(calendar.getTime());
        opa.setFirstOpaStatus(false);

        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, OPA_DATES[1]);
        opa.setSecondOpaDate(calendar.getTime());
        opa.setSecondOpaStatus(false);
        return opa;
    }

    private HepatitisA createHepatitisA(Date birthday) {
        HepatitisA hepatitisA = new HepatitisA();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, HEPATIT_A_DATES[0]);
        hepatitisA.setFirstHepatitisADate(calendar.getTime());
        hepatitisA.setFirstHepatitisAStatus(false);

        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, HEPATIT_A_DATES[1]);
        hepatitisA.setSecondHepatitisADate(calendar.getTime());
        hepatitisA.setSecondHepatitisAStatus(false);

        return hepatitisA;
    }

    private Rva createRva(Date birthday) {
        Rva rva = new Rva();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, RVA_DATES[0]);
        rva.setFirstRvaDate(calendar.getTime());
        rva.setFirstRvaStatus(false);

        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, RVA_DATES[1]);
        rva.setSecondRvaDate(calendar.getTime());
        rva.setSecondRvaStatus(false);

        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, RVA_DATES[2]);
        rva.setThirdRvaDate(calendar.getTime());
        rva.setThirdRvaStatus(false);

        return rva;
    }

    private Kpa createKpa(Date birthday) {
        Kpa kpa = new Kpa();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, KPA_DATES[0]);
        kpa.setFirstKpaDate(calendar.getTime());
        kpa.setFirstKpaStatus(false);

        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, KPA_DATES[1]);
        kpa.setSecondKpaDate(calendar.getTime());
        kpa.setSecondKpaStatus(false);

        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, KPA_DATES[2]);
        kpa.setThirdKpaDate(calendar.getTime());
        kpa.setThirdKpaStatus(false);

        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, KPA_DATES[3]);
        kpa.setFourthKpaDate(calendar.getTime());
        kpa.setFourthKpaStatus(false);

        return kpa;
    }

    private Kkk createKkk(Date birthday) {
        Kkk kkk = new Kkk();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);

        calendar.add(Calendar.DATE, KKK_DATES[0]);
        kkk.setFirstKkkDate(calendar.getTime());
        kkk.setFirstKkkStatus(false);

        kkk.setSecondKkkDate(Tags.SECOND_KKK);
        kkk.setSeconKkkStatus(false);

        return kkk;
    }

    public static void closeSession() {
        session.clear();
        session.disconnect();
        session.close();
    }
}
