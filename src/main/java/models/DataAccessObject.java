package models;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DataAccessObject {
    public DataAccessObject findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(DataAccessObject.class, id);
    }

    public void save() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(this);
        tx1.commit();
        session.close();
    }

    public void update() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(this);
        tx1.commit();
        session.close();
    }

    public void delete() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(this);
        tx1.commit();
        session.close();
    }

    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}
