package it.dst.formazione.esercitazioni.esercitazione2.GiuseppeLongo;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class EventoLaboratorio implements Evento {
    private Scanner scanner;
    private Random random;
    private static final List<String> EVENTI_CASUALI = Arrays.asList(
            "IA Malfunzionante",
            "Esperimento Fallito",
            "Sistema di Sicurezza Attivo"
    );

    public EventoLaboratorio(Scanner scanner) {
        this.scanner = scanner;
        this.random = new Random();
    }

    @Override
    public void esegui(Personaggio personaggio) {
        String eventoSelezionato = EVENTI_CASUALI.stream()
                .skip(random.nextInt(EVENTI_CASUALI.size()))
                .findFirst()
                .orElse("IA Malfunzionante");

        System.out.println("Ti trovi nei laboratori segreti. " + eventoSelezionato + " rilevato!");
        System.out.println("1. Prova a hackerare il sistema (+20 potenza, rischio danno)");
        System.out.println("2. Cerca una via di fuga sicura");
        System.out.println("3. Affronta direttamente la minaccia");
        System.out.print("> ");

        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Tenti di hackerare il sistema...");
                    if (random.nextBoolean()) {
                        System.out.println("Hack riuscito! Hai aumentato la tua potenza!");
                        personaggio.aumentaPotenza(20);
                    } else {
                        System.out.println("Il sistema di sicurezza ti ha rilevato! Subisci danno!");
                        personaggio.subisciDanno(30);
                    }
                }
                case 2 -> System.out.println("Sei riuscito a trovare un percorso sicuro attraverso i condotti di ventilazione.");
                case 3 -> {
                    System.out.println("Affronti la minaccia direttamente!");
                    personaggio.subisciDanno(20);
                    System.out.println("Hai subito danni ma hai neutralizzato la minaccia!");
                }
                default -> System.out.println("Esiti troppo a lungo e la situazione peggiora...");
            }
        }
    }
}