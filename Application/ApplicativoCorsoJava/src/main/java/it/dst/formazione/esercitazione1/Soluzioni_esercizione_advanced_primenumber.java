package it.dst.formazione.esercitazione1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Soluzioni_esercizione_advanced_primenumber {

    public static void processNumbers() {
        try {
            String inputFile = "C:\\DSTech\\project\\corso_formazione\\repo_dev_corso_java\\repo_corso_java\\Application\\ApplicativoCorsoJava\\src\\main\\java\\it\\dst\\formazione\\esercitazione1\\numeri_input.json";
            String outputFile = "C:\\DSTech\\project\\corso_formazione\\repo_dev_corso_java\\repo_corso_java\\Application\\ApplicativoCorsoJava\\src\\main\\java\\it\\dst\\formazione\\esercitazione1\\numeri_primi_output.json";

            // Leggi i numeri dal file JSON di input
            List<Integer> numbers = readNumbersFromJson(inputFile);

            // Filtra i numeri primi
            List<Integer> primeNumbers = filterPrimes(numbers);

            // Salva i numeri primi nel file JSON di output
            savePrimesToJson(primeNumbers, outputFile);

            // Stampa i risultati
            System.out.println("Numeri primi salvati: " + primeNumbers);

        } catch (IOException e) {
            System.err.println("Errore durante la lettura/scrittura dei file: " + e.getMessage());
        }
    }

    private static List<Integer> readNumbersFromJson(String filePath) throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<List<Integer>>() {}.getType();
            System.out.println("Lettura da file");
            return gson.fromJson(reader, listType);
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.println(number + ": NON valido!");
                return false;
            }
        }

        System.out.println(number + ": Valido!");
        return true;
    }

    private static List<Integer> filterPrimes(List<Integer> numbers) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }

        System.out.println("Termine Filtro numeri primi!");
        return primeNumbers;
    }

    private static void savePrimesToJson(List<Integer> primeNumbers, String outputFilePath) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("START scrittura output!");
        try (Writer writer = new FileWriter(outputFilePath)) {
            gson.toJson(primeNumbers, writer);
        }
        System.out.println("END scrittura output!");
    }

}
