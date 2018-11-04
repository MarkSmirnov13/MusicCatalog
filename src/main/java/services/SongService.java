package services;

import dao.Impl.SongDAOImpl;
import models.*;
import java.lang.*;
import java.sql.SQLException;
import java.util.*;

public class SongService {
    private SongDAOImpl songDAOImpl = new SongDAOImpl();

    public void saveSong(Song song) throws NullPointerException, SQLException {
        songDAOImpl.save(song);
    }

    public void updateSong(Song song) {
        songDAOImpl.update(song);
    }

    public void deleteSong(Song song) {
        songDAOImpl.delete(song);
    }

    public void deleteAllSongs(List<Song> songs) {
        songDAOImpl.deleteAll(songs);
    }

    public List<Song> findAllSongs() {
        return songDAOImpl.findAll();
    }

    public Song findSongById(int id) {
        return songDAOImpl.findById(id);
    }

    public Song findSongByName(String name) {
        return songDAOImpl.findByName(name);
    }
}
