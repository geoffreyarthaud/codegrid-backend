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
import fr.cookiedev.codegrid.vo.TeamCamp;
import fr.cookiedev.codegrid.vo.TeamInfo;

@ExtendWith(MockitoExtension.class)
public class JoinTeamTest {
    @Mock
    GameRepository gameRepo;

    GameApi gameApi;

    @BeforeEach
    public void initService() {
        gameApi = new GameService(gameRepo);
    } 

    @Test
    public void givenACorrectGameId_whenJoinATeam_thenGetTeamIdAndCorrectAttibutes() {
        // GIVEN
        String gameId = "cb753a35-d1e3-4cd8-9c41-dd1956cc947d";
        String gameName = "testgame";
        Game game = Game.builder().id(gameId).name(gameName).build();
        when(gameRepo.findById(gameId)).thenReturn(Optional.of(game));

        // WHEN
        TeamInfo teamInfo = gameApi.joinTeam(gameId, TeamCamp.A);

		// THEN
        assertThat(teamInfo).extracting("camp", "gameInfo.id", "gameInfo.name").containsExactly(TeamCamp.A, gameId, gameName);
    }

}