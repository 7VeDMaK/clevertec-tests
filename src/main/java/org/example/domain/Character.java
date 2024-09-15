package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.common.CharacterType;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    private UUID id;

    private String name;

    private int age;

    private CharacterType type;
}
