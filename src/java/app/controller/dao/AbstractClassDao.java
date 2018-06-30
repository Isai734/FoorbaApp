/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author isai.castro
 * 
 */

@Repository
public abstract class AbstractClassDao<E> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractClassDao.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void addPerson(E entitie) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(entitie);
        logger.info("Saved successfully, Object Details=" + entitie);
    }

    public void updatePerson(E entitie) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(entitie);
        logger.info("Updated successfully, Object Details=" + entitie);
    }

    @SuppressWarnings("unchecked")
    public List<E> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<E> entitieList = session.createQuery("from Person").list();
        for (E entitie : entitieList) {
            logger.info("Person List::" + entitie);
        }        return entitieList;
    }

    public E getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        E entitie=null;
        entitie = (E) session.load(entitie.getClass(), new Integer(id));
        logger.info("Person loaded successfully, Person details=" + entitie);
        return entitie;
    }

    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        E entitie=null;
        entitie = (E) session.load(entitie.getClass(), new Integer(id));
        if (null != entitie) {
            session.delete(entitie);
        }
        logger.info("Person deleted successfully, person details=" + entitie);
    }

}
