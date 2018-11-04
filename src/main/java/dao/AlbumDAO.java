package dao;

import models.Album;

import java.util.List;

public interface AlbumDAO {
    public void save(Album album) throws Exception;
    public void update(Album album);
    public void delete(Album album);
    public void deleteAll(List<Album> albums);
    public List<Album> findAll();
    public Album findById(int id);
    public Album findByName(String name);
}
