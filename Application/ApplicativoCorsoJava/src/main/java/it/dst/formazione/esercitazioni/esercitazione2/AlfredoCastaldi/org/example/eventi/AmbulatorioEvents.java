package org.example.eventi;

import java.util.List;
import java.util.Map;

public class AmbulatorioEvents extends Event {

    public AmbulatorioEvents(String messaggioEvento) {
        super(messaggioEvento, null);

        super.avaibleActions = Map.of(
                1, "vado avanti",
                2, "mi guardo intorno"
        );
        super.eventConsequences = Map.of(1, List.of(
                        (target) -> "cammini verso la prossima meta"),
                2, List.of(
                        (target)-> "LOOK: ti guardi intorno: l'ambulatorio è una stanza bianca, c'è l'healbot che ti ha svegliato"
                )
        );
    }
}
