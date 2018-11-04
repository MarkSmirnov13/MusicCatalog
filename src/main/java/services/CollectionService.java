package services;

import dao.Impl.CollectionDAOImpl;
import models.Collection;

import java.sql.SQLException;
import java.util.List;

public class CollectionService {
    CollectionDAOImpl collectionDAOImpl = new CollectionDAOImpl();

    public void saveCollection(Collection collection) {
        collectionDAOImpl.save(collection);
    }

    public void updateCollection(Collection collection) {
        collectionDAOImpl.update(collection);
    }

    public void deleteCollection(Collection collection) {
        collectionDAOImpl.delete(collection);
    }

    public void deleteAllCollections(List<Collection> collections) {
        collectionDAOImpl.deleteAll(collections);
    }

    public List<Collection> findAllCollections() {
        return collectionDAOImpl.findAll();
    }

    public Collection findCollectionById(int id) {
        return collectionDAOImpl.findById(id);
    }

    public Collection findCollectionByName(String name) {
        return collectionDAOImpl.findByName(name);
    }
}
