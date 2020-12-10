package org.academiadecodigo.onegitwonders.service;

import java.util.List;

public interface CRUDServices<T> {

    T findByName(String name) throws Exception;

    List<T> sortedList();

    T create(T crew) throws Exception;

    T edit(T crew) throws Exception;

    void delete(String name) throws Exception;
}
