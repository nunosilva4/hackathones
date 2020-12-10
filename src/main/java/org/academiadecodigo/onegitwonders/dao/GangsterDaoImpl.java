package org.academiadecodigo.onegitwonders.dao;

import org.academiadecodigo.onegitwonders.model.Gangster;
import org.springframework.stereotype.Repository;

@Repository
public class GangsterDaoImpl extends GenericDaoImpl<Gangster> {

    public GangsterDaoImpl(Class<Gangster> modelType) {
        super(modelType);
    }
}
