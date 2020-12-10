package org.academiadecodigo.onegitwonders.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class GenericDaoImpl<T> implements CRUDDao<T> {

    @PersistenceContext
    protected EntityManager em;
    protected Class<T> modelType;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public GenericDaoImpl(Class<T> modelType) {
        this.modelType = modelType;
    }

    @Override
    public T findByName(String name) {

        return em.find(modelType, name);
    }

    @Override
    public List<T> findAll() {

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T save(T modelObject) {

        return em.merge(modelObject);

    }

    @Override
    public void delete(String name) {

        em.remove(em.find(modelType, name));

    }
}

