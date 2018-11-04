package dao.Impl;

import dao.ArtistDAO;
import models.Artist;
import models.Song;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAOImpl implements ArtistDAO {
    public void save(Artist artist) throws NullPointerException{
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(artist);
        tx1.commit();
        session.close();
    }


    public void update(Artist artist) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(artist);
        tx1.commit();
        session.close();
    }

    public void delete(Artist artist) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(artist);
        tx1.commit();
        session.close();
    }

    public void deleteAll(List<Artist> atrists) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        atrists.forEach(session::delete);

        tx1.commit();
        session.close();
    }

    public Artist findById(int id) {
        Session session = null;
        Artist artist = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            artist = (Artist) session.load(Artist.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return artist;
    }

    public List<Artist> findAll() {
        Session session = null;
        List<Artist> artists = new ArrayList<>();
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            artists = session.createQuery("from Artist").list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findAllById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return artists;
    }

    public List<Song> findSongsById(int id) {
        Session session = null;
        List<Song> songs = new ArrayList<>();
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Song where artist_id = :id_param");
            query.setParameter("id_param", id);
            songs = query.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return songs;
    }

    @Override
    public Artist findByName(String name) {
        Session session = null;
        Artist artist = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Artist where name = :paramName");
            query.setParameter("paramName", name);
            List list = query.list();
            if (list.size() != 0) {
                artist = (Artist) list.get(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findByName'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return artist;
    }
}
