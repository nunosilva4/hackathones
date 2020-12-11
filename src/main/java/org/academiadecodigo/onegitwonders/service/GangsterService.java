package org.academiadecodigo.onegitwonders.service;

import org.academiadecodigo.onegitwonders.model.Gangster;

public interface GangsterService extends CRUDServices<Gangster> {

    Integer getRep(Integer id);

    Integer spendRep(Integer id, Integer amount);

    void receiveRep(Integer id, Integer amount);
}
