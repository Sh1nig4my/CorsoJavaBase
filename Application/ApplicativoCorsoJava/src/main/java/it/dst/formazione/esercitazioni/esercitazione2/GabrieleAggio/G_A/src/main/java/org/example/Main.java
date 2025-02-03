package org.example;

import org.example.gioco.Gioco;
import org.example.gioco.GiocoUtils;
import org.example.personaggio.Persona;
import org.example.scenario.BaseScenary;
import org.example.scenario.ScenarioIniziale;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LocalDateTime inizio = LocalDateTime.now();
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

        if(gu.controlloSconfitta(giocatore)){
            return;
        }

        gioco.sceltaSvolta();
        gioco.secondoHacking(giocatore);
        System.out.println(gu.controlloHp(giocatore));

        if(gu.controlloSconfitta(giocatore)){
            return;
        }


        gioco.sceltaSvolta();
        gioco.terzoHacking(giocatore);
        System.out.println(gu.controlloHp(giocatore));

        LocalDateTime fine = LocalDateTime.now();
        double tempo = Duration.between(inizio, fine).getSeconds();
        System.out.println("Minuti totali: " + tempo / 60);

        if(gu.controlloSconfitta(giocatore)){
            System.out.println("*** Hai perso ***");
            return;
        } else {
            gu.stampaVittoria();
        }










    }
}