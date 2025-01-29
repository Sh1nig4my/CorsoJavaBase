package it.dst.formazione.tools.structure;

import java.util.HashMap;
import java.util.Map;

public class Stracture_HashMap {

    public static void test_HashMap() {
        // Creazione della mappa
        HashMap<Integer, String> map = new HashMap<>();

        // Popolamento della mappa
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Iterazione e stampa degli elementi
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
