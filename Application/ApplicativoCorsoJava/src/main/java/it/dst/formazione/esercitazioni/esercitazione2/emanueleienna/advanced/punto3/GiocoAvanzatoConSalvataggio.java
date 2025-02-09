package it.dst.formazione.esercitazioni.esercitazione2.emanueleienna.advanced.punto3;

import it.dst.formazione.esercitazioni.esercitazione2.emanueleienna.advanced.punto2.GiocatoreConInventario;

// Test del salvataggio/caricamento nel main
public class GiocoAvanzatoConSalvataggio {

    public static void main(String[] args) {
        giocoConSalvataggio();
    }

    public static void giocoConSalvataggio() {

        GiocatoreConInventario giocatore = new GiocatoreConInventario("Pirata", 100, 35, 50);
        giocatore.getInventario().aggiungiOggetto("Chiave elettronica");

        // Salvataggio
        GestoreSalvataggio.salvaPartita(giocatore);

        // Caricamento
        StatoGioco stato = GestoreSalvataggio.caricaPartita();
        if (stato != null) {
            System.out.println("Partita caricata: " + stato.nomeGiocatore + " - Vita: " + stato.vita + " - Ossigeno: " + stato.ossigeno);
            System.out.println(stato.inventario.getOggetti());
        }
    }
}
