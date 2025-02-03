package it.dst.formazione.esercitazioni.esercitazione2.emanueleienna.advanced.punto3;

import it.dst.formazione.esercitazioni.esercitazione2.emanueleienna.advanced.punto2.GiocatoreConInventario;
import it.dst.formazione.esercitazioni.esercitazione2.emanueleienna.advanced.punto2.Inventario;

public class StatoGioco {

    String nomeGiocatore;
    int vita;
    int ossigeno;
    Inventario inventario;

    public StatoGioco(GiocatoreConInventario giocatore) {
        this.nomeGiocatore = giocatore.getNome();
        this.vita = giocatore.getVita();
        this.ossigeno = giocatore.getOssigeno();
        this.inventario = new Inventario(giocatore.getInventario().getOggetti());
    }
}
