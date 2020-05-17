package fr.cookiedev.codegrid.repository;

import java.util.Optional;

import fr.cookiedev.codegrid.domain.Game;

public interface GameRepository {

	Optional<Game> findByName(String id);

}
