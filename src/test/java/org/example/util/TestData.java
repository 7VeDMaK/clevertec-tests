package org.example.util;

import org.example.common.CharacterType;
import org.example.entity.CharacterEntity;

import java.util.UUID;

public class TestData {

    public static CharacterEntity generateCharacterEntity() {
        return new CharacterEntity(UUID.randomUUID(), "1221",2, CharacterType.SHIELDER);
    }
}
