package org.academiadecodigo.onegitwonders.dao;

import org.academiadecodigo.onegitwonders.exceptions.MalformedGangsterException;
import org.academiadecodigo.onegitwonders.model.Gangster;
import org.springframework.stereotype.Repository;

@Repository
public class GangsterDaoImpl extends GenericDaoImpl<Gangster> {

    public GangsterDaoImpl() {
        super(Gangster.class);
    }

    @Override
    public Gangster save(Gangster modelObject) {
        try {
            return super.save(modelObject);
        } catch (Exception e) {
            throw new MalformedGangsterException();
        }
    }
}
