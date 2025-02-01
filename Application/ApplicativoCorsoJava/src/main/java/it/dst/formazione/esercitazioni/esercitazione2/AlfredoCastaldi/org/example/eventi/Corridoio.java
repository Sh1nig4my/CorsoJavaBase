package org.example.eventi;

import java.util.List;
import java.util.Map;

public class Corridoio extends Event{

    public Corridoio(String messaggioEvento, String possibleReward) {
        super(messaggioEvento, possibleReward);
        super.avaibleActions = Map.of(
                1, "vado avanti"
        );
        super.eventConsequences = Map.of(1, List.of(
                        (target) -> "cammini verso la prossima meta"),
                2, List.of(
                        (target)-> "LOOK: ti guardi intorno: il bianco corridoio ti inquieta"
                )
        );
    }
}
