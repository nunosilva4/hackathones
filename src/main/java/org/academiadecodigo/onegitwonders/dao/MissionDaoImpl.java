package org.academiadecodigo.onegitwonders.dao;

import org.academiadecodigo.onegitwonders.model.Mission;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class MissionDaoImpl implements MissionDao {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public Mission findById(Integer id) {

        return em.find(Mission.class, id);
    }

    @Override
    public List<Mission> findAll() {

        CriteriaQuery<Mission> criteriaQuery = em.getCriteriaBuilder().createQuery(Mission.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Mission save(Mission mission) {
        return em.merge(mission);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(Mission.class, id));
    }
}
