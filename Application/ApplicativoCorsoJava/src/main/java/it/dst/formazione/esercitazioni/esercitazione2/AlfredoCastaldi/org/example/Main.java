package org.example;

import org.example.gameplay.GameState;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*

Scelta del personaggio: Il giocatore deve poter scegliere tra diversi personaggi di gioco (esempio pirata spaziale, un androide, ..), si consiglia di utilizzare una classe/interfaccia Persona per la creazione dei diversi personaggi di gioco; ogni personaggio dovrà avere attributi come nome, vita, anni, punti feriti, inventario, ..
Scelta del percorso: Il giocatore deve poter scegliere tra diversi scenari di gioco (esempio se esplorare i laboratori segreti o la baia di carico).
Eventi casuali con Stream: Implementa una lista di eventi come intelligenze artificiali attive, moduli danneggiati o terminali di sicurezza da hackerare.
Utilizzo di Optional: Gestisci situazioni in cui il giocatore potrebbe trovare o meno informazioni segrete.
Sistema di combattimento o hacking: Implementa un meccanismo basato su probabilità e/o abilità del personaggio. Nello specifico, utilizza una struttura dati per rappresentare nemici con punti vita e attacchi e simila un combattimento con il personaggio principale della storia.
Gestione del tempo: Registra l'orario di inizio e fine della missione con le Date API.
         */
        GameState game = new GameState();
      /*
        game.gameInit();
         game.choseClass();
        game.runScenario();
       */

       game.gameInit();
       game.choseClass();
       game.gameContext();
       game.runScenario();
    }


}