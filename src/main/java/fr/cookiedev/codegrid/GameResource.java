package fr.cookiedev.codegrid;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.cookiedev.codegrid.api.GameApi;
import fr.cookiedev.codegrid.vo.GameInfo;

@Path("/game")
public class GameResource {

    private final GameApi gameApi;

	public GameResource(final GameApi gameApi) {
        this.gameApi = gameApi;
    }

    @GET @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public GameInfo joinGame(@PathParam("name") final String name) {
        return gameApi.joinGame(name);
    }
}