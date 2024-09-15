package org.example.service;

import lombok.AllArgsConstructor;
import org.example.domain.Character;
import org.example.entity.CharacterEntity;
import org.example.exception.CharacterNotFoundException;
import org.example.mapper.CharacterMapper;
import org.example.mapper.CharacterMapperImpl;
import org.example.repository.CharacterRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    private final CharacterMapper characterMapper;

    public List<Character> getCharacters() {
        List<CharacterEntity> characters = characterRepository.getCharacters();

        return characterMapper.toDomains(characters);
    }

    public Character getCharacter(UUID id) {
        CharacterEntity character = characterRepository.getCharacter(id)
                .orElseThrow(() -> CharacterNotFoundException.byCharacterId(id));

        return characterMapper.toDomain(character);
    }

    public Character createCharacter(Character character) {
        if (character == null) throw CharacterNotFoundException.byCharacterId(UUID.randomUUID());
        CharacterEntity characterEntity = characterMapper.toEntity(character);
        CharacterEntity createdEntity = characterRepository.createCharacter(characterEntity);

        return characterMapper.toDomain(createdEntity);
    }

    public Character updateCharacter(UUID id, Character character) {
        CharacterEntity characterEntity = characterMapper.toEntity(character);
        CharacterEntity updatedEntity = characterRepository.updateCharacter(id, characterEntity);

        return characterMapper.toDomain(updatedEntity);
    }

    public void deleteCharacter(UUID id) {
        characterRepository.deleteCharacter(id);
    }
}
