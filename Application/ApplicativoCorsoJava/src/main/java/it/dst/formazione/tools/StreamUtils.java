package it.dst.formazione.tools;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamUtils {

    // Metodo che filtra numeri pari usando Stream API
    public static List<Integer> filtraNumeriPari(List<Integer> numeri) {
        return numeri.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    // Metodo che converte una lista di stringhe in maiuscolo usando Stream API
    public static List<String> convertiMaiuscolo(List<String> parole) {
        return parole.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    // Metodo che restituisce il massimo valore di una lista usando Optional
    public static Optional<Integer> trovaMassimo(List<Integer> numeri) {
        return numeri.stream().max(Integer::compare);
    }

    // Metodo che restituisce un Optional contenente una stringa con valore predefinito se null
    public static String getNome(Optional<String> nome) {
        return nome.orElse("Nome non disponibile");
    }

    // Metodo che restituisce la somma dei numeri dispari usando Stream API
    public static int sommaDispari(List<Integer> numeri) {
        return numeri.stream()
                .filter(n -> n % 2 != 0)
                .reduce(0, Integer::sum);
    }

    // Metodo principale per testare i metodi della classe
    public static void main(String[] args) {
        List<Integer> numeri = Arrays.asList(10, 15, 20, 25, 30, 35);
        List<String> parole = Arrays.asList("java", "stream", "optional");

        System.out.println("Numeri pari: " + filtraNumeriPari(numeri));
        System.out.println("Parole in maiuscolo: " + convertiMaiuscolo(parole));
        System.out.println("Massimo valore: " + trovaMassimo(numeri).orElse(-1));
        System.out.println("Nome: " + getNome(Optional.empty()));
        System.out.println("Somma numeri dispari: " + sommaDispari(numeri));
    }
}
