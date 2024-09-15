package org.example.util;

import org.example.domain.Character;
import org.example.entity.CharacterEntity;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class ProvideValues {
    private static Stream<Arguments> provideValuesForUpdateTest() {
        return Stream.of(
                Arguments.of(UUID.randomUUID(), null),
                Arguments.of(null, new Character()),
                Arguments.of(null, null));
    }

    private static Stream<Arguments> provideValuesForMapperTest() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(List.of(new CharacterEntity())),
                Arguments.of(List.of(new CharacterEntity(), new CharacterEntity()))
        );
    }
}
