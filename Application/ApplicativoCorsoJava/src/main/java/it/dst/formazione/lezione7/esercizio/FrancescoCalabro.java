package it.dst.formazione.lezione7.esercizio;

import java.util.Arrays;
import java.util.List;

public class FrancescoCalabro {

    public static void metodoLezioneStream() {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        Optional<Integer> maxNumber = numbers.stream()
//        .max(Integer::compareTo);
//
//        Integer nMax = 0;
//
//        for (Integer numeriLista : numbers) {
//            if (numeriLista > nMax) {
//                nMax = numeriLista;
//            }
//        }
//        System.out.println("Il numero massimo é " + nMax);
//        System.out.println(maxNumber);

//        List<Integer> numbers = Arrays.asList(1, 2, 20, 4, 10, 6, 3, 8, 11, 17);
//
//        List<Integer> listaNumeriPari = numbers.stream()
//                .filter(numero -> numero % 2 == 0)
//                .toList();

        List<String> parole = Arrays.asList("java", "stream", "api");

        List<String> paroleMaiuscole = parole.stream()
                .map(String::toUpperCase)
                .toList();
    }
}
