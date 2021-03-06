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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.NonUniqueResultException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author muslumoncel
 */
public class Transactions {

    private static final Logger LOG = Logger.getLogger(Transactions.class.getName());
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
            LOG.log(Level.INFO, Messages.REGISTRATION, user);
            return Tags.SUCCESS;
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, Messages.REGISTRATION_EXCEPTION, e);
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
            try {
                u = (User) session.createQuery(Queries.LOG_IN_QUERY).setString(Tags.USERNAME, username).uniqueResult();
                if (u != null) {
                    if (u.getPassword().equals(password)) {
                        LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.LOG_IN, u);
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
                        LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.PASSWORD_ERROR_LOGIN, u);
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Messages.PASSWORD_ERROR, Messages.PASSWORD_ERROR_DETAIL + username));
                    }
                } else {
                    LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.INVALID_USERNAME_ERROR, username);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, Messages.LOG_IN_ERROR, username + Messages.LOG_IN_ERROR_DETAIL));
                }
            } catch (NonUniqueResultException e) {
                LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.NONUNIQUE_RESULT_EXCEPTION, e);
            }
        } catch (JDBCConnectionException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.JDBC_EXCEPTION, e);
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
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.DOCTOR_ADDED, doctor);
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }

    }

    public void deleteUser(User user) {
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.USER_DELETED, user);
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
    }

    public void deleteBaby(Baby baby) {
        try {
            session.beginTransaction();
            session.delete(baby);
            session.getTransaction().commit();
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.BABY_DELETED, baby);
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
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
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.BABY_ADDED, new Object[]{baby, user});
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
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
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.COMMENT_ADDED, new Object[]{comment, user});
            return true;
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
        return false;
    }

    public void deleteComment(Comment comment) {
        try {
            session.beginTransaction();
            session.delete(comment);
            session.getTransaction().commit();
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.COMMENT_DELETED, comment);
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
    }

    public boolean updateDabtIpaHib(DabtIpaHib dabtIpaHib) {
        try {
            openSession();
            session.beginTransaction();
            session.update(dabtIpaHib);
            session.getTransaction().commit();
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.VACCINE_UPDATED, dabtIpaHib);
            return true;
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
        return false;
    }

    public boolean updateHepatitisA(HepatitisA hepatitisA) {
        try {
            openSession();
            session.beginTransaction();
            session.update(hepatitisA);
            session.getTransaction().commit();
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.VACCINE_UPDATED, hepatitisA);
            return true;
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
        return false;
    }

    public boolean updateHepatitisB(HepatitisB hepatitisB) {
        try {
            openSession();
            session.beginTransaction();
            session.update(hepatitisB);
            session.getTransaction().commit();
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.VACCINE_UPDATED, hepatitisB);
            return true;
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
        return false;
    }

    public boolean updateKkk(Kkk kkk) {
        try {
            openSession();
            session.beginTransaction();
            session.update(kkk);
            session.getTransaction().commit();
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.VACCINE_UPDATED, kkk);
            return true;
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
        return false;
    }

    public boolean updateKpa(Kpa kpa) {
        try {
            openSession();
            session.beginTransaction();
            session.update(kpa);
            session.getTransaction().commit();
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.VACCINE_UPDATED, kpa);
            return true;
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
        return false;
    }

    public boolean updateOpa(Opa opa) {
        try {
            openSession();
            session.beginTransaction();
            session.update(opa);
            session.getTransaction().commit();
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.VACCINE_UPDATED, opa);
            return true;
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
        return false;
    }

    public boolean updateRva(Rva rva) {
        try {
            openSession();
            session.beginTransaction();
            session.update(rva);
            session.getTransaction().commit();
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.VACCINE_UPDATED, rva);
            return true;
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
        return false;
    }

    public boolean updateOtherVaccines(OtherVaccines otherVaccines) {
        try {
            openSession();
            session.beginTransaction();
            session.update(otherVaccines);
            session.getTransaction().commit();
            LOG.logp(Level.INFO, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.VACCINE_UPDATED, otherVaccines);
            return true;
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
        return false;
    }

    public void uploadImage(Baby baby, byte[] image) {
        try {
            openSession();
            session.beginTransaction();
            baby.setBabyImage(image);
            session.update(baby);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOG.logp(Level.SEVERE, Transactions.class.getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), Messages.HIBERNATE_EXCEPTION, e);
        }
    }

    public void closeSession() {
        LOG.log(Level.INFO, Messages.SESSION_CLOSED);
        openSession();
        session.clear();
        session.disconnect();
        session.close();
    }
}
