package org.academiadecodigo.onegitwonders.rest;

import org.academiadecodigo.onegitwonders.dto.Assembler;
import org.academiadecodigo.onegitwonders.dto.AvatarDto;
import org.academiadecodigo.onegitwonders.exceptions.CrewNotFoundException;
import org.academiadecodigo.onegitwonders.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/avatar")
public class AvatarController {

    private Assembler assembler;
    private AvatarService avatarService;

    @Autowired
    public AvatarController(Assembler assembler, AvatarService avatarService) {
        this.assembler = assembler;
        this.avatarService = avatarService;
    }

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<AvatarDto>> listAvatars() {

        return new ResponseEntity<>(avatarService.list()
                .stream()
                .map(assembler::toAvatarDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAvatar(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(assembler.toAvatarDto(avatarService.get(id)), HttpStatus.OK);

        } catch (CrewNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
