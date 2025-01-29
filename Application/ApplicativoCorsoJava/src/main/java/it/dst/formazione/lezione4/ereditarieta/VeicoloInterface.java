package it.dst.formazione.lezione4.ereditarieta;

public interface VeicoloInterface {

    default void avvia() {
        System.out.println("Il veicolo sta partendo.");
    }
}
