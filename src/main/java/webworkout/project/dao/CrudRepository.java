package webworkout.project.dao;

import webworkout.project.exception.NoneexistingEntityException;

import java.util.Collection;

public interface CrudRepository<K, V extends Identifiable<K>> {
    Collection<V> findAll();

    V findById(K id);
    V create(V entity);
    V update(V entity) throws NoneexistingEntityException;
    V deleteById(K id) throws NoneexistingEntityException;
    long count();

    void save();

    void load();
}
