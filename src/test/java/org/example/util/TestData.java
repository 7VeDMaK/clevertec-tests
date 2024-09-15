package org.example.util;

import org.example.common.CharacterType;
import org.example.domain.Character;
import org.example.entity.CharacterEntity;

import java.util.List;
import java.util.UUID;

public class TestData {

    public static CharacterEntity generateCharacterEntity() {
        return new CharacterEntity(UUID.randomUUID(), "1221", 2, CharacterType.SHIELDER);
    }

    public static Character generateCharacter() {
        return new Character(UUID.randomUUID(), "1221", 2, CharacterType.SHIELDER);
    }

    public static List<Character> generateCharacters() {
        return List.of(
                new Character(UUID.randomUUID(), "Gigachad", 18, CharacterType.SHIELDER),
                new Character(UUID.randomUUID(), "Gigakid", 79, CharacterType.ARCHER),
                new Character(UUID.randomUUID(), "Gigalaptop", 132, CharacterType.ALTER_EGO),
                new Character(UUID.randomUUID(), "Sigmamale", 44, CharacterType.ASSASSIN),
                new Character(UUID.randomUUID(), "Radiatedkid", 19, CharacterType.BEAST)
        );
    }
}
