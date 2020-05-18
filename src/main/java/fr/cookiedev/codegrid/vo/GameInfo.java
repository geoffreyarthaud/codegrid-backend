package fr.cookiedev.codegrid.vo;

import fr.cookiedev.codegrid.domain.Game;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameInfo {
    final private String id;
    final private String name;
    final private GameStatus status;

    public static GameInfo fromGame(Game game) {
        return builder()
            .id(game.getId())
            .name(game.getName())
            .status(game.getStatus()).build();
    }
}