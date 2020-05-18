package fr.cookiedev.codegrid.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.cookiedev.codegrid.api.GameApi;
import fr.cookiedev.codegrid.domain.Game;
import fr.cookiedev.codegrid.repository.GameRepository;
import fr.cookiedev.codegrid.vo.GameInfo;
import fr.cookiedev.codegrid.vo.GameStatus;

@ExtendWith(MockitoExtension.class)
public class JoinGameTest {

    @Mock
    GameRepository gameRepo;

    GameApi gameApi;

    @BeforeEach
    public void initService() {
        gameApi = new GameService(gameRepo);
    } 

    @Test
    public void givenJustCreatedGame_whenJoinThisGame_thenGetExistingId() {
        // GIVEN
        String id = "uuid";
        String name = "name";
        Game game = Game.builder().id(id).name(name).build();

        when(gameRepo.findByName(name)).thenReturn(Optional.of(game));

        // WHEN
        GameInfo actualGame = gameApi.joinGame(name);

        // THEN
        assertThat(actualGame).extracting("id", "name").containsExactly(id, name);
    }

    @Test
    public void givenNoGames_whenJoinNewGame_thenGetNewId() {
        // GIVEN
        String name = "notExist";
        when(gameRepo.findByName(name)).thenReturn(Optional.empty());

        // WHEN
        GameInfo actualGame = gameApi.joinGame(name);

        // THEN
        assertThat(actualGame.getId()).isNotEmpty();

    }

    @Test
    public void givenStartedGame_whenJoinGame_ThenException() {
        // GIVEN
        String name = "startedGame";
        when(gameRepo.findByName(name)).thenReturn(Optional.of(Game.builder().id("id").name(name).status(GameStatus.BOTH_PLAY).build()));

        // WHEN
        Throwable thrown = catchThrowable(() -> gameApi.joinGame(name));

        // THEN
        assertThat(thrown).isInstanceOf(IllegalStateException.class);
    }
    
}