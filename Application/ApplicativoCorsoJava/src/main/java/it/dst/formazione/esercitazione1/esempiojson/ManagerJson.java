package it.dst.formazione.esercitazione1.esempiojson;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerJson {

    public static void esempio_json() {

        // Passo 1: Creazione dei dati
        List<Integer> numeriOriginali = Arrays.asList(10, 20, 15, 7, 9, 3);
        Map<String, List<Integer>> classificazione = new HashMap<>();
        classificazione.put("Pari", Arrays.asList(10, 20));
        classificazione.put("Dispari", Arrays.asList(15, 7, 9, 3));

        Map<String, Object> analisi = new HashMap<>();
        analisi.put("numeroPiuGrande", 20);
        analisi.put("numeroPiuPiccolo", 3);
        analisi.put("media", 10.67);

        // Passo 2: Struttura dati per il salvataggio
        Map<String, Object> datiEsercitazione = new HashMap<>();
        datiEsercitazione.put("numeriOriginali", numeriOriginali);
        datiEsercitazione.put("classificazione", classificazione);
        datiEsercitazione.put("analisi", analisi);

        // Passo 3: Scrittura su file JSON
        try (FileWriter writer = new FileWriter("risultati.json")) {
            Gson gson = new Gson();
            gson.toJson(datiEsercitazione, writer);
            System.out.println("Risultati salvati con successo nel file risultati.json");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file JSON: " + e.getMessage());
        }
    }
}

