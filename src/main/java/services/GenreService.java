package services;

import dao.Impl.GenreDAOImpl;
import models.Genre;

import java.sql.SQLException;
import java.util.List;

public class GenreService {
    private GenreDAOImpl genreDAOImpl = new GenreDAOImpl();

    public void saveGenre(Genre genre) throws NullPointerException, SQLException {
        genreDAOImpl.save(genre);
    }

    public void updateGenre(Genre genre) {
        genreDAOImpl.update(genre);
    }

    public void deleteGenre(Genre genre) {
        genreDAOImpl.delete(genre);
    }

    public void deleteAllGenres(List<Genre> genres) {
        genreDAOImpl.deleteAll(genres);
    }

    public List<Genre> findAllGenres() {
        return genreDAOImpl.findAll();
    }

    public Genre findGenreById(int id) {
        return genreDAOImpl.findById(id);
    }

    public Genre findGenreByName(String name) {
        return genreDAOImpl.findByName(name);
    }
}
