package org.example.service;

import org.example.domain.Character;
import org.example.entity.CharacterEntity;
import org.example.exception.CharacterNotFoundException;
import org.example.mapper.CharacterMapper;
import org.example.repository.CharacterRepository;
import org.example.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CharacterServiceTest {

    private CharacterRepository characterRepository;
    private CharacterMapper characterMapper;
    private CharacterService characterService;

    @BeforeEach
    void setup() {
        characterRepository = mock(CharacterRepository.class);
        characterMapper = mock(CharacterMapper.class);
        characterService = new CharacterService(characterRepository, characterMapper);
    }

    @Test
    void shouldGetCharacters() {

        List<CharacterEntity> characterEntities = List.of(TestData.generateCharacterEntity());

        List<Character> characters = List.of(new Character());

        when(characterRepository.getCharacters())
                .thenReturn(characterEntities);
        when(characterMapper.toDomains(characterEntities))
                .thenReturn(characters);

        List<Character> actualCharacters = characterService.getCharacters();

        assertEquals(actualCharacters, characters);
    }

    @Test
    void shouldGetCharacterById() {
        UUID characterId = UUID.randomUUID();

        CharacterEntity characterEntity = TestData.generateCharacterEntity();
        Character character = new Character();
        character.setId(UUID.randomUUID());

        when(characterRepository.getCharacter(characterId))
                .thenReturn(Optional.of(characterEntity));
        when(characterMapper.toDomain(characterEntity))
                .thenReturn(character);

        Character actualCharacter = characterService.getCharacter(characterId);

        assertEquals(actualCharacter.getId(), character.getId());
    }

    @Test
    void shouldThrowExceptionAfterGetCharacterById() {
        UUID characterId = UUID.randomUUID();

        Character character = new Character();
        character.setId(UUID.randomUUID());

        when(characterRepository.getCharacter(characterId))
                .thenReturn(Optional.empty());

        assertThrows(
                CharacterNotFoundException.class,
                () -> characterService.getCharacter(characterId)
        );
    }

    @Test
    void shouldCreateCharacter() {
        CharacterEntity characterEntity = TestData.generateCharacterEntity();
        Character character = new Character();

        when(characterRepository.createCharacter(characterEntity))
                .thenReturn(characterEntity);
        when(characterMapper.toEntity(character))
                .thenReturn(characterEntity);

        characterService.createCharacter(character);

        verify(characterRepository).createCharacter(characterEntity);
    }

    @Test
    void shouldGetCharacterAfterCreateCharacter() {
        CharacterEntity characterEntity = new CharacterEntity();
        Character character = new Character();

        when(characterRepository.createCharacter(characterEntity))
                .thenReturn(characterEntity);
        when(characterMapper.toEntity(character))
                .thenReturn(characterEntity);
        when(characterMapper.toDomain(characterEntity))
                .thenReturn(character);

        characterService.createCharacter(character);

        assertEquals(character, characterService.createCharacter(character));
    }

    @Test
    void shouldThrowNotFoundExceptionBeforeCreateCharacter() {
        assertThrows(
                CharacterNotFoundException.class,
                () -> characterService.createCharacter(null)
        );
    }

    @Test
    void updateCharacter() {
    }

    @Test
    void deleteCharacter() {
        //without body
    }
}