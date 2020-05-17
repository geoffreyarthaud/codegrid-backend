package fr.cookiedev.codegrid.service;

import fr.cookiedev.codegrid.api.GameApi;
import fr.cookiedev.codegrid.repository.GameRepository;
import fr.cookiedev.codegrid.vo.GameInfo;

public class GameService implements GameApi {

    private final GameRepository gameRepository;

	public GameService(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

	@Override
	public GameInfo joinGame(final String name) {
		return GameInfo.fromGame(gameRepository.findByName(name).get());
	}
    
}