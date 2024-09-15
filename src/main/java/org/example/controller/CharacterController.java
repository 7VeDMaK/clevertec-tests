package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Character;
import org.example.service.CharacterService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("/api/v1/find")
    public ResponseEntity<List<Character>> findAll() {
        List<Character> characters = characterService.getCharacters();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(characters);
    }

    @GetMapping("/api/v1/create")
    public ResponseEntity<Character> create() {
        Character createdCharacter = new Character();
        Character character = characterService.createCharacter(createdCharacter);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(character);
    }

    @GetMapping("/api/v1/update")
    public ResponseEntity<Character> update() {
        Character character = new Character();
        UUID characterId = UUID.randomUUID();
        Character updatedCharacter = characterService.updateCharacter(characterId, character);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(updatedCharacter);
    }

    @GetMapping("/api/v1/delete")
    public ResponseEntity<Object> delete() {
        UUID characterId = UUID.randomUUID();
        characterService.deleteCharacter(characterId);
        return ResponseEntity.ok().body(null);
    }
}
