package org.academiadecodigo.onegitwonders.service.jpa;

import org.academiadecodigo.onegitwonders.dao.Dao;
import org.academiadecodigo.onegitwonders.exceptions.EntityNotFoundException;
import org.academiadecodigo.onegitwonders.model.Model;
import org.academiadecodigo.onegitwonders.service.CRUDServices;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class AbstractJpaService<T extends Model> implements CRUDServices<T> {

    protected Dao<T> dao;
    protected Class<T> type;

    public AbstractJpaService(Dao<T> dao, Class<T> type) {
        this.dao = dao;
        this.type = type;
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> list() {
        return dao.list();
    }

    @Transactional(readOnly = true)
    @Override
    public T get(Integer id) {
        return Optional.ofNullable(dao.get(id)).orElseThrow(() -> EntityNotFoundException.create(type));
    }

    @Transactional
    @Override
    public T save(T modelObject) {
        return dao.save(modelObject);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
