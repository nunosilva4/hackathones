package org.academiadecodigo.onegitwonders.service;

import org.academiadecodigo.onegitwonders.dao.GangsterDaoImpl;
import org.academiadecodigo.onegitwonders.model.Crew;
import org.academiadecodigo.onegitwonders.model.Gangster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GangsterServicesImpl implements GangsterServices {

    private GangsterDaoImpl gangsterDao;

    @Autowired
    public void setGangsterDao(GangsterDaoImpl gangsterDao) {
        this.gangsterDao = gangsterDao;
    }

    @Transactional
    @Override
    public Gangster findByName(String name) throws Exception {
        if (Objects.isNull(gangsterDao.findByName(name))) {
            throw new Exception();
        }

        return gangsterDao.findByName(name);
    }

    @Transactional
    @Override
    public List<Gangster> sortedList() {
        List<Gangster> gangsters = gangsterDao.findAll();

        return gangsters.stream().sorted(Comparator.comparing(Gangster::getStreetRep))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Gangster create(Gangster gangster) throws Exception {

        if (Objects.isNull(gangsterDao.findByName(gangster.getStreetName()))){
            return gangsterDao.save(gangster);
        }

        throw new Exception();
    }

    @Transactional
    @Override
    public Gangster edit(Gangster gangster) throws Exception {

        if (Objects.isNull(gangsterDao.findByName(gangster.getStreetName()))){
            throw  new Exception();
        }

        return gangsterDao.save(gangster);
    }

    @Transactional
    @Override
    public void delete(String name) throws Exception {

        if (Objects.isNull(gangsterDao.findByName(name))) {
            throw new Exception();
        }

        gangsterDao.delete(name);

    }
}
