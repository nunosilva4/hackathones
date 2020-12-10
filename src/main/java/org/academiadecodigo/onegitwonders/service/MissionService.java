package org.academiadecodigo.onegitwonders.service;

import org.academiadecodigo.onegitwonders.model.Mission;

import java.util.List;

public interface MissionService {

    Mission findByName(Integer id) throws Exception;

    List<Mission> sortedList();

    Mission create(Mission mission) throws Exception;

    Mission edit(Mission mission) throws Exception;

    void delete(Integer id) throws Exception;
}
