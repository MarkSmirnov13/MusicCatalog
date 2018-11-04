package services;

import dao.Impl.ArtistDAOImpl;
import models.Artist;
import models.Song;

import java.sql.SQLException;
import java.util.List;

public class ArtistService {
    private ArtistDAOImpl artistDAOImpl = new ArtistDAOImpl();

    public Artist findArtistById(int id) {
        return artistDAOImpl.findById(id);
    }

    public void saveArtist(Artist artist) throws NullPointerException, SQLException {
        artistDAOImpl.save(artist);
    }

    public void updateArtist(Artist artist) {
        artistDAOImpl.update(artist);
    }

    public void deleteArtist(Artist artist) {
        artistDAOImpl.delete(artist);
    }

    public void deleteAllArtists(List<Artist> artists) {
        artistDAOImpl.deleteAll(artists);
    }

    public List<Artist> findAllArtists() {
        return artistDAOImpl.findAll();
    }

    public List<Song> findSongsById(int id) {
        return artistDAOImpl.findSongsById(id);
    }

    public Artist findArtistByName(String name) {
        return artistDAOImpl.findByName(name);
    }
}
