package org.academiadecodigo.onegitwonders.rest;

import org.academiadecodigo.onegitwonders.dto.Assembler;
import org.academiadecodigo.onegitwonders.dto.GangsterDto;
import org.academiadecodigo.onegitwonders.exceptions.GangsterNotFoundException;
import org.academiadecodigo.onegitwonders.service.GangsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/gangster")
public class GangsterController {

    private Assembler assembler;
    private GangsterService gangsterService;

    @Autowired
    public GangsterController(Assembler assembler, GangsterService gangsterService) {
        this.assembler = assembler;
        this.gangsterService = gangsterService;
    }

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<GangsterDto>> listGangsters() {

        return new ResponseEntity<>(gangsterService.list()
                .stream()
                .map(assembler::toGangsterDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(assembler.toGangsterDto(gangsterService.get(id)), HttpStatus.OK);

        } catch (GangsterNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
