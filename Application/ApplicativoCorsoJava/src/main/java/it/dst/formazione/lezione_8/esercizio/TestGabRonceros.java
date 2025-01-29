//package it.dst.formazione.lezione_8.esercizio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestGabRonceros {

    // 1. Funzione per filtrare valori nulli da una lista di oggetti
    public static <T> List<T> filtraNullo(List<T> lista) {
        return lista.stream()
                .filter(valore -> valore != null)
                .collect(Collectors.toList());
    }

    // 2. Funzione che, data una lista di stringhe, restituisce le lunghezze delle
    // stringhe non nulle
    public static List<Integer> lunghezzeNonNulle(List<String> lista) {
        return lista.stream()
                .filter(str -> str != null)
                .map(String::length)
                .collect(Collectors.toList());
    }

    // 3. Funzione che restituisce un messaggio predefinito se tutti i valori nella
    // lista sono nulli
    public static String messaggioSeTuttiNulli(List<String> lista) {
        Optional<String> risultato = lista.stream()
                .filter(str -> str != null)
                .findFirst(); // Prendi il primo valore non nullo

        return risultato.orElse("Tutti i valori sono nulli.");
    }

    public static void main(String[] args) {
        // 1. Test filtraggio valori nulli
        List<String> listaConNulli = Arrays.asList("Alice", null, "Carlo", null, "GianGiorgio");
        List<String> listaFiltrata = filtraNullo(listaConNulli);
        System.out.println("Lista filtrata (senza nulli): " + listaFiltrata);

        // 2. Test lunghezze non nulle
        List<String> listaStringhe = Arrays.asList("Alice", "Bob", null, "Carlo");
        List<Integer> lunghezze = lunghezzeNonNulle(listaStringhe);
        System.out.println("Lunghezze delle stringhe non nulle: " + lunghezze);

        // 3. Test messaggio se tutti i valori sono nulli
        List<String> listaTuttiNulli = Arrays.asList(null, null, null);
        String messaggio = messaggioSeTuttiNulli(listaTuttiNulli);
        System.out.println("Messaggio: " + messaggio);
    }
}
