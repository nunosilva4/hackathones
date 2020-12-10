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
        gangster.setCrew(gangsterDto.getCrew());
        gangster.setAvatar(gangsterDto.getAvatar());
        gangster.setEmail(gangsterDto.getEmail());
        gangster.setPassword(gangsterDto.getPassword());
        gangster.setBusted(false);
        gangster.setStreetRep(0);

        return gangster;
    }

    public Gangster fromExistingGangsterDto(GangsterDto gangsterDto) {

        Gangster gangster = gangsterService.get(gangsterDto.getId());

        gangster.setStreetName(gangsterDto.getStreetName());
        gangster.setRealName(gangsterDto.getRealName());
        gangster.setCrew(gangsterDto.getCrew());
        gangster.setAvatar(gangsterDto.getAvatar());
        gangster.setEmail(gangsterDto.getEmail());
        gangster.setPassword(gangsterDto.getPassword());
        gangster.setBusted(gangsterDto.getBusted());
        gangster.setStreetRep(gangsterDto.getStreetRep());

        return gangster;
    }

    public Crew fromCrewDto(CrewDto crewDto) {
        return null;
    }

    public Mission fromMissionDto(MissionDto missionDto) {
        return null;
    }

    public GangsterDto toGangsterDto(Gangster gangster) {

        GangsterDto gangsterDto = new GangsterDto();
        gangsterDto.setId(gangster.getId());
        gangsterDto.setCrew(gangster.getCrew());
        gangsterDto.setBusted(gangster.getBusted());
        gangsterDto.setEmail(gangster.getEmail());
        gangsterDto.setAvatar(gangster.getAvatar());
        gangsterDto.setPassword(gangster.getPassword());
        gangsterDto.setRealName(gangster.getRealName());
        gangsterDto.setStreetName(gangster.getStreetName());
        gangsterDto.setStreetRep(gangster.getStreetRep());

        return gangsterDto;
    }

    public CrewDto toCrewDto(Crew crew) {
        return null;
    }

    public MissionDto toMissionDto(Mission mission) {
        return null;
    }
}
