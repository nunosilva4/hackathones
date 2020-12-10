package org.academiadecodigo.onegitwonders.service;

import java.util.List;

public interface CRUDServices<T> {

    T findById(Integer id);

    List<T> findAll();

    T saveOrUpdate(T entity);

    void delete(Integer id);
}
