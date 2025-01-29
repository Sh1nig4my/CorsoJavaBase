package it.dst.formazione.lezioni.lezione4.ereditarieta;

public class Auto extends Veicolo {
    int numeroPorte;

    public void mostraDettagli() {
        System.out.println("Tipo: " + tipo + ", Numero porte: " + numeroPorte);
    }
}
