package org.example.scenari;

import java.util.Map;

public class Ambulatorio extends Scenes {

    public Ambulatorio() {
        super.newPossibleDirections = Map.of(
                1, CorridoioA.class,
                2, CorridoioB.class
        );

        super.setScenaryName("Ambulatorio");
    }
}

