package fr.cookiedev.codegrid.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

import fr.cookiedev.codegrid.vo.GameStatus;
import fr.cookiedev.codegrid.vo.TeamCamp;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Game {
    @NonNull
    private final String id;

    @NonNull
    private final String name;

    private final Map<TeamCamp, String> teamIds = computeTeamIds();
    
    @Builder.Default
    private GameStatus status = GameStatus.SETUP;

    public static Game create(String name) {
        return builder().id(UUID.randomUUID().toString()).name(name).status(GameStatus.SETUP).build();
    }

	public String getTeamId(TeamCamp camp) {
        String teamId = teamIds.get(camp);

        if (teamId == null) {
            teamId = UUID.randomUUID().toString();
            teamIds.put(camp, teamId);
        }

		return teamId;
    }
    
    private static Map<TeamCamp, String> computeTeamIds() {
        Map<TeamCamp, String> teamIds = new EnumMap<>(TeamCamp.class);
        teamIds.put(TeamCamp.A, UUID.randomUUID().toString());
        teamIds.put(TeamCamp.B, UUID.randomUUID().toString());
        return teamIds;
    }
}
