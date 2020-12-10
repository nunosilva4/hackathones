package org.academiadecodigo.onegitwonders.dao;

import java.util.List;

public interface CRUDDao<T> {

    T findByName(String name);

    List<T> findAll();

    T save(T modelObject);

    void delete(String name);
}
