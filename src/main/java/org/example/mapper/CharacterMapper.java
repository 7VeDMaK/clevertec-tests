package org.example.mapper;

import org.example.domain.Character;
import org.example.entity.CharacterEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    List<Character> toDomains(List<CharacterEntity> characters);

    Character toDomain(CharacterEntity characterEntity);

    CharacterEntity toEntity(Character character);
}
