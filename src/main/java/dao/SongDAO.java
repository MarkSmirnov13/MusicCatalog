package dao;

import models.*;

import java.util.List;

public interface SongDAO {
    public void save(Song song) throws Exception;
    public void update(Song song);
    public void delete(Song song);
    public void deleteAll(List<Song> songs);
    public List<Song> findAll();
    public Song findById(int id);
    public Song findByName(String name);
}
