package org.example.eventi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LeScimmieTiAttaccano extends Event {

    public LeScimmieTiAttaccano(String messaggioEvento) {
        super(messaggioEvento, null);

        super.avaibleActions = Map.of(
                1, "tiro pugni a destra e a sinistra in modo figo",
                2, "accetto la fine"
        );
        super.eventConsequences = Map.of(1, List.of(
                (target) -> {
                    System.out.println("sei riuscito a sconfiggere le scimmie assassine, scopri che la missione " +
                            "era appunto distruggere queste aberrazioni della nattura che puzzano pure");
                    return true;
                }),
                2, List.of(
                        (target) -> {

                            int hp = target.getVita(); target.setVita(hp - 20000);
                            System.out.println("ti lasci andare e le scimmie fanno di te quello che vogliono");
                            return "senti perdere le energie ";
                        })

        );
    }
}
