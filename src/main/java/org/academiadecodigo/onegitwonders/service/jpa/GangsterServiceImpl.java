package org.academiadecodigo.onegitwonders.service.jpa;

import org.academiadecodigo.onegitwonders.dao.Dao;
import org.academiadecodigo.onegitwonders.exceptions.GangsterNotFoundException;
import org.academiadecodigo.onegitwonders.model.Gangster;
import org.academiadecodigo.onegitwonders.service.GangsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GangsterServiceImpl extends AbstractJpaService<Gangster> implements GangsterService {

    @Autowired
    public GangsterServiceImpl(Dao<Gangster> dao) {
        super(dao, Gangster.class);
    }

    @Transactional(readOnly = true)
    @Override
    public Integer getRep(Integer id) {
        Gangster gangster = Optional.ofNullable(dao.get(id)).orElseThrow(GangsterNotFoundException::new);
        return gangster.getStreetRep();
    }
}