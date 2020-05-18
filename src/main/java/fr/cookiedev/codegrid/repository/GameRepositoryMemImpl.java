package fr.cookiedev.codegrid.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;

import fr.cookiedev.codegrid.domain.Game;

@ApplicationScoped
public class GameRepositoryMemImpl implements GameRepository {

    private Map<String, Game> gamesFromName;

    public GameRepositoryMemImpl() {
        gamesFromName = new ConcurrentHashMap<>();
    }

	@Override
	public Optional<Game> findByName(String name) {
		return Optional.ofNullable(gamesFromName.get(name));
	}
    
}