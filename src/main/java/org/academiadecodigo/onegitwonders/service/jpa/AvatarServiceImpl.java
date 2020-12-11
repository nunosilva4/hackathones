package org.academiadecodigo.onegitwonders.service.jpa;

import org.academiadecodigo.onegitwonders.dao.Dao;
import org.academiadecodigo.onegitwonders.model.Avatar;
import org.academiadecodigo.onegitwonders.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarServiceImpl extends AbstractJpaService<Avatar> implements AvatarService {

    @Autowired
    public AvatarServiceImpl(Dao<Avatar> dao) {
        super(dao, Avatar.class);
    }
}
