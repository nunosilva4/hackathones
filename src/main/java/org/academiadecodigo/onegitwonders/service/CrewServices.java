package org.academiadecodigo.onegitwonders.service;

import org.academiadecodigo.onegitwonders.model.Crew;
import org.academiadecodigo.onegitwonders.model.Gangster;

import java.util.List;

public interface CrewServices extends CRUDServices<Crew> {

    List<Gangster> findMembers(String name) throws Exception;

}
