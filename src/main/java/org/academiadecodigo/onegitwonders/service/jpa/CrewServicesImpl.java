package org.academiadecodigo.onegitwonders.service.jpa;

import org.academiadecodigo.onegitwonders.dao.Dao;
import org.academiadecodigo.onegitwonders.exceptions.CrewNotFoundException;
import org.academiadecodigo.onegitwonders.model.Crew;
import org.academiadecodigo.onegitwonders.model.Gangster;
import org.academiadecodigo.onegitwonders.service.CrewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CrewServicesImpl extends AbstractJpaService<Crew> implements CrewServices {

    @Autowired
    public CrewServicesImpl(Dao<Crew> crewDao) {
        super(crewDao, Crew.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Gangster> listMembers(Integer id) {
        Crew crew = Optional.ofNullable(dao.get(id)).orElseThrow(CrewNotFoundException::new);
        return crew.getMembers();
    }
}
