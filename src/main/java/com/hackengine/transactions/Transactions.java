/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.transactions;

import com.hackengine.entities.Baby;
import com.hackengine.entities.Comment;
import com.hackengine.entities.DabtIpaHib;
import com.hackengine.entities.HepatitisA;
import com.hackengine.entities.HepatitisB;
import com.hackengine.entities.Kkk;
import com.hackengine.entities.Kpa;
import com.hackengine.entities.Opa;
import com.hackengine.entities.OtherVaccines;
import com.hackengine.entities.Rva;
import com.hackengine.entities.User;
import com.hackengine.loglevel.LogLevel;
import com.hackengine.messages.Messages;
import com.hackengine.queries.Queries;
import com.hackengine.service.Service;
import com.hackengine.tags.Tags;
import com.hackengine.utils.SessionUtils;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author muslumoncel
 */
public class Transactions {

    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private static final Service service = new Service();
    private Session session = null;

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
        User u = (User) SessionUtils.getSession().getAttribute(Tags.LOGGED_USER);
        if (u != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, Messages.LOG_IN_ERROR, Messages.ALREADY_LOGGED_IN));
            return null;
        }
        try {
            openSession();
            u = (User) session.createQuery(Queries.LOG_IN_QUERY).setString(Tags.USERNAME, username).uniqueResult();
            if (u != null) {
                if (u.getPassword().equals(password)) {
                    SessionUtils.getSession().setAttribute(Tags.LOGGED_USER, u);
                    switch (u.getLogLevel()) {
                        case USER:
                            return Tags.USER_PAGE;
                        case DOCTOR:
                            return Tags.DOCTOR_PAGE;
                        case ADMIN:
                            return Tags.ADMIN_PAGE;
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Messages.PASSWORD_ERROR, Messages.PASSWORD_ERROR_DETAIL + username));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, Messages.LOG_IN_ERROR, username + Messages.LOG_IN_ERROR_DETAIL));
            }
        } catch (JDBCConnectionException e) {
            System.out.println(e.toString());
            return Tags.FAIL;
        }
        return null;
    }

    public List<User> getDoctors() {
        openSession();
        return session.createQuery(Queries.GET_USERS).setString(Tags.LOG_LEVEL, LogLevel.DOCTOR.name()).list();
    }

    public List<User> getNormalUsers() {
        openSession();
        return session.createQuery(Queries.GET_USERS).setString(Tags.LOG_LEVEL, LogLevel.USER.name()).list();
    }

    public List<Baby> getBabies(int id) {
        openSession();
        return session.createQuery(Queries.GET_BABIES).setInteger(Tags.USER_ID, id).list();
    }

    public List<Comment> getComments() {
        openSession();
        return session.createQuery(Queries.GET_COMMENTS).list();
    }

    public List<DabtIpaHib> dabtIpaHibs(int baby_id) {
        openSession();
        return session.createQuery(Queries.GET_DABT_IPA_HIB).setInteger(Tags.BABY_ID, baby_id).list();
    }

    public List<HepatitisA> hepatitisAs(int baby_id) {
        openSession();
        return session.createQuery(Queries.GET_HEPATITIS_A).setInteger(Tags.BABY_ID, baby_id).list();
    }

    public List<HepatitisB> hepatitisBs(int baby_id) {
        openSession();
        return session.createQuery(Queries.GET_HEPATITIS_B).setInteger(Tags.BABY_ID, baby_id).list();
    }

    public List<Kkk> kkks(int baby_id) {
        openSession();
        return session.createQuery(Queries.GET_KKK).setInteger(Tags.BABY_ID, baby_id).list();
    }

    public List<Kpa> kpas(int baby_id) {
        openSession();
        return session.createQuery(Queries.GET_KPA).setInteger(Tags.BABY_ID, baby_id).list();
    }

    public List<Opa> opas(int baby_id) {
        openSession();
        return session.createQuery(Queries.GET_OPA).setInteger(Tags.BABY_ID, baby_id).list();
    }

    public List<Rva> rvas(int baby_id) {
        openSession();
        return session.createQuery(Queries.GET_RVA).setInteger(Tags.BABY_ID, baby_id).list();
    }

    public List<OtherVaccines> otherVaccines(int baby_id) {
        openSession();
        return session.createQuery(Queries.GET_OTHER_VACCINES).setInteger(Tags.BABY_ID, baby_id).list();
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
        Opa opa = service.createOpa(birthday);
        HepatitisA hepatitisA = service.createHepatitisA(birthday);
        Rva rva = service.createRva(birthday);
        Kpa kpa = service.createKpa(birthday);
        Kkk kkk = service.createKkk(birthday);
        HepatitisB hepatitisB = service.createHepatitisB(birthday);
        DabtIpaHib dabtIpaHib = service.createDabtIpaHib(birthday);
        OtherVaccines otherVaccines = service.createOtherVaccines(birthday);
        try {
            openSession();
            session.beginTransaction();
            session.save(baby);
            opa.setBaby(baby);
            hepatitisA.setBaby(baby);
            rva.setBaby(baby);
            kpa.setBaby(baby);
            kkk.setBaby(baby);
            hepatitisB.setBaby(baby);
            dabtIpaHib.setBaby(baby);
            otherVaccines.setBaby(baby);
            baby.setUser(user);
            baby.setOpa(opa);
            baby.setHepatitisA(hepatitisA);
            baby.setRva(rva);
            baby.setKpa(kpa);
            baby.setKkk(kkk);
            baby.setHepatitisB(hepatitisB);
            baby.setDabtIpaHib(dabtIpaHib);
            baby.setOtherVaccines(otherVaccines);
            user.getBabies().add(baby);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public boolean addComment(User user, Comment comment) {
        try {
            openSession();
            session.beginTransaction();
            session.save(comment);
            comment.setUser(user);
            user.getComments().add(comment);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
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

    public boolean updateDabtIpaHib(DabtIpaHib dabtIpaHib) {
        try {
            openSession();
            session.beginTransaction();
            session.update(dabtIpaHib);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean updateHepatitisA(HepatitisA hepatitisA) {
        try {
            openSession();
            session.beginTransaction();
            session.update(hepatitisA);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean updateHepatitisB(HepatitisB hepatitisB) {
        try {
            openSession();
            session.beginTransaction();
            session.update(hepatitisB);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean updateKkk(Kkk kkk) {
        try {
            openSession();
            session.beginTransaction();
            session.update(kkk);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean updateKpa(Kpa kpa) {
        try {
            openSession();
            session.beginTransaction();
            session.update(kpa);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean updateOpa(Opa opa) {
        try {
            openSession();
            session.beginTransaction();
            session.update(opa);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean updateRva(Rva rva) {
        try {
            openSession();
            session.beginTransaction();
            session.update(rva);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean updateOtherVaccines(OtherVaccines otherVaccines) {
        try {
            openSession();
            session.beginTransaction();
            session.update(otherVaccines);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public void closeSession() {
        openSession();
        session.clear();
        session.disconnect();
        session.close();
    }
}
