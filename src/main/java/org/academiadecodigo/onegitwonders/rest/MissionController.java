package org.academiadecodigo.onegitwonders.rest;

import org.academiadecodigo.onegitwonders.dto.Assembler;
import org.academiadecodigo.onegitwonders.dto.MissionDto;
import org.academiadecodigo.onegitwonders.exceptions.GangsterGramException;
import org.academiadecodigo.onegitwonders.exceptions.GangsterNotFoundException;
import org.academiadecodigo.onegitwonders.model.Mission;
import org.academiadecodigo.onegitwonders.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mission")
public class MissionController {

    private Assembler assembler;
    private MissionService missionService;

    @Autowired
    public MissionController(Assembler assembler, MissionService missionService) {
        this.assembler = assembler;
        this.missionService = missionService;
    }

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<MissionDto>> listGangsters() {

        return new ResponseEntity<>(missionService.list()
                .stream()
                .map(assembler::toMissionDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getMission(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(assembler.toMissionDto(missionService.get(id)), HttpStatus.OK);

        } catch (GangsterNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @Valid @RequestBody MissionDto missionDto, BindingResult validation) {

        if (validation.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            missionService.save(assembler.fromMissionDto(missionDto, id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (GangsterNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<?> createMission(@Valid @RequestBody MissionDto missionDto, BindingResult validation, UriComponentsBuilder componentsBuilder) {

        if (validation.hasErrors()) {
            return new ResponseEntity<>(validation.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        try {
            Mission toSave = assembler.fromNewMissionDto(missionDto);
            missionService.save(toSave);

            UriComponents component = componentsBuilder
                    .path("/api/mission/" + toSave.getId())
                    .build();

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(component.toUri());

            return new ResponseEntity<>(headers, HttpStatus.CREATED);

        } catch (GangsterGramException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMission(@PathVariable Integer id) {

        try {
            missionService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (GangsterNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
