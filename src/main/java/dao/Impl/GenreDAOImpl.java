package dao.Impl;

import dao.GenreDAO;
import models.Genre;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAOImpl implements GenreDAO {

    @Override
    public void save(Genre genre) {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(genre);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ExcS: " + e);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Genre genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(genre);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Genre genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(genre);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteAll(List<Genre> genres) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        genres.forEach(session::delete);

        tx1.commit();
        session.close();
    }

    @Override
    public List<Genre> findAll() {
        Session session = null;
        List<Genre> genres = new ArrayList<>();
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            genres = session.createQuery("from Genre").list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findAllById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return genres;
    }

    @Override
    public Genre findById(int id) {
        Session session = null;
        Genre genre = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            genre = (Genre) session.load(Genre.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return genre;
    }

    @Override
    public Genre findByName(String name) {
        Session session = null;
        Genre genre = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Genre where name like :paramName");
            query.setParameter("paramName", name);
            List list = query.list();
            if (list.size() != 0) {
                genre = (Genre) list.get(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findByName'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return genre;
    }
}
