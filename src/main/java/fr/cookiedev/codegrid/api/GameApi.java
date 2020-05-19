package fr.cookiedev.codegrid.api;

import fr.cookiedev.codegrid.vo.GameInfo;
import fr.cookiedev.codegrid.vo.TeamCamp;
import fr.cookiedev.codegrid.vo.TeamInfo;

public interface GameApi {

	GameInfo joinGame(String id);

	TeamInfo joinTeam(String gameId, TeamCamp a);
    
}