package org.academiadecodigo.onegitwonders.dao;

import org.academiadecodigo.onegitwonders.model.Crew;
import org.springframework.stereotype.Repository;

@Repository
public class CrewDaoImpl extends GenericDaoImpl<Crew> {

    public CrewDaoImpl() {
        super(Crew.class);
    }

}
