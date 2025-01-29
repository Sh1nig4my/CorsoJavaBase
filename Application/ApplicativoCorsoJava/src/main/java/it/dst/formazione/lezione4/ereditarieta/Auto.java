package it.dst.formazione.lezione4.ereditarieta;

public class Auto extends Veicolo {
    int numeroPorte;

    public void mostraDettagli() {
        System.out.println("Tipo: " + tipo + ", Numero porte: " + numeroPorte);
    }
}
