package org.academiadecodigo.onegitwonders.service.jpa;

import org.academiadecodigo.onegitwonders.dao.Dao;
import org.academiadecodigo.onegitwonders.model.Mission;
import org.academiadecodigo.onegitwonders.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissionServiceImpl extends AbstractJpaService<Mission> implements MissionService {

    @Autowired
    public MissionServiceImpl(Dao<Mission> dao) {
        super(dao, Mission.class);
    }
}
