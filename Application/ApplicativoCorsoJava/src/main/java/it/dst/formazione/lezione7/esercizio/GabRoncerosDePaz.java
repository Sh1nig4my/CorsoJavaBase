package it.dst.formazione.lezione7.esercizio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GabRoncerosDePaz {
    public static void plutarco() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 11, 12, 14, 15, 18, 22, 89, 47, 86, 111, 225);
        List<String> parole = Arrays.asList("Ciao", "MIao", "Spasiba", "petaloso", "Lawliet");

        // Trova l'elemento più grande
        Optional<Integer> maxNumber = numbers.stream()
                .max(Integer::compareTo);

        // Stampa il risultato
        maxNumber.ifPresentOrElse(
                numero -> System.out.println("L'elemento più grande è: " + numero),
                () -> System.out.println("La lista è vuota")
        );

        // Filtra i numeri pari e crea una sottolista
        List<Integer> numeriPari = numbers.stream()
                .filter(numero -> numero % 2 == 0) // Filtra i numeri pari
                .collect(Collectors.toList());     // Colleziona in una nuova lista

        List<String> paroleMaiuscole = parole.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(paroleMaiuscole);


        // Stampa i numeri pari
        System.out.println("Numeri pari: " + numeriPari);
    }

    public static void main(String[] args) {
        plutarco();
    }
}
