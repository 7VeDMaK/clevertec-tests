package org.example.mapper;

import org.example.domain.Character;
import org.example.entity.CharacterEntity;
import org.example.repository.CharacterRepository;
import org.example.service.CharacterService;
import org.example.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CharacterMapperTest {

    private CharacterMapper characterMapper;

    @BeforeEach
    void setup() {
        characterMapper = mock(CharacterMapper.class);
    }

    @ParameterizedTest
    @MethodSource("org.example.util.ProvideValues#provideValuesForMapperTest")
    void shouldMapToDomains(List<CharacterEntity> characterEntities) {
        // Given
        List<Character> characters = TestData.generateCharacters();
        // When
        when(characterMapper.toDomains(characterEntities)).
                thenReturn(characters);
        // Then
        assertEquals(characters, characterMapper.toDomains(characterEntities));
    }

    @Test
    void toDomain() {
        // Given
        Character character = TestData.generateCharacter();
        // When
        when(characterMapper.toDomain(new CharacterEntity())).
                thenReturn(character);
        // Then
        assertEquals(character, characterMapper.toDomain(new CharacterEntity()));
    }

    @Test
    void toEntity() {
        // Given
        CharacterEntity characterEntity = TestData.generateCharacterEntity();
        // When
        when(characterMapper.toEntity(new Character())).
                thenReturn(characterEntity);
        // Then
        assertEquals(characterEntity, characterMapper.toEntity(new Character()));
    }
}