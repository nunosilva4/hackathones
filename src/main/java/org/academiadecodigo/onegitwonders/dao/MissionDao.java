package org.academiadecodigo.onegitwonders.dao;

import org.academiadecodigo.onegitwonders.model.Mission;

import java.util.List;

public interface MissionDao {

    Mission findById(Integer id);

    List<Mission> findAll();

    Mission save(Mission mission);

    void delete(Integer id);

}
