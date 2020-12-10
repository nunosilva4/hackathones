package org.academiadecodigo.onegitwonders.dao;

import java.util.List;

public interface Dao<T> {

    T get(Integer id);

    List<T> list();

    T save(T modelObject);

    void delete(Integer id);
}
