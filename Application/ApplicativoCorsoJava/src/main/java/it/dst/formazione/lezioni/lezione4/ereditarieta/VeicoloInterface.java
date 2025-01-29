package it.dst.formazione.lezioni.lezione4.ereditarieta;

public interface VeicoloInterface {

    default void avvia() {
        System.out.println("Il veicolo sta partendo.");
    }
}
