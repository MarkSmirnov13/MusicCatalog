package dao.Impl;

import dao.AlbumDAO;
import models.Album;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAOImpl implements AlbumDAO {
    @Override
    public void save(Album album) {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(album);
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
    public void update(Album album) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(album);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Album album) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(album);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteAll(List<Album> albums) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        albums.forEach(session::delete);

        tx1.commit();
        session.close();
    }

    @Override
    public List<Album> findAll() {
        Session session = null;
        List<Album> albums = new ArrayList<>();
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            albums = session.createQuery("from Album").list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findAllById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return albums;
    }

    @Override
    public Album findById(int id) {
        Session session = null;
        Album album = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            album = (Album) session.load(Album.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return album;
    }

    @Override
    public Album findByName(String name) {
        Session session = null;
        Album album = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Album where name like :paramName");
            query.setParameter("paramName", "%" + name + "%");
            List list = query.list();
            if (list.size() != 0) {
                album = (Album) list.get(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findByName'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return album;
    }
}
