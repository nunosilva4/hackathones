package org.academiadecodigo.onegitwonders.service;

import java.util.List;

public interface CRUDServices<T> {

    List<T> list();

    T get(Integer id);

    T save(T modelObject);

    void delete(Integer id);
}
