package fr.cookiedev.codegrid.vo;

import fr.cookiedev.codegrid.domain.Game;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamInfo {
    private String id;
    private TeamCamp camp;
    private GameInfo gameInfo;
	public static TeamInfo fromGame(Game game, TeamCamp camp) {
		return TeamInfo.builder().id(game.getTeamId(camp)).camp(camp).gameInfo(GameInfo.fromGame(game)).build();
	}

}
