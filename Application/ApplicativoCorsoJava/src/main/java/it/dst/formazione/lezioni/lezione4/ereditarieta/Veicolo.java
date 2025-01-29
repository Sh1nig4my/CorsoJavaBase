package it.dst.formazione.lezioni.lezione4.ereditarieta;

public class Veicolo implements VeicoloInterface {
    String tipo;

    public void accendi() {
        System.out.println("Il veicolo è acceso.");
    }
}
