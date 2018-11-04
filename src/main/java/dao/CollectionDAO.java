package dao;

import models.Collection;

import java.util.List;

public interface CollectionDAO {
    public void save(Collection collection) throws Exception;
    public void update(Collection collection);
    public void delete(Collection collection);
    public void deleteAll(List<Collection> collections);
    public List<Collection> findAll();
    public Collection findById(int id);
    public Collection findByName(String name);
}
