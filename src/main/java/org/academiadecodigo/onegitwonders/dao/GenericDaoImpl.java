package org.academiadecodigo.onegitwonders.dao;

import org.academiadecodigo.onegitwonders.exceptions.EntityNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericDaoImpl<T> implements Dao<T> {

    @PersistenceContext
    protected EntityManager entityManager;
    protected Class<T> modelType;

    public GenericDaoImpl(Class<T> modelType) {
        this.modelType = modelType;
    }

    @Override
    public List<T> list() {
        CriteriaQuery<T> criteriaQuery = entityManager
                .getCriteriaBuilder()
                .createQuery(modelType);

        Root<T> root = criteriaQuery.from(modelType);
        criteriaQuery.select(root);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T get(Integer id) {
        return entityManager.find(modelType, id);
    }

    @Override
    public T save(T modelObject) {
        return entityManager.merge(modelObject);
    }

    @Override
    public void delete(Integer id) {

        try {
            entityManager.remove(entityManager.find(modelType, id));
        } catch (RuntimeException e) {
            throw EntityNotFoundException.create(modelType);
        }
    }
}

