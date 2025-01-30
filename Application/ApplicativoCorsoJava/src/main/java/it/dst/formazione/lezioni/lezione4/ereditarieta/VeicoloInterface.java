package it.dst.formazione.lezioni.lezione4.ereditarieta;

public interface VeicoloInterface {

    String marca = "Test_Java";

    default void avvia() {
        System.out.println("Il veicolo sta partendo.");
    }
}
