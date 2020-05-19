package fr.cookiedev.codegrid.service;

import javax.enterprise.context.ApplicationScoped;

import fr.cookiedev.codegrid.api.GameApi;
import fr.cookiedev.codegrid.domain.Game;
import fr.cookiedev.codegrid.repository.GameRepository;
import fr.cookiedev.codegrid.vo.GameInfo;
import fr.cookiedev.codegrid.vo.GameStatus;
import fr.cookiedev.codegrid.vo.TeamCamp;
import fr.cookiedev.codegrid.vo.TeamInfo;

@ApplicationScoped
public class GameService implements GameApi {

    private final GameRepository gameRepository;

	public GameService(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

	@Override
	public GameInfo joinGame(final String name) {
		GameInfo gameInfo = GameInfo.fromGame(gameRepository.findByName(name).orElse(Game.create(name)));
		if (gameInfo.getStatus() != GameStatus.SETUP) {
			throw new IllegalStateException("This game has already started and cannot be joined");
		}
		return gameInfo;
	}

	@Override
	public TeamInfo joinTeam(String gameId, TeamCamp camp) {
		Game game = gameRepository.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Incorrect game id"));
		if (game.getStatus() != GameStatus.SETUP) {
			throw new IllegalStateException("This game has already started and cannot be joined");
		}
		return TeamInfo.fromGame(game, camp);
	}
    
}