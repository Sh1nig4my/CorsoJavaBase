package it.dst.formazione.lezione_8.esercizio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProjectLezione8 {

    public static void base_example_project() {

        List<Optional<String>> nomiOptionalList = List.of(
                Optional.of("Mario"),
                Optional.empty(),
                Optional.of("Anna"),
                Optional.empty(),
                Optional.of("Luigi")
        );
        List<String> risultati = nomiOptionalList.stream()
                .filter(Optional::isPresent) // Filtra solo gli Optional non vuoti
                .map(Optional::get) // Estrai il valore da Optional
                .map(String::toUpperCase) // Trasforma in maiuscolo
                .toList();

        System.out.println("Nomi trasformati: " + risultati);
    }


    public static void advanced_example_project() {

        List<Optional<String>> nomiOptionalList = List.of(
                Optional.of("Mario"),
                Optional.empty(),
                Optional.of("Anna"),
                Optional.empty(),
                Optional.of("Luigi")
        );
        double lunghezzaMedia = nomiOptionalList.stream()
                .flatMap(Optional::stream) // Estrae i valori presenti senza usare isPresent() e get()
                .mapToInt(String::length) // Mappa alla lunghezza delle stringhe
                .average() // Calcola la media
                .orElse(0.0); // Ritorna 0.0 se la lista è vuota

        System.out.println("Lunghezza media dei nomi: " + lunghezzaMedia);
    }

}
