package it.dst.formazione.lezione_8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamExample {

    public static void streamFilterMap() {
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> risultati = numeri.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .toList();

        System.out.println("Risultati: " + risultati); // Output: [4, 8, 12]
    }

    public static void calcoloMedia() {
        int[] numeri = {1, 2, 3, 4, 5, 6};

        OptionalDouble media = Arrays.stream(numeri).average();

        if (media.isPresent()) {
            System.out.println("La media è: " + media.getAsDouble()); // Output: 3.5
        } else {
            System.out.println("Lista vuota, impossibile calcolare la media.");
        }
    }

    public static void calcoloProdotto() {
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4);

        int prodotto = numeri.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("Il prodotto è: " + prodotto); // Output: 24
    }

    public static void OptionalExample() {
        Optional<String> nome = Optional.of("Java");

        nome.ifPresent(n -> System.out.println("Il valore è: " + n));

        String valore = nome.orElse("Valore di default");
        System.out.println("Valore: " + valore); // Output: Java
    }

    public static void opzionalCombinazioni() {
        Optional<String> valore = Optional.of("Ciao");

        Optional<Integer> lunghezza = valore.map(String::length);
        lunghezza.ifPresent(l -> System.out.println("Lunghezza: " + l)); // Output: 4

        Optional<Optional<String>> annidato = Optional.of(Optional.of("Annidato"));
        annidato.flatMap(v -> v).ifPresent(System.out::println); // Output: Annidato
    }

    public static void sommaNumeriDispari() {
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5);

        int somma = numeri.stream()
                .filter(n -> n % 2 != 0)
                .reduce(0, Integer::sum);

        System.out.println("Somma dei numeri dispari: " + somma); // Output: 9
    }

    public static void listaPiatta() {
        List<List<Integer>> listaAnnidata = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> listaPiatta = listaAnnidata.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("Lista piatta: " + listaPiatta); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    public static void opzionalOrElseGet() {
        Optional<String> valore = Optional.empty();

        String risultato = valore.orElseGet(() -> "Valore calcolato al momento");
        System.out.println(risultato); // Output: Valore calcolato al momento
    }

}
