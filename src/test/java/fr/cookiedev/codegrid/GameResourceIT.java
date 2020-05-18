package fr.cookiedev.codegrid;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static fr.cookiedev.codegrid.utils.IsAUUID.*;

@QuarkusTest
public class GameResourceIT {

    @Test
    public void testHelloEndpoint() {
        String name = "okgame";
        given()
          .when().get("/game/" + name)
          .then()
             .statusCode(200)
             .body("id", aUUID());
    }

}