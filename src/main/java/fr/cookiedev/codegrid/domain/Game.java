package fr.cookiedev.codegrid.domain;

import java.util.UUID;

import fr.cookiedev.codegrid.vo.GameStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Game {
    private String id;

    private String name;
    
    @Builder.Default
    private GameStatus status = GameStatus.SETUP;

    public static Game create(String name) {
        return builder().id(UUID.randomUUID().toString()).name(name).status(GameStatus.SETUP).build();
    }
}
