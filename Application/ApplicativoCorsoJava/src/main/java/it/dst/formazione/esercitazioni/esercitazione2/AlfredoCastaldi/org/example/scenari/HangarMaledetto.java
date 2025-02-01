package org.example.scenari;

import org.example.eventi.ComputerFound;
import org.example.eventi.LeScimmieTiAttaccano;

import java.util.Map;

public class HangarMaledetto extends Scenes{
    public HangarMaledetto() {

        super.setScenaryName("l'hangar maledetto");
        super.newPossibleDirections = Map.of(
                1, CorridoioB.class
        );

        super.scenaryEvents = Map.of(1, new ComputerFound("hai trovato un computer da hackerare", null));
    }
}
