package org.academiadecodigo.onegitwonders.service;

import org.academiadecodigo.onegitwonders.model.Avatar;
import org.academiadecodigo.onegitwonders.model.Crew;
import org.academiadecodigo.onegitwonders.model.Gangster;

import java.util.List;

public interface CrewService extends CRUDServices<Crew> {

    List<Gangster> listMembers(Integer id);

    List<Avatar> getAvatars(Integer id);
}
