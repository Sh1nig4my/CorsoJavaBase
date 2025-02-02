package org.example.eventi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ComputerFound extends Event{

    public ComputerFound(String messaggioEvento, String possibleReward) {
        super(messaggioEvento, null);
        super.avaibleActions = Map.of(
                1, "provi ad hackerare il computer",
                2, "lo ignori"
        );
        super.eventConsequences = Map.of(1, Arrays.asList(
                (pg)-> {
                    if (Event.computerHackingGame()) {
                        return "trovi un sacco di informazioni incredibili sulle scimmie assassine";
                    } else {
                        int hp = target.getVita();
                        target.setVita(hp - 3);
                        return "ti scoppia il computer in faccia prendi 3 danni";
                    }
                }),
                2, List.of((pg) -> "ignori il computer")
        );
    }



}
