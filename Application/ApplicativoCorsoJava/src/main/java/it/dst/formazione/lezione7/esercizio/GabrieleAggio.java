package it.dst.formazione.lezione7.esercizio;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class GabrieleAggio {

    public static void main(String[] args) {

        //metodoStreamAllenamento();
        //secondoStream();
        streamParole();
    }


    public static void metodoStreamAllenamento() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //https://www.baeldung.com/java-collection-min-max
        int result = numbers.stream()
                .max(Integer::compareTo).orElseThrow(NoSuchElementException::new);

        System.out.println("Valore Massimo: " + result);
    }
    public static void secondoStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 3, 8, 11, 17);

        List<Integer> listaPari = numbers.stream()
                .filter(x -> x % 2 == 0)
                .toList();

        System.out.println("Lista dei pari: " + listaPari);
    }

    public static void streamParole(){
        List<String> paroleList = Arrays.asList("Parola", "Ciao", "Monitor", "Mouse", "Prova", "BlaBla");

        //https://www.w3resource.com/java-exercises/stream/java-stream-exercise-2.php
        List<String> listaMaiuscola = paroleList.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(listaMaiuscola);

        //paroleList.replaceAll(String::toUpperCase) Metodo migliore, però stiamo testando gli stream.
    }

}
