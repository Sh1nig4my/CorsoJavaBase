package it.dst.formazione.lezione_8.esercizio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GiuseppeLongo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // richiesta dallo scanner inserimento dati

        System.out.println("Inserisci 'putcall' per calcolare le top 3 PUT/CALL oppure 'animali' per calcolare la lunghezza media dei nomi degli animali:");
        String scelta = scanner.nextLine(); // Lettura input utente

        try {
            if ("putcall".equalsIgnoreCase(scelta)) {

                // calcolo per PUT e CALL

                calcolaTopPutCall();
            } else if ("animali".equalsIgnoreCase(scelta)) {

                // calcolo per la lunghezza media degli animali

                calcolaLunghezzaMediaAnimali();
            } else {
                System.out.println("Argomento non valido. Usa 'putcall' o 'animali'.");
            }
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close(); // Chiude lo scanner alla fine del programma
        }
    }

    // Calcola e stampa le top 3 PUT e CALL

    private static void calcolaTopPutCall() throws Exception {

        // Lettura del file JSON

        String percorsoFile = "C:\\Users\\peps2\\Downloads\\data (1).json";
        String jsonData = new String(Files.readAllBytes(Paths.get(percorsoFile)));

        // Conversione del JSON in una lista di oggetti Opzione

        ObjectMapper mapper = new ObjectMapper();
        List<Opzione> opzioni = mapper.readValue(jsonData, new TypeReference<List<Opzione>>() {});

        // 3 PUT più alti

        List<Opzione> topPut = opzioni.stream()
                .filter(op -> parseDoubleSafe(op.getPut()).isPresent()) // Filtriamo solo valori validi
                .sorted((op1, op2) -> Double.compare(
                        parseDoubleSafe(op2.getPut()).orElse(0.0),
                        parseDoubleSafe(op1.getPut()).orElse(0.0)
                ))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top 3 PUT più alti:");
        topPut.forEach(op -> System.out.println(formatOpzione(op)));

        // 3 CALL più alti

        List<Opzione> topCall = opzioni.stream()
                .filter(op -> parseDoubleSafe(op.getCall()).isPresent()) // Filtra solo valori validi
                .sorted((op1, op2) -> Double.compare(
                        parseDoubleSafe(op2.getCall()).orElse(0.0),
                        parseDoubleSafe(op1.getCall()).orElse(0.0)
                ))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("\nTop 3 CALL più alti:");
        topCall.forEach(op -> System.out.println(formatOpzione(op)));
    }

    // Calcola e stampa la lunghezza media dei nomi degli animali

    private static void calcolaLunghezzaMediaAnimali() {
        List<Optional<String>> animaliOptionalList = List.of(
                Optional.of("Leone"),
                Optional.empty(),
                Optional.of("Gatto"),
                Optional.empty(),
                Optional.of("Coccodrillo")
        );

        double lunghezzaMedia = animaliOptionalList.stream()
                .flatMap(Optional::stream)
                .mapToInt(String::length)
                .average()
                .orElse(0.0);

        System.out.println("\nLunghezza media dei nomi degli animali: " + lunghezzaMedia);
    }

    // Metodo per formattare l'output

    private static String formatOpzione(Opzione op) {
        return String.format("Value: %d, Call: %s, Put: %s",
                op.getValue(),
                op.getCall(),
                op.getPut());
    }

    // Converte stringhe in double e rimuove punteggiatura

    private static Optional<Double> parseDoubleSafe(String value) {
        if (value == null || value.equals("-")) return Optional.empty();
        try {
            String cleanedValue = value.replaceAll("[^0-9]", ""); // Rimuove caratteri non numerici
            return Optional.of(Double.parseDouble(cleanedValue));
        } catch (NumberFormatException e) {
            return Optional.empty(); // Restituisce Optional vuoto se la conversione fallisce
        }
    }
}

// Classe Opzione

class Opzione {
    private int value;
    private String call;
    private String put;

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
    public String getCall() { return call; }
    public void setCall(String call) { this.call = call; }
    public String getPut() { return put; }
    public void setPut(String put) { this.put = put; }
}
