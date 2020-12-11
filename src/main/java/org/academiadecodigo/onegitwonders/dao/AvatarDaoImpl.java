package org.academiadecodigo.onegitwonders.dao;

import org.academiadecodigo.onegitwonders.model.Avatar;
import org.springframework.stereotype.Repository;

@Repository
public class AvatarDaoImpl extends GenericDaoImpl<Avatar> {

    public AvatarDaoImpl() {
        super(Avatar.class);
    }
}
