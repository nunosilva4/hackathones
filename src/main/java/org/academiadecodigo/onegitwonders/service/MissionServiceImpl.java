package org.academiadecodigo.onegitwonders.service;

import org.academiadecodigo.onegitwonders.dao.MissionDaoImpl;
import org.academiadecodigo.onegitwonders.model.Gangster;
import org.academiadecodigo.onegitwonders.model.Mission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MissionServiceImpl implements MissionService {

    private MissionDaoImpl missionDao;

    @Autowired
    public void setMissionDao(MissionDaoImpl missionDao) {
        this.missionDao = missionDao;
    }

    @Override
    public Mission findByName(Integer id) throws Exception {

        if (Objects.isNull(missionDao.findById(id))) {
            throw new Exception();
        }

        return missionDao.findById(id);
    }

    @Override
    public List<Mission> sortedList() {
        List<Mission> missions = missionDao.findAll();

        return missions.stream().sorted(Comparator.comparing(Mission::getSuccessRate))
                .collect(Collectors.toList());
    }

    @Override
    public Mission create(Mission mission) throws Exception {

        if (Objects.isNull(missionDao.findById(mission.getId()))){
            return missionDao.save(mission);
        }

        throw new Exception();
    }

    @Override
    public Mission edit(Mission mission) throws Exception {
        if (Objects.isNull(missionDao.findById(mission.getId()))){
            throw  new Exception();
        }

        return missionDao.save(mission);
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (Objects.isNull(missionDao.findById(id))) {
            throw new Exception();
        }

        missionDao.delete(id);
    }
}
