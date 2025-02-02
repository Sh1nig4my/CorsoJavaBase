package org.example.eventi;

import java.util.Arrays;
import java.util.Map;

public class ProvettaEsplodeInTheFace extends Event {

    public ProvettaEsplodeInTheFace(String messaggioEvento) {
        super(messaggioEvento,  null);

       // questo serve solo per prendere la scelta del giocatore come numero
        // la chiave di questa mappa verrà utilizzatà per determinare quale lista di conseguenze debba essere usata

        super.avaibleActions = Map.of(
                1, "provi a schivare",
                2, "ti proteggi con le braccia"
        );



        // ogni volta che instanzio un evento gli fornisco separatamente
        // le conseguenze possibili divise per scelta
        // ogni lista di lambda è legata ad una scelta
        // esempio
        // giocatore sceglie 1
        // o viene colpito e perde 5 punti vita o schiva la pozione

        super.eventConsequences = Map.of(1, Arrays.asList(
                (target )-> { int vita = target.getVita(); target.setVita(vita - 5); return "la pozione ti colpisce, hai perso 5 di vita!!!";},
                (target )-> "sei riuscito a schivare la pozione!!!"),
                2, Arrays.asList(
                (target )-> { int vita = target.getVita(); target.setVita(vita - 5); return "non riesci a proteggerti in tempo, hai perso 5 di vita!!!";},
                (target )-> { int vita = target.getVita(); target.setVita(vita - 2); return "sei riuscito a proteggere almeno i tuoi occhi, hai perso 2 punti vita";})
        );

    }
}
