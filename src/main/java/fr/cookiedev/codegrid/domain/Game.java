package fr.cookiedev.codegrid.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Game {
    private String id;
    private String name;
}
