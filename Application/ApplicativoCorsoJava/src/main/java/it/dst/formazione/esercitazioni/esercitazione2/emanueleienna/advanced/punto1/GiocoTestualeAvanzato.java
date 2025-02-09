package it.dst.formazione.esercitazioni.esercitazione2.emanueleienna.advanced.punto1;

import java.util.Scanner;

public class GiocoTestualeAvanzato {

    public static void main(String[] args) {
        advancedGame();
    }

    public static void advancedGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli il tuo personaggio:");
        System.out.println("1) Pirata Spaziale (Vita: 100, Ossigeno: 50)");
        System.out.println("2) Androide (Vita: 120, Energia: 80)");
        System.out.print("> ");
        int sceltaPersonaggio = scanner.nextInt();
        scanner.nextLine();

        GiocatoreAvanzato giocatore;
        if (sceltaPersonaggio == 1) {
            giocatore = new GiocatoreAvanzato("Pirata Spaziale", 100, 35, 50);
        } else {
            giocatore = new GiocatoreAvanzato("Androide", 120, 5, 80);
        }

        // Simuliamo il consumo di ossigeno/energia durante la missione
        giocatore.consumaOssigeno(10);
    }
}
