package org.example.ambientazione;

import org.example.eventi.Eventi;
import org.example.giocatore.Persona;
import org.example.giocatore.Ruolo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scenario extends Ambientazione {
    String percorso;

    public Scenario(String percorso) {

        this.percorso = percorso;
    }

    public Scenario() {

    }

    public String getPercorso() {
        return percorso;
    }

    public static Scenario scegliPercorso() {
        Scanner scanner = new Scanner(System.in);

        int sceltaPercorso;

        while (true) {
            System.out.println("Scegli percorso: \n");
            System.out.println("1> Corridoio");
            System.out.println("2> Sala Macchine ");
            System.out.println("3> Dormitori");
            System.out.println("\nDove vuoi andare?\n");

            if (scanner.hasNextInt()) {
                sceltaPercorso = scanner.nextInt();
                if (sceltaPercorso == 1 || sceltaPercorso == 2 || sceltaPercorso == 3) {

                    break;

                } else {
                    System.out.println("Puoi scegliere soltanto 1,2 o 3.");
                }

            } else {
                System.out.println("Devi inserire un numero");
                scanner.next();
            }
        }

        Scenario scenarioGenerico = new Scenario();

        if (sceltaPercorso == 1) {
            scenarioGenerico.setNome("Corridoio");
            System.out.println("Ti avvii con prudenza verso il  " + scenarioGenerico.getNome());
            Eventi.eventiRandomCorridoio();
        } else if (sceltaPercorso == 2) {

            scenarioGenerico.setNome("Sala Macchine");
            System.out.println("Ti muovi con prudenza verso la " + scenarioGenerico.getNome());
            Eventi.eventiRandomSalaMacchine();

        } else if (sceltaPercorso == 3) {
            scenarioGenerico.setNome("Dormitori");
            System.out.println("Ti avvicini con prudenza verso i " + scenarioGenerico.getNome());
            Eventi.eventiRandomDormitori();

        } else {
            System.out.println("Scelta non valida, prova di nuovo scegliendo tra 1,2 o 3.");
            sceltaPercorso = scanner.nextInt();
            System.out.println("1> Corridoio");
            System.out.println("2> Sala Macchine ");
            System.out.println("3> Dormitori");
            System.out.println("\nDove vuoi andare?\n>");
        }

        return scenarioGenerico;
    }
}


