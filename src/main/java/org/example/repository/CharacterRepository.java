package org.example.repository;

import org.example.common.CharacterType;
import org.example.entity.CharacterEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CharacterRepository {

    private static final List<CharacterEntity> db = List.of(
            new CharacterEntity(UUID.randomUUID(), "Gigachad", 18, CharacterType.SHIELDER),
            new CharacterEntity(UUID.randomUUID(), "Gigakid", 79, CharacterType.ARCHER),
            new CharacterEntity(UUID.randomUUID(), "Gigalaptop", 132, CharacterType.ALTER_EGO),
            new CharacterEntity(UUID.randomUUID(), "Sigmamale", 44, CharacterType.ASSASSIN),
            new CharacterEntity(UUID.randomUUID(), "Radiatedkid", 19, CharacterType.BEAST)
    );

    public List<CharacterEntity> getCharacters() {
        return db;
    }

    public Optional<CharacterEntity> getCharacter(UUID id) {
        return Optional.ofNullable(db.getFirst());
    }

    public CharacterEntity createCharacter(CharacterEntity character) {
        return character;
    }

    public CharacterEntity updateCharacter(UUID id, CharacterEntity character) {
        character.setId(id);
        return character;
    }

    public void deleteCharacter(UUID id) {
    }
}
