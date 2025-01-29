package it.dst.formazione.lezione7.staticinterface;

public class MathUtils {

    public static class StaticMethodExample implements MathUtilsInterface {

        public static void lezione7_math_utils() {
            // Utilizzo del metodo statico dell'interfaccia
            int sum = MathUtils.add(3, 7);
            int product = MathUtils.multiply(3, 7);

            // Stampa dei risultati
            System.out.println("Somma: " + sum);
            System.out.println("Prodotto: " + product);
        }
    }
}
