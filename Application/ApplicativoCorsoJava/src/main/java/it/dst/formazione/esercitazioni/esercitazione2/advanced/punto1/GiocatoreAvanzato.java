package it.dst.formazione.esercitazioni.esercitazione2.advanced.punto1;

import it.dst.formazione.esercitazioni.esercitazione2.gioco.Giocatore;

public class GiocatoreAvanzato extends Giocatore {
    private int ossigeno;

    public GiocatoreAvanzato(String nome, int vita, int anni, int ossigeno) {
        super(nome, vita, anni);
        this.ossigeno = ossigeno;
    }

    public void consumaOssigeno(int quantita) {
        this.ossigeno -= quantita;
        System.out.println("Ossigeno rimanente: " + this.ossigeno);
        if (this.ossigeno <= 0) {
            System.out.println("Sei rimasto senza ossigeno! Game Over.");
            System.exit(0);
        }
    }

    public int getOssigeno() {
        return ossigeno;
    }
}
