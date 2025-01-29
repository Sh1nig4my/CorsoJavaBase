package it.dst.formazione.lezione4.astrazione;

public class esempio_astrazione {

    public static void example_cerchio() {
        Cerchio cerchio = new Cerchio(5.0);
        cerchio.setColore("Rosso");
        System.out.println("Colore: " + cerchio.getColore());
        System.out.println("Area del cerchio: " + cerchio.calcolaArea());
    }
}
