package fr.cookiedev.codegrid.domain;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Game {
    private String id;
    private String name;

    public static Game create(String name) {
        return builder().id(UUID.randomUUID().toString()).name(name).build();
    }
}
