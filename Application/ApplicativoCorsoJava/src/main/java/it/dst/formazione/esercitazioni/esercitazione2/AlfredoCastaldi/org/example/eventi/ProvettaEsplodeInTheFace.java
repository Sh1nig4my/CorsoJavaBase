package org.example.eventi;

import java.util.Arrays;
import java.util.Map;

public class ProvettaEsplodeInTheFace extends Event {

    public ProvettaEsplodeInTheFace(String messaggioEvento,  String possibleReward) {
        super(messaggioEvento,  possibleReward);
        super.avaibleActions = Map.of(
                1, "provi a schivare",
                2, "ti proteggi con le braccia"
        );
        super.eventConsequences = Map.of(1, Arrays.asList(
                (target )-> { int vita = target.getVita(); target.setVita(vita - 5); return "hai perso 5 di vita!!!";},
                (target )-> "sei riuscito a schivare la pozione!!!"),
                2, Arrays.asList(
                (target )-> { int vita = target.getVita(); target.setVita(vita - 100); return "hai perso 5 di vita!!!";},
                (target )-> { int vita = target.getVita(); target.setVita(vita - 2); return "sei riuscito a proteggere almeno i tuoi occhi, hai perso 2 punti vita";})
        );

    }
}
