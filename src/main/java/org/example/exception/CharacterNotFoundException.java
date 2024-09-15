package org.example.exception;

import java.util.UUID;

public class CharacterNotFoundException extends RuntimeException {

    private CharacterNotFoundException(String message) {
        super(message);
    }

    public static CharacterNotFoundException byCharacterId(UUID id) {
        return new CharacterNotFoundException(
                String.format("Character not found by id %s", id)
        );
    }
}
