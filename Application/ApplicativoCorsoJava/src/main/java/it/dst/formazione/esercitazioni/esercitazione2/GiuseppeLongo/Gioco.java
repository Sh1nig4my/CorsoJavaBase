package it.dst.formazione.esercitazioni.esercitazione2.GiuseppeLongo;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Optional;

public class Gioco {
    private Scanner scanner;
    private Personaggio personaggio;

    // Costanti personaggio
    private static final String TIPO_ROBOT = "Robot";
    private static final String TIPO_MAGO = "Mago";
    private static final String TIPO_LADRO = "Ladro";
    private static final String PROMPT = "> ";

    // Costanti personaggi
    private static final class StatistichePersonaggio {
        static final int VITA_ROBOT = 120;
        static final int DANNO_ROBOT = 30;
        static final String ORIGINE_ROBOT = "Regno di Arathor";

        static final int VITA_MAGO = 80;
        static final int DANNO_MAGO = 50;
        static final String ORIGINE_MAGO = "Torre degli Arcani";

        static final int VITA_LADRO = 100;
        static final int DANNO_LADRO = 25;
        static final String ORIGINE_LADRO = "Gilda delle Ombre";
    }

    public Gioco() {
        scanner = new Scanner(System.in);
    }


    public void inizia() {
        LocalDateTime inizio = LocalDateTime.now();

        System.out.println("Attenzione stai sbarcando sulla stazione spaziale abbandonata Epsilon 9");
        scegliPersonaggio();
        scegliPercorso();
        scanner.close();

        System.out.println("Orario di inizio: " + inizio + " secondi.");


        LocalDateTime fine = LocalDateTime.now();
        long durata = java.time.Duration.between(inizio, fine).getSeconds();
        System.out.println("Orario di fine: " + fine + " secondi.");
        System.out.println("Tempo di gioco: " + durata + " secondi.");
    }

    private void scegliPercorso() {
        System.out.println("Dove vuoi dirigerti?");
        System.out.println("1. Esplora i laboratori segreti");
        System.out.println("2. Ispeziona la baia di carico");

        int scelta = leggiNumero(1, 2);

        switch (scelta) {
            case 1 -> new EventoLaboratorio(scanner).esegui(personaggio);
            case 2 -> new EventoBaiaDiCarico(scanner).esegui(personaggio);
        }
    }

    private void scegliPersonaggio() {
        System.out.println("Scegli un personaggio:");
        System.out.println("1. " + TIPO_ROBOT);
        System.out.println("2. " + TIPO_MAGO);
        System.out.println("3. " + TIPO_LADRO);

        int scelta = leggiNumero(1, 3);

        switch (scelta) {
            case 1 -> personaggio = new Personaggio(
                    TIPO_ROBOT,
                    StatistichePersonaggio.VITA_ROBOT,
                    StatistichePersonaggio.DANNO_ROBOT,
                    StatistichePersonaggio.ORIGINE_ROBOT
            );
            case 2 -> personaggio = new Personaggio(
                    TIPO_MAGO,
                    StatistichePersonaggio.VITA_MAGO,
                    StatistichePersonaggio.DANNO_MAGO,
                    StatistichePersonaggio.ORIGINE_MAGO
            );
            case 3 -> personaggio = new Personaggio(
                    TIPO_LADRO,
                    StatistichePersonaggio.VITA_LADRO,
                    StatistichePersonaggio.DANNO_LADRO,
                    StatistichePersonaggio.ORIGINE_LADRO
            );
        }

        System.out.println("Hai scelto: " + scelta );
        personaggio.mostraStatistiche();
    }

    private int leggiNumero(int min, int max) {
        while (true) {
            System.out.print(PROMPT);
            try {
                if (scanner.hasNextInt()) {
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    if (numero >= min && numero <= max) {
                        return numero;
                    } else {
                        System.out.println("Per favore inserisci un numero tra " + min + " e " + max);
                    }
                } else {
                    System.out.println("Per favore inserisci un numero valido");
                    scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Errore nell'input. Per favore inserisci un numero valido");
                scanner.nextLine();
            }
        }
    }


}

