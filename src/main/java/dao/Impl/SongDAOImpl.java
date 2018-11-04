package dao.Impl;

import dao.SongDAO;
import models.Artist;
import models.Song;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.SongService;
import utils.HibernateSessionFactoryUtil;
import java.sql.SQLException;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SongDAOImpl implements SongDAO {
    public void save(Song song) throws SQLException, NullPointerException {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(song);
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

    public void update(Song song) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(song);
        tx1.commit();
        session.close();
    }

    public void delete(Song song) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(song);
        tx1.commit();
        session.close();
    }

    public void deleteAll(List<Song> songs) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        songs.forEach(session::delete);

        tx1.commit();
        session.close();
    }

    public List<Song> findAll() {
        Session session = null;
        List<Song> songs = new ArrayList<>();
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            songs = session.createQuery("from Song").list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findAllById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return songs;
    }

    public Song findById(int id) {
        Session session = null;
        Song song = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            song = (Song) session.load(Song.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return song;
    }

    public Song findByName(String name) {
        Session session = null;
        Song song = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Song where name like :paramName");
            query.setParameter("paramName", name);
            List list = query.list();
            if (list.size() != 0) {
                song = (Song) list.get(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findByName'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return song;
    }
}
