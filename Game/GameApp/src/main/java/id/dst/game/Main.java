package id.dst.game;

import id.dst.game.service.giocatore.GiocatoreService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        GiocatoreService repoGiocatore = new GiocatoreService();
        // 1. Creazione della tabella Giocatori
        System.out.println("Creazione della tabella...");
        repoGiocatore.initialize();
    }

}