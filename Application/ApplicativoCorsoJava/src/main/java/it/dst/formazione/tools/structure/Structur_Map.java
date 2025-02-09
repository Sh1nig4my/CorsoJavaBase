package it.dst.formazione.tools.structure;

import java.util.HashMap;
import java.util.Map;

public class Structur_Map {

    public static void esempio_Map() {
        Map<String, Integer> inventario = new HashMap<>();

        // Aggiungere coppie chiave-valore
        inventario.put("Mele", 10);
        inventario.put("Banane", 5);
        inventario.put("Arance", 7);

        // Recuperare un valore
        System.out.println("Quantità di mele: " + inventario.get("Mele"));

        // Iterare su una mappa
        System.out.println("Inventario:");
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Rimuovere una chiave
        inventario.remove("Banane");
        System.out.println("Dopo la rimozione: " + inventario);
    }
}
