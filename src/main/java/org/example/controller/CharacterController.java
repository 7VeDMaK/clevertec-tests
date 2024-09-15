package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Character;
import org.example.service.CharacterService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("/api/v1/cakes")
    public ResponseEntity<List<Character>> findAll() {
        List<Character> characters = characterService.getCharacters();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(characters);
    }
}
