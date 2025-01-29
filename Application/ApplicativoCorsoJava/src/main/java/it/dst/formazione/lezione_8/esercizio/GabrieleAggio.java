package it.dst.formazione.lezione_8.esercizio;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GabrieleAggio {

    public static void main(String[] args) {

        //puntoPrimoStream();
        //puntoSecondoOptional();
        puntoTerzoCombinareTutto();
    }

    public static void puntoPrimoStream() {

        List<String> listaNomi = List.of("Gabriele", "Giovanni", "Massimo", "Claudio", "Marco", "Giada", "Ugo");

        List<String> risultatoNomi = listaNomi.stream()
                .filter(s -> s.charAt(0) == 'G')
                .map(String::toUpperCase)
                .toList();

        risultatoNomi.forEach(System.out::println);
    }

    //https://www.geeksforgeeks.org/optional-stream-method-in-java-with-examples/
    public static void puntoSecondoOptional(){

        //List<String> listaNomi = List.of("Gabriele", "Giovanni", "Massimo", "Claudio", "Marco", "Giada", "Ugo");
        //Test case se non ci sono nomi con la 'G'
        List<String> listaNomiSenzaG = List.of("Rabriele", "Riovanni", "Massimo", "Claudio", "Marco", "Riada", "Ugo");
        //Test se la lista è null, modificare risultatoNomi = .stream() ed inserire la lista che si vuole testare.
        List<String> listaNomiNull = null;

        try {
            List<String> risultatoNomi = listaNomiNull.stream()
                    .filter(Objects::nonNull)
                    .filter(s -> s.charAt(0) == 'G')
                    .map(String::toUpperCase)
                    .toList();

            Optional<List<String>> optionalNomi = Optional.of(risultatoNomi)
                    .filter(lista -> !lista.isEmpty());

            //https://jsparrow.github.io/rules/optional-if-present-or-else.html#code-changes
            //Esempi ifPresentOrElse
            optionalNomi.ifPresentOrElse(
                    nomi -> nomi.forEach(System.out::println),
                    () -> System.out.println("Niente nomi che iniziano in con 'G' ")
            );

        } catch (NullPointerException ex){
            System.err.println("Errore, hai provato ad usare una lista null");
        }

    }

    public static void puntoTerzoCombinareTutto() {

        List<String> listaNomi = List.of("Gabriele", "Giovanni", "Massimo", "Claudio", "Marco", "Giada", "Ugo");

        List<String> risultatoNomi = listaNomi.stream()
                .filter(s -> s.charAt(0) == 'G')
                .map(String::toUpperCase)
                .toList();

        Optional<List<String>> optionalNomi = Optional.of(risultatoNomi)
                .filter(lista -> !lista.isEmpty());

        //https://jsparrow.github.io/rules/optional-if-present-or-else.html#code-changes
        //Esempi ifPresentOrElse
        optionalNomi.ifPresentOrElse(
                nomi -> nomi.forEach(System.out::println),
                () -> System.out.println("Niente nomi che iniziano in con 'G' ")
        );
    }








}
