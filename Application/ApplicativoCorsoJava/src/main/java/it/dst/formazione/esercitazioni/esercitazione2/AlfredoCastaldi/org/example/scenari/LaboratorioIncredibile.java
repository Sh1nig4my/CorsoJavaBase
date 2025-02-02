package org.example.scenari;

import org.example.eventi.ProvettaEsplodeInTheFace;

import java.util.Map;

public class LaboratorioIncredibile extends Scenes {

    public LaboratorioIncredibile() {
        super.setScenaryName("Laboratorio incredibile");


        // qui fornisco la mappa delle possibili location a partire da questa
        // posso anche tornare indietro nel corridoio A o proseguire nella stanza delle scimmie

        super.newPossibleDirections = Map.of(1, LaStanzaDelleScimmieInGabbia.class, 2, CorridoioA.class);

        // questa invece andrebbe riempita di eventi legati allo scenario corrente, ad ogni ciclo del gioco 1 di queste instanze viene scelta casualmente
        // portandosi dietro scelte, conseguenze e ricompense
        super.scenaryEvents = Map.of(1,new ProvettaEsplodeInTheFace("ti scoppia una provetta in the face!!!"
        , null
        ));

    }
}
