package org.academiadecodigo.onegitwonders.rest;

import org.academiadecodigo.onegitwonders.dto.Assembler;
import org.academiadecodigo.onegitwonders.dto.CrewDto;
import org.academiadecodigo.onegitwonders.exceptions.CrewNotFoundException;
import org.academiadecodigo.onegitwonders.exceptions.GangsterNotFoundException;
import org.academiadecodigo.onegitwonders.exceptions.MalformedGangsterException;
import org.academiadecodigo.onegitwonders.model.Crew;
import org.academiadecodigo.onegitwonders.service.CrewService;
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
@RequestMapping("/api/crew")
public class CrewController {

    private Assembler assembler;
    private CrewService crewService;

    @Autowired
    public CrewController(Assembler assembler, CrewService crewService) {
        this.assembler = assembler;
        this.crewService = crewService;
    }

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<CrewDto>> listCrews() {

        return new ResponseEntity<>(crewService.list()
                .stream()
                .map(assembler::toCrewDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCrew(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(assembler.toCrewDto(crewService.get(id)), HttpStatus.OK);

        } catch (CrewNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @Valid @RequestBody CrewDto crewDto, BindingResult validation) {

        if (validation.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            crewService.save(assembler.fromCrewDto(crewDto, id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (GangsterNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<?> createCrew(@Valid @RequestBody CrewDto crewDto, BindingResult validation, UriComponentsBuilder componentsBuilder) {

        if (validation.hasErrors()) {
            return new ResponseEntity<>(validation.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        try {
            Crew toSave = assembler.fromNewCrewDto(crewDto);
            crewService.save(toSave);

            UriComponents component = componentsBuilder
                    .path("/api/crew/" + toSave.getId())
                    .build();

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(component.toUri());

            return new ResponseEntity<>(headers, HttpStatus.CREATED);

        } catch (MalformedGangsterException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCrew(@PathVariable Integer id) {

        try {
            crewService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (GangsterNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
