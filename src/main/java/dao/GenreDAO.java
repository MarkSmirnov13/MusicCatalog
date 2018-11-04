package dao;

import models.Genre;

import java.util.List;

public interface GenreDAO {
    public void save(Genre genre) throws Exception;
    public void update(Genre genre);
    public void delete(Genre genre);
    public void deleteAll(List<Genre> genres);
    public List<Genre> findAll();
    public Genre findById(int id);
    public Genre findByName(String name);
}
