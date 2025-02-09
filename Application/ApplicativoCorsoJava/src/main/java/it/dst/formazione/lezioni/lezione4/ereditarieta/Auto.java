package it.dst.formazione.lezioni.lezione4.ereditarieta;

public class Auto extends Veicolo {

    int numeroPorte;

    public int getNumeroPorte() {
        return numeroPorte;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    public void mostraDettagli() {
        System.out.println("Tipo: " + tipo + ", Numero porte: " + numeroPorte);
    }
}
