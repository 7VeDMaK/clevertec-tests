package org.example.mapper;

import lombok.extern.apachecommons.CommonsLog;
import org.example.domain.Character;
import org.example.entity.CharacterEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    List<Character> toDomains(List<CharacterEntity> characters);

    Character toDomain(CharacterEntity characterEntity);

    CharacterEntity toEntity(Character character);
}
