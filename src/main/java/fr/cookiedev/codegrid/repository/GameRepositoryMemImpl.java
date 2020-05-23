package fr.cookiedev.codegrid.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;

import fr.cookiedev.codegrid.domain.Game;
import fr.cookiedev.codegrid.vo.TeamCamp;

@ApplicationScoped
public class GameRepositoryMemImpl implements GameRepository {

	private final Map<String, Game> gamesFromName;

	private final Map<String, Game> gamesFromId;

	private final Map<String, Game> gamesFromTeamId;

    public GameRepositoryMemImpl() {
		gamesFromName = new ConcurrentHashMap<>();
		gamesFromId = new ConcurrentHashMap<>();
		gamesFromTeamId = new ConcurrentHashMap<>();
    }

	@Override
	public Optional<Game> findByName(String name) {
		return Optional.ofNullable(gamesFromName.get(name));
	}

	@Override
	public Optional<Game> findByTeamId(String teamId) {
		return Optional.ofNullable(gamesFromTeamId.get(teamId));
	}

	@Override
	public Optional<Game> findById(String id) {
		return Optional.ofNullable(gamesFromId.get(id));
	}

	@Override
	public synchronized void save(Game game) {
		gamesFromTeamId.put(game.getTeamId(TeamCamp.A), game);
		gamesFromTeamId.put(game.getTeamId(TeamCamp.B), game);
		gamesFromName.put(game.getName(), game);
		gamesFromId.put(game.getId(), game);
	}
    
}