package org.academiadecodigo.onegitwonders.dao;

import org.academiadecodigo.onegitwonders.model.Mission;
import org.springframework.stereotype.Repository;

@Repository
public class MissionDaoImpl extends GenericDaoImpl<Mission> {

    public MissionDaoImpl() {
        super(Mission.class);
    }

}
