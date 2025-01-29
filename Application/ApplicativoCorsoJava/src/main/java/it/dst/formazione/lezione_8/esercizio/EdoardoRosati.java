package it.dst.formazione.lezione_8.esercizio;

import java.util.*;
import java.util.stream.Collectors;

public class EdoardoRosati {

    public static void main(String[] args) {

        //Lista di cose senza optional
        List<String> catalogo = Arrays.asList("Armadio", "Cassettiera", null, "Appendiabiti", null, "Letto", "Quadro");

        System.out.println("Nomi inseriti: " + catalogo);

        //Rimuovo i null
        List<String> sortCatalogoNoOptional = catalogo.stream()
                .filter(value -> value != null && !value.isEmpty())
                .toList();

        //Check con un print
        System.out.println("Nomi filtrati con stream senza optional" + sortCatalogoNoOptional);

        //Lista con gli Optional
        List<Optional<String>> catalogoOptional = List.of(
                Optional.of("Armadio"),
                Optional.of("Cassettiera"),
                Optional.empty(),
                Optional.of("Appendiabiti"),
                Optional.empty(),
                Optional.of("Letto"),
                Optional.of("Quadro")
        );

        System.out.println("Nomi inseriti con Optional: " + catalogoOptional);

        //Rimuovo i null con gli optional
        List<String> sortCatalogo = catalogoOptional.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        System.out.println("Nomi filtrati con Optional: " + sortCatalogo);

        //Calcolo lunghezza media dei nomi
        double lunghezzaMedia = catalogoOptional.stream()
                .flatMap(Optional::stream)
                .mapToInt(String::length)
                .average()
                .orElse(0.0);

        System.out.println("Lunghezza media dei nomi: " + lunghezzaMedia);


    }


}
