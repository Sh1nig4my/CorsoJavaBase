package it.dst.formazione.esercitazioni.esercitazione2.gioco;

import java.time.LocalDateTime;
import java.util.*;

public class GiocoTestuale {

    public static void main(String[] args) {
        inizioGioco();
    }


    public static void inizioGioco() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto su Epsilon 9!");

        // Scelta del personaggio
        System.out.println("Scegli il tuo personaggio:");
        System.out.println("1) Pirata Spaziale (Vita: 100)");
        System.out.println("2) Androide (Vita: 120)");
        System.out.print("> ");
        int sceltaPersonaggio = scanner.nextInt();
        scanner.nextLine(); // Consuma la nuova linea

        Giocatore giocatore;
        if (sceltaPersonaggio == 1) {
            giocatore = new Giocatore("Pirata Spaziale", 100, 35);
        } else {
            giocatore = new Giocatore("Androide", 120, 5);
        }

        System.out.println("Hai scelto: " + giocatore.getNome());

        // Scelta della missione
        System.out.println("Scegli la tua missione:");
        System.out.println("1) Esplora i laboratori segreti");
        System.out.println("2) Esamina la baia di carico");
        System.out.print("> ");
        int scelta = scanner.nextInt();
        scanner.nextLine();

        LocalDateTime inizio = LocalDateTime.now();

        if (scelta == 1) {
            System.out.println("Hai scelto di esplorare i laboratori segreti.");
            System.out.println("Trovi un'intelligenza artificiale ancora attiva. Vuoi interagire con essa? (sì/no)");
            String risposta = scanner.nextLine().trim().toLowerCase();

            Optional<String> decisione = Optional.of(
                    risposta.equals("si") ? "L'IA ti fornisce accesso ai documenti top secret." : "Decidi di ignorarla e proseguire."
            );

            if (!risposta.equals("si")) {
                // Simulazione combattimento
                System.out.println("Improvvisamente, un drone di sicurezza ti attacca!");
                int danno = new Random().nextInt(20) + 10;
                giocatore.subireDanno(danno);
            }

            decisione.ifPresent(System.out::println);

        } else {
            System.out.println("Hai scelto di esaminare la baia di carico. Un container sospetto attira la tua attenzione.");

            // Simulazione combattimento
            System.out.println("Improvvisamente, un drone di sicurezza ti attacca!");
            int danno = new Random().nextInt(20) + 10;
            giocatore.subireDanno(danno);
        }

        System.out.println("Evento casuale: " + Evento.generaEvento());

        LocalDateTime fine = LocalDateTime.now();
        long durata = java.time.Duration.between(inizio, fine).getSeconds();
        System.out.println("Tempo di gioco: " + durata + " secondi.");

    }

}



    

