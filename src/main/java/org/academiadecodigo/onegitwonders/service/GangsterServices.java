package org.academiadecodigo.onegitwonders.service;

import org.academiadecodigo.onegitwonders.model.Gangster;

public interface GangsterServices extends CRUDServices<Gangster> {

    Integer getRep(Integer id);
}
