package it.dst.formazione.lezione7.esercizio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NicholasPorta {

    public static void esercizoStrem() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Optional<Integer> maxNumber = numbers.stream().max(Integer::compareTo);

        System.out.println("Risultato: " + maxNumber);

        List<Integer> nuovaLista= numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(nuovaLista);


        List<String> parole = Arrays.asList("ciao","sera","giorno","addio");

        List<String> maiuscolo = parole.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());

        System.out.println(maiuscolo);

    }
}