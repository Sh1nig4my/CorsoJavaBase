package it.dst.formazione.lezione3;

import java.util.Random;

public class Iterazioni {

    public static void test_iterazione_while() {

        // Esempio: Ciclo while
        System.out.println("\nEsempio: Ciclo while");
        int numero = 10; // Valore di partenza
        int somma = 0;

        System.out.println("Somma dei numeri decrementando da 10 a 0:");
        while (numero > 0) {
            somma += numero;
            System.out.println(somma);
            numero--;
        }
        System.out.println("Somma totale: " + somma);


        // Esempio: Ciclo do-while
        System.out.println("\nEsempio: Ciclo do-while");
        Random random = new Random();
        int numeroDaIndovinare = random.nextInt(100) + 1;
        System.out.println("Numero Random: " + numeroDaIndovinare);
        int tentativo = -1;

        System.out.println("Indovina il numero (tra 1 e 100):");
        do {
            tentativo = (int) (Math.random() * 100) + 1; // Generazione casuale simulata
            System.out.println("Tentativo simulato: " + tentativo);

            if (tentativo > numeroDaIndovinare) {
                System.out.println("Troppo alto! Riprova.");
            } else if (tentativo < numeroDaIndovinare) {
                System.out.println("Troppo basso! Riprova.");
            }
        } while (tentativo != numeroDaIndovinare);

        System.out.println("Complimenti! Hai indovinato il numero: " + numeroDaIndovinare);

    }

    public static void test_iterazione_for() {

        // Esempio: Ciclo for
        System.out.println("Esempio: Ciclo for");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iterazione: " + i);
        }

        // Esempio: Cicli annidati
        System.out.println("\nEsempio: Cicli annidati");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.println("Ciclo esterno: " + i + ", Ciclo interno: " + j);
            }
        }

    }

}
