package it.dst.formazione.esercitazione1;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Soluzioni_esercitazione {

    public static void soluzione_esercitazione_1() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeri = new ArrayList<>();

        // Richiedi all'utente di inserire i numeri
        System.out.println("Inserisci i numeri interi separati da spazio: ");
        while (true) {
            try {
                String input = scanner.nextLine();
                String[] numeriInput = input.split(" ");
                for (String numero : numeriInput) {
                    numeri.add(Integer.parseInt(numero));
                }
                break; // Esci dal ciclo se l'input è valido
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Inserisci solo numeri interi separati da spazio: ");
                numeri.clear(); // Resetta la lista per nuovi input
            }
        }

        // Classifica i numeri come Pari o Dispari
        Map<String, List<Integer>> classificazione = new HashMap<>();
        classificazione.put("Pari", new ArrayList<>());
        classificazione.put("Dispari", new ArrayList<>());

        for (int numero : numeri) {
            if (numero % 2 == 0) {
                classificazione.get("Pari").add(numero);
            } else {
                classificazione.get("Dispari").add(numero);
            }
        }

        // Calcola il numero più grande, il più piccolo e la media
        int numeroPiuGrande = Collections.max(numeri);
        int numeroPiuPiccolo = Collections.min(numeri);
        double media = numeri.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        // Prepara i dati per il salvataggio
        Map<String, Object> analisi = new HashMap<>();
        analisi.put("numeroPiuGrande", numeroPiuGrande);
        analisi.put("numeroPiuPiccolo", numeroPiuPiccolo);
        analisi.put("media", media);

        Map<String, Object> datiAnalizzati = new HashMap<>();
        datiAnalizzati.put("numeriOriginali", numeri);
        datiAnalizzati.put("analisi", analisi);
        datiAnalizzati.put("classificazione", classificazione);

        // Salva i dati in un file JSON
        try (FileWriter writer = new FileWriter("risultati.json")) {
            Gson gson = new Gson();
            gson.toJson(datiAnalizzati, writer);
            System.out.println("Dati salvati con successo in risultati.json");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file JSON: " + e.getMessage());
        }

        // Mostra le statistiche a console
        System.out.println("Numero più grande: " + numeroPiuGrande);
        System.out.println("Numero più piccolo: " + numeroPiuPiccolo);
        System.out.printf("Media: %.2f%n", media);
        System.out.println("Numeri pari: " + classificazione.get("Pari"));
        System.out.println("Numeri dispari: " + classificazione.get("Dispari"));
    }



    /* ADVANCED */

    public static Map<String, List<Integer>> classifyNumbers(List<Integer> numbers) {
        Map<String, List<Integer>> result = new HashMap<>();
        result.put("Pari", new ArrayList<>());
        result.put("Dispari", new ArrayList<>());

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                result.get("Pari").add(number);
            } else {
                result.get("Dispari").add(number);
            }
        }
        return result;
    }

    public static boolean isValidInput(String input) {
        String regex = "^-?\\d+(\\s-?\\d+)*$";
        return Pattern.matches(regex, input);
    }

    public static int calculateSum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

}
