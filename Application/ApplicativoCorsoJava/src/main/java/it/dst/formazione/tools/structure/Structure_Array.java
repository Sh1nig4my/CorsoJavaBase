package it.dst.formazione.tools.structure;

import java.util.ArrayList;

public class Structure_Array {

    public static void test_array() {
        // Creazione della lista
        ArrayList<String> names = new ArrayList<>();

        // Aggiunta di elementi
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Iterazione e stampa degli elementi
        for (String name : names) {
            System.out.println(name);
        }
    }
}
