package it.dst.formazione.lezione_8.esercizio;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class NicholasPorta {
    public static void main(String[] args) {

        //Utilizzare Stream API per processare collezioni di dati in modo dichiarativo.

        List<String> nomi = Arrays.asList("luca", "edoardo", "andrea");


        List<String> nomiMaius = nomi.stream()
                .map(String::toUpperCase)
                .sorted()
                .toList();
        System.out.println(nomiMaius);

        //Implementare Optional per gestire valori nulli senza rischiare eccezioni.
        System.out.println("-----------------");
        List<Optional<String>> nomi2 = List.of(
                Optional.of("luca"),
                Optional.ofNullable(null),
                Optional.of("edoardo"),
                Optional.of("andrea")
        );


        List<String> risultati = nomi2.stream()
                .map(n -> n.map(String::toUpperCase)
                        .orElse("nome assente"))
                .toList();
        System.out.println(risultati);


    }
}
