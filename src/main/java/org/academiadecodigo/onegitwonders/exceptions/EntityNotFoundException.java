package org.academiadecodigo.onegitwonders.exceptions;

import org.academiadecodigo.onegitwonders.model.Avatar;
import org.academiadecodigo.onegitwonders.model.Crew;
import org.academiadecodigo.onegitwonders.model.Gangster;
import org.academiadecodigo.onegitwonders.model.Mission;

import java.util.HashMap;
import java.util.Map;

public abstract class EntityNotFoundException extends GangsterGramException {

    public static GangsterGramException create(Class<?> type) {
        Map<Class<?>, EntityNotFoundException> entities = new HashMap<>();
        entities.put(Gangster.class, new GangsterNotFoundException());
        entities.put(Crew.class, new CrewNotFoundException());
        entities.put(Mission.class, new MissionNotFoundException());
        entities.put(Avatar.class, new AvatarNotFoundException());

        return entities.get(type);
    }
}
