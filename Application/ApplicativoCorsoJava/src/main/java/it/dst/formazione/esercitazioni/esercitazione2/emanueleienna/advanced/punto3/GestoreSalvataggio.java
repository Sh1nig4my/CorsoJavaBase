package it.dst.formazione.esercitazioni.esercitazione2.emanueleienna.advanced.punto3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.dst.formazione.esercitazioni.esercitazione2.emanueleienna.advanced.punto2.GiocatoreConInventario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestoreSalvataggio {

    private static final String FILE_SALVATAGGIO = "statoGioco.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvaPartita(GiocatoreConInventario giocatore) {

        try (FileWriter writer = new FileWriter(FILE_SALVATAGGIO)) {
            gson.toJson(new StatoGioco(giocatore), writer);
            System.out.println("Partita salvata con successo!");

        } catch (IOException e) {
            System.out.println("Errore nel salvataggio della partita: " + e.getMessage());
        }
    }

    public static StatoGioco caricaPartita() {

        try (FileReader reader = new FileReader(FILE_SALVATAGGIO)) {
            return gson.fromJson(reader, StatoGioco.class);

        } catch (IOException e) {
            System.out.println("Nessun salvataggio trovato. Inizia una nuova partita.");
            return null;
        }
    }
}
