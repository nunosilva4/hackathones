package org.academiadecodigo.onegitwonders.rest;

import org.academiadecodigo.onegitwonders.dto.Assembler;
import org.academiadecodigo.onegitwonders.dto.GangsterDto;
import org.academiadecodigo.onegitwonders.exceptions.CrewNotFoundException;
import org.academiadecodigo.onegitwonders.exceptions.GangsterGramException;
import org.academiadecodigo.onegitwonders.exceptions.GangsterNotFoundException;
import org.academiadecodigo.onegitwonders.exceptions.NotEnoughRepException;
import org.academiadecodigo.onegitwonders.model.Crew;
import org.academiadecodigo.onegitwonders.model.Gangster;
import org.academiadecodigo.onegitwonders.service.CrewService;
import org.academiadecodigo.onegitwonders.service.GangsterService;
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
@RequestMapping("/api/gangster")
public class GangsterController {

    private Assembler assembler;
    private GangsterService gangsterService;
    private CrewService crewService;

    @Autowired
    public GangsterController(Assembler assembler, GangsterService gangsterService, CrewService crewService) {
        this.assembler = assembler;
        this.gangsterService = gangsterService;
        this.crewService = crewService;
    }

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<GangsterDto>> listGangsters() {

        return new ResponseEntity<>(gangsterService.list()
                .stream()
                .map(assembler::toGangsterDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getGangster(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(assembler.toGangsterDto(gangsterService.get(id)), HttpStatus.OK);

        } catch (GangsterNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}/selectcrew/{selectedId}")
    public ResponseEntity<?> selectCrew(@PathVariable Integer id, @PathVariable Integer selectedId) {

        try {
            Gangster gangster = gangsterService.get(id);
            Crew crew = crewService.get(selectedId);
            gangster.setCrew(crew);
            gangsterService.save(gangster);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (GangsterNotFoundException | CrewNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/receiverep")
    public ResponseEntity<?> receiveRep(@PathVariable Integer id, @RequestBody Integer amount) {

        if (amount <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        gangsterService.receiveRep(id, amount);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}/spendrep")
    public ResponseEntity<?> spendRep(@PathVariable Integer id, @RequestBody Integer amount) {

        try {
            gangsterService.spendRep(id, amount);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotEnoughRepException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @Valid @RequestBody GangsterDto gangsterDto, BindingResult validation) {

        if (validation.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            gangsterService.save(assembler.fromExistingGangsterDto(gangsterDto, id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (GangsterNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<?> createGangster(@Valid @RequestBody GangsterDto gangsterDto, BindingResult validation, UriComponentsBuilder componentsBuilder) {

        if (validation.hasErrors()) {
            return new ResponseEntity<>(validation.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        try {
            Gangster toSave = assembler.fromNewGangsterDto(gangsterDto);
            toSave = gangsterService.save(toSave);

            UriComponents component = componentsBuilder
                    .path("/api/gangster/" + toSave.getId())
                    .build();

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(component.toUri());

            return new ResponseEntity<>(toSave, headers, HttpStatus.CREATED);

        } catch (GangsterGramException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGangster(@PathVariable Integer id) {

        try {
            gangsterService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (GangsterNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}