package it.dst.formazione.lezione4;

import java.util.HashMap;

public class Stracture_HashMap {

    public static void test_HashMap() {
        // Creazione della mappa
        HashMap<Integer, String> map = new HashMap<>();

        // Popolamento della mappa
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Iterazione e stampa degli elementi
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
