package dao;

import models.Artist;
import models.Song;

import java.util.List;

public interface ArtistDAO {
    public void save(Artist artist) throws Exception;
    public void update(Artist artist);
    public void delete(Artist artist);
    public void deleteAll(List<Artist> atrists);
    public Artist findById(int id);
    public List<Artist> findAll();
    public List<Song> findSongsById(int id);
    public Artist findByName(String name);
}
