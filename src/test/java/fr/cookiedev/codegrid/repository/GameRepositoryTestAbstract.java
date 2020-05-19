package fr.cookiedev.codegrid.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.cookiedev.codegrid.domain.Game;
import fr.cookiedev.codegrid.vo.TeamCamp;

public abstract class GameRepositoryTestAbstract {
    private final Supplier<GameRepository> gameRepoSupplier;

    private GameRepository gameRepo;

	public GameRepositoryTestAbstract(Supplier<GameRepository> gameRepoSupplier) {
        this.gameRepoSupplier = gameRepoSupplier;
    }
 
    @BeforeEach
    public void initComponents() {
        gameRepo = gameRepoSupplier.get();
    }

    @Test
    public void givenNewGame_whenFindByName_thenGetThisGame() {
        // GIVEN
        String id = "26b67290-2c14-401d-8c46-652d00f8c1a6";
        String name = "d80d1185-500d-4ffe-95fd-cfb9cdc11639";
        Game game = Game.builder().id(id).name(name).build();
        gameRepo.save(game);

        // WHEN
        Optional<Game> actualGame = gameRepo.findByName(name);

        // THEN
        assertThat(actualGame).get().extracting("id", "name").containsExactly(id, name);
    }

    @Test
    public void givenNewGame_whenFindById_thenGetThisGame() {
        // GIVEN
        String id = "3e8b0852-1c66-445a-9d56-c2e87a92b333";
        String name = "997872d3-faae-43b1-97ec-fa36835d014c";
        Game game = Game.builder().id(id).name(name).build();
        gameRepo.save(game);

        // WHEN
        Optional<Game> actualGame = gameRepo.findById(id);

        // THEN
        assertThat(actualGame).get().extracting("id", "name").containsExactly(id, name);
    }

    @Test
    public void givenNewGame_whenFindByTeamId_thenGetThisGame() {
        // GIVEN
        String id = "f0181f7a-57bc-4623-964f-83e0786e9a32";
        String name = "b361a2b2-d66a-4a06-93ea-cf33b4649cab";
        TeamCamp teamCamp = TeamCamp.B;
        Game game = Game.builder().id(id).name(name).build();
        String teamId = game.getTeamId(teamCamp);
        gameRepo.save(game);

        // WHEN
        Optional<Game> actualGame = gameRepo.findByTeamId(teamId);

        // THEN
        assertThat(actualGame).get().extracting("id", "name").containsExactly(id, name);
    }
}