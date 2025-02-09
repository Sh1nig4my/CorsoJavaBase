package it.dst.formazione.tools.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Structure_List {

    public static void esempio_List() {
        List<Integer> numeri = new LinkedList<>();
        // INFO: differenze?
        List<Integer> numeri2 = new ArrayList<>();

        // Aggiungere elementi
        numeri.add(10);
        numeri.add(20);
        numeri.add(30);

        // Inserire un elemento in una posizione specifica
        numeri.add(1, 15);

        // Iterazione con ciclo for
        System.out.println("Numeri nella lista:");
        for (int numero : numeri) {
            System.out.println(numero);
        }

        // Verificare se un elemento esiste
        System.out.println("La lista contiene 20? " + numeri.contains(20));
    }
}
