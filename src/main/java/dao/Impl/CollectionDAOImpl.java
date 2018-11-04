package dao.Impl;

import dao.CollectionDAO;
import models.Collection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionDAOImpl implements CollectionDAO {

    @Override
    public void save(Collection collection) {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(collection);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ExcC: " + e);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Collection collection) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(collection);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Collection collection) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(collection);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteAll(List<Collection> collections) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        collections.forEach(session::delete);

        tx1.commit();
        session.close();
    }

    @Override
    public List<Collection> findAll() {
        Session session = null;
        List<Collection> collection = new ArrayList<>();
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            collection = session.createQuery("from Collection").list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findAllById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return collection;
    }

    @Override
    public Collection findById(int id) {
        Session session = null;
        Collection collection = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            collection = (Collection) session.load(Collection.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return collection;
    }

    @Override
    public Collection findByName(String name) {
        Session session = null;
        Collection collection = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Collection where name = :paramName");
            query.setParameter("paramName", name);
            List list = query.list();
            if (list.size() != 0) {
                collection = (Collection) list.get(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findByName'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return collection;
    }
}
