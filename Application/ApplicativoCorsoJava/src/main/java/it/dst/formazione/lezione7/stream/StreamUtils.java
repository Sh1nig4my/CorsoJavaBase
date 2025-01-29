package it.dst.formazione.lezione7.stream;

import java.util.Arrays;
import java.util.List;

public class StreamUtils {

    public static void lezione7_stream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Crea un flusso dalla lista, applica filtro, mappa e somma
        int result = numbers.stream()       // Crea un flusso dalla lista
                .filter(n -> n % 2 == 0) // Filtra i numeri pari
                .mapToInt(n -> n * 2)    // Raddoppia i numeri
                .sum();                 // Somma i risultati

        // Stampa il risultato finale
        System.out.println("Risultato: " + result); // Output: 24
    }
}
