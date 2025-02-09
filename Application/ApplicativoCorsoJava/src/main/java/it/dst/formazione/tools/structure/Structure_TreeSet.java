package it.dst.formazione.tools.structure;

import java.util.Scanner;
import java.util.TreeSet;

public class Structure_TreeSet {

    public static void main(String[] args) {
        // Creazione del TreeSet
        TreeSet<String> words = new TreeSet<>();

        // Lettura dell'input da parte dell'utente
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci parole (digita 'stop' per terminare):");

        while (true) {
            String word = scanner.nextLine();
            if (word.equalsIgnoreCase("stop")) {
                break;
            }
            words.add(word);
        }

        // Stampa delle parole in ordine decrescente
        System.out.println("Parole in ordine decrescente:");
        for (String word : words.descendingSet()) {
            System.out.println(word);
        }

        scanner.close();
    }

}
