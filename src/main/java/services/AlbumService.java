package services;

import dao.Impl.AlbumDAOImpl;
import models.Album;

import java.sql.SQLException;
import java.util.List;

public class AlbumService {
    AlbumDAOImpl albumDAOImpl = new AlbumDAOImpl();

    public void saveAlbum(Album album) throws NullPointerException, SQLException {
        albumDAOImpl.save(album);
    }

    public void updateAlbum(Album album) {
        albumDAOImpl.update(album);
    }

    public void deleteAlbum(Album album) {
        albumDAOImpl.delete(album);
    }

    public void deleteAllAlbums(List<Album> albums) {
        albumDAOImpl.deleteAll(albums);
    }

    public List<Album> findAllAlbums() {
        return albumDAOImpl.findAll();
    }

    public Album findAlbumById(int id) {
        return albumDAOImpl.findById(id);
    }

    public Album findAlbumByName(String name) {
        return albumDAOImpl.findByName(name);
    }
}
