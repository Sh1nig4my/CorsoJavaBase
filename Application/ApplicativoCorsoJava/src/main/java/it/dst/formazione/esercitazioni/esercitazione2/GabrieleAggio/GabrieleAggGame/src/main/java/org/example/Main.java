package org.example;

import org.example.gioco.Gioco;
import org.example.gioco.GiocoUtils;
import org.example.personaggio.Persona;
import org.example.scenario.BaseScenary;
import org.example.scenario.ScenarioIniziale;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Gioco gioco = new Gioco();
        GiocoUtils gu = new GiocoUtils();
        ScenarioIniziale sceniniz = new ScenarioIniziale();
        Persona giocatore;


        sceniniz.disegnoScenario();
        sceniniz.descrizioneScenario();
        giocatore = gioco.scegliPersonaggio();

        gioco.sceltaSvolta();
        gu.gestisciOggettiSegreti(giocatore);
        gioco.primoHacking(giocatore);

        if(gu.ControlloSconfitta(giocatore)){
            return;
        }

        gioco.sceltaSvolta();
        gioco.secondoHacking(giocatore);


        gioco.sceltaSvolta();

        if(gu.ControlloSconfitta(giocatore)){
            return;
        } else {
            System.out.println("HAI VINTO YEY");
        }










    }
}