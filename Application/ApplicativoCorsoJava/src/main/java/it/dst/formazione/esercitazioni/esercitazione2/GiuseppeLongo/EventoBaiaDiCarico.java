package it.dst.formazione.esercitazioni.esercitazione2.GiuseppeLongo;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Arrays;

public class EventoBaiaDiCarico implements Evento {
    private Scanner scanner;
    private Random random;
    private static final List<String> EVENTI_CASUALI = Arrays.asList(
            "Container Danneggiato",
            "Perdita di Ossigeno",
            "Robot da Carico Ostile"
    );

    public EventoBaiaDiCarico(Scanner scanner) {
        this.scanner = scanner;
        this.random = new Random();
    }

    @Override
    public void esegui(Personaggio personaggio) {
        String eventoSelezionato = EVENTI_CASUALI.stream()
                .skip(random.nextInt(EVENTI_CASUALI.size()))
                .findFirst()
                .orElse("Container Danneggiato");

        System.out.println("Ti trovi nella baia di carico. " + eventoSelezionato + " rilevato!");
        System.out.println("1. Cerca rifornimenti nei container (+20 HP, rischio danno)");
        System.out.println("2. Tenta di riparare il danno");
        System.out.println("3. Abbandona l'area rapidamente");
        System.out.print("> ");

        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Cerchi tra i container...");
                    if (random.nextBoolean()) {
                        System.out.println("Hai trovato dei medikit! Ti curi!");
                        personaggio.cura(20);
                    } else {
                        System.out.println("Un container instabile ti cade addosso!");
                        personaggio.subisciDanno(25);
                    }
                }
                case 2 -> {
                    System.out.println("Tenti di riparare il danno...");
                    if (random.nextInt(100) < 70) {  // 70% di successo
                        System.out.println("Riparazione riuscita! L'area è ora sicura.");
                        personaggio.aumentaPotenza(10);
                    } else {
                        System.out.println("La situazione peggiora! Il danno si estende!");
                        personaggio.subisciDanno(15);
                    }
                }
                case 3 -> System.out.println("Ti allontani velocemente dall'area pericolosa.");
                default -> System.out.println("L'indecisione ti costa cara...");
            }
        }
    }
}
