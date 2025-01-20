package it.dst.formazione.lezione3;

import java.util.Scanner;

public class InputOutput {

    public static void test_inputoutput() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il tuo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci la tua età: ");
        int eta = scanner.nextInt();

        System.out.println("Ciao, " + nome + ". Hai " + eta + " anni.");
    }
}
