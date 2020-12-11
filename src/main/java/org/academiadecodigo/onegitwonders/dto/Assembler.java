package org.academiadecodigo.onegitwonders.dto;

import org.academiadecodigo.onegitwonders.model.Crew;
import org.academiadecodigo.onegitwonders.model.Gangster;
import org.academiadecodigo.onegitwonders.model.Mission;
import org.academiadecodigo.onegitwonders.service.CrewService;
import org.academiadecodigo.onegitwonders.service.GangsterService;
import org.academiadecodigo.onegitwonders.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Assembler {

    private GangsterService gangsterService;
    private CrewService crewService;
    private MissionService missionService;

    @Autowired
    public Assembler(GangsterService gangsterService, CrewService crewService, MissionService missionService) {
        this.gangsterService = gangsterService;
        this.crewService = crewService;
        this.missionService = missionService;
    }

    public Gangster fromNewGangsterDto(GangsterDto gangsterDto) {

        Gangster gangster = new Gangster();

        gangster.setStreetName(gangsterDto.getStreetName());
        gangster.setRealName(gangsterDto.getRealName());
        gangster.setAvatar(gangsterDto.getAvatar());
        gangster.setEmail(gangsterDto.getEmail());
        gangster.setPassword(gangsterDto.getPassword());
        gangster.setStreetRep(0);

        return gangster;
    }

    public Gangster fromExistingGangsterDto(GangsterDto gangsterDto, Integer id) {

        Gangster gangster = gangsterService.get(id);

        gangster.setStreetName(gangsterDto.getStreetName());
        gangster.setRealName(gangsterDto.getRealName());
        gangster.setAvatar(gangsterDto.getAvatar());
        gangster.setEmail(gangsterDto.getEmail());
        gangster.setPassword(gangsterDto.getPassword());
        gangster.setStreetRep(gangsterDto.getStreetRep());

        return gangster;
    }

    public Crew fromNewCrewDto(CrewDto crewDto) {

        Crew crew = new Crew();

        crew.setName(crewDto.getName());
        crew.setCrewRep(0);
        crew.setLogo(crewDto.getLogo());
        crew.setTag(crewDto.getTag());

        return crew;
    }

    public Crew fromCrewDto(CrewDto crewDto, Integer id) {

        Crew crew = crewService.get(id);

        crew.setName(crewDto.getName());
        crew.setCrewRep(crewDto.getCrewRep());
        crew.setLogo(crewDto.getLogo());
        crew.setTag(crewDto.getTag());

        return crew;
    }

    public Mission fromNewMissionDto(MissionDto missionDto) {

        Mission mission = new Mission();

        mission.setDescription(missionDto.getDescription());
        mission.setRepCost(missionDto.getRepCost());
        mission.setRepReward(missionDto.getRepReward());
        mission.setSuccessRate(missionDto.getSuccessRate());
        mission.setTitle(missionDto.getTitle());

        return mission;
    }

    public Mission fromMissionDto(MissionDto missionDto, Integer id) {

        Mission mission = missionService.get(id);

        mission.setDescription(missionDto.getDescription());
        mission.setRepCost(missionDto.getRepCost());
        mission.setRepReward(missionDto.getRepReward());
        mission.setSuccessRate(missionDto.getSuccessRate());
        mission.setTitle(missionDto.getTitle());

        return mission;
    }

    public GangsterDto toGangsterDto(Gangster gangster) {

        GangsterDto gangsterDto = new GangsterDto();

        gangsterDto.setId(gangster.getId());
        gangsterDto.setEmail(gangster.getEmail());
        gangsterDto.setAvatar(gangster.getAvatar());
        gangsterDto.setPassword(gangster.getPassword());
        gangsterDto.setRealName(gangster.getRealName());
        gangsterDto.setStreetName(gangster.getStreetName());
        gangsterDto.setStreetRep(gangster.getStreetRep());

        return gangsterDto;
    }

    public CrewDto toCrewDto(Crew crew) {

        CrewDto crewDto = new CrewDto();

        crewDto.setId(crew.getId());
        crewDto.setCrewRep(crew.getCrewRep());
        crewDto.setLogo(crew.getLogo());
        crewDto.setName(crew.getName());
        crewDto.setTag(crew.getTag());

        return crewDto;
    }

    public MissionDto toMissionDto(Mission mission) {

        MissionDto missionDto = new MissionDto();

        missionDto.setTitle(mission.getTitle());
        missionDto.setDescription(mission.getDescription());
        missionDto.setId(mission.getId());
        missionDto.setRepCost(mission.getRepCost());
        missionDto.setSuccessRate(mission.getSuccessRate());
        missionDto.setRepReward(mission.getRepReward());

        return missionDto;
    }
}
