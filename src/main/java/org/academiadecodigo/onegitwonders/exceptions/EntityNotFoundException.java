package org.academiadecodigo.onegitwonders.exceptions;

import org.academiadecodigo.onegitwonders.model.Crew;
import org.academiadecodigo.onegitwonders.model.Gangster;

import java.util.HashMap;
import java.util.Map;

public abstract class EntityNotFoundException extends GangsterGramException {

    public static GangsterGramException create(Class<?> type) {
        Map<Class<?>, EntityNotFoundException> entities = new HashMap<>();
        entities.put(Gangster.class, new GangsterNotFoundException());
        entities.put(Crew.class, new CrewNotFoundException());

        return entities.get(type);
    }
}
