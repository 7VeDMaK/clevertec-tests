package org.example.util;

import org.example.domain.Character;
import org.junit.jupiter.params.provider.Arguments;

import java.util.UUID;
import java.util.stream.Stream;

public class provideValues {
    private static Stream<Arguments> provideValuesForUpdateTest() {
        return Stream.of(
                Arguments.of(UUID.randomUUID(), null),
                Arguments.of(null, new Character()),
                Arguments.of(null, null));
    }
}
