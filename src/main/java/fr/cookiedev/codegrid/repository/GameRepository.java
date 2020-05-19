package fr.cookiedev.codegrid.repository;

import java.util.Optional;

import fr.cookiedev.codegrid.domain.Game;

public interface GameRepository {

	Optional<Game> findByName(String id);

	Optional<Game> findByTeamId(String teamId);

	Optional<Game> findById(String gameId);

	void save(Game game);

}
