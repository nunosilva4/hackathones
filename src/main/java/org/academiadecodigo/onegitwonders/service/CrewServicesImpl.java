package org.academiadecodigo.onegitwonders.service;

import org.academiadecodigo.onegitwonders.dao.CRUDDao;
import org.academiadecodigo.onegitwonders.dao.CrewDaoImpl;
import org.academiadecodigo.onegitwonders.model.Crew;
import org.academiadecodigo.onegitwonders.model.Gangster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CrewServicesImpl implements CrewServices {

    private CrewDaoImpl crewDao;

    @Autowired
    public void setCrewDao(CrewDaoImpl crewDao) {
        this.crewDao = crewDao;
    }

    @Transactional
    @Override
    public Crew findByName(String name) {

        return crewDao.findByName(name);
    }

    @Transactional
    @Override
    public List<Crew> sortedList() {

        List<Crew> crewList = crewDao.findAll();

        return crewList.stream().sorted(Comparator.comparing(Crew::getCrewRep))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Crew create(Crew crew) throws Exception {

        if (Objects.isNull(crewDao.findByName(crew.getName()))){
            return crewDao.save(crew);
        }

        throw new Exception();
    }

    @Transactional
    @Override
    public Crew edit(Crew crew) throws Exception {

        if (Objects.isNull(crewDao.findByName(crew.getName()))){
            throw  new Exception();
        }

        return crewDao.save(crew);
    }

    @Transactional
    @Override
    public void delete(String name) throws Exception {

        if (Objects.isNull(crewDao.findByName(name))) {
            throw new Exception();
        }

        crewDao.delete(name);
    }

    @Transactional
    @Override
    public List<Gangster> findMembers(String name) throws Exception {

        if (Objects.isNull(crewDao.findByName(name))) {
            throw new Exception();
        }

        return crewDao.findByName(name).getMembers();
    }
}
