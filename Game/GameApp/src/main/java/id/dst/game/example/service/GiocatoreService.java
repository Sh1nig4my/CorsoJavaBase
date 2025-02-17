package id.dst.game.example.service;

import id.dst.game.example.dao.GiocatoreDAO;
import id.dst.game.example.entity.Giocatore;

import java.sql.SQLException;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


public class GiocatoreService {

    private static final Logger log = Logger.getLogger(GiocatoreService.class.getName());
    private final GiocatoreDAO giocatoreDAO = new GiocatoreDAO();

    /**
     * Crea la tabella per i giocatori nel database
     */
    public Boolean createTable() {
        try {
            return giocatoreDAO.createTable();
        } catch (SQLException e) {
            log.warning("Errore nella creazione della tabella: " + e.getMessage());
            return false;
        }
    }

    /**
     * Inserisce un nuovo giocatore nel database.
     * @param giocatore L'oggetto Giocatore da inserire.
     */
    public Boolean insertGiocatore(Giocatore giocatore) {
        try {
            return giocatoreDAO.insertGiocatore(giocatore);
        } catch (SQLException e) {
            log.warning("Errore nell'inserimento del giocatore: " + e.getMessage());
            return false;
        }
    }

    /**
     * Aggiorna un giocatore nel database in base al suo ID.
     * @param id ID del giocatore da aggiornare.
     * @param giocatore Nuovi dati del giocatore.
     */
    public Boolean updateGiocatoreById(Integer id, Giocatore giocatore) {
        try {
            return  giocatoreDAO.updateGiocatoreById(id, giocatore);
        } catch (SQLException e) {
            log.warning("Errore nell'aggiornamento del giocatore con ID " + id + ": " + e.getMessage());
            return false;
        }
    }

    /**
     * Seleziona un giocatore dal database tramite ID.
     * @param id ID del giocatore da recuperare.
     * @return Optional contenente il giocatore se trovato, altrimenti Optional vuoto.
     */
    public Optional<Giocatore> selectGiocatoreById(Integer id) {
        Optional<Giocatore> player = Optional.empty();
        try {
            player = giocatoreDAO.selectGiocatoreById(id);
        } catch (SQLException e) {
            log.warning("Errore nella selezione del giocatore con ID " + id + ": " + e.getMessage());
        }

        return player;
    }

    /**
     * Seleziona tutti i giocatori presenti nel database.
     * @return Lista di giocatori se trovati, altrimenti una lista vuota.
     */
    public List<Giocatore> selectAllGiocatore() {
        List<Giocatore> list = List.of();
        try {
            list = giocatoreDAO.selectAllGiocatore();
        } catch (SQLException e) {
            log.warning("Errore nella selezione di tutti i giocatori: " + e.getMessage());
        }
        return list;
    }

    /**
     * Cancella un giocatore dal database tramite ID.
     * @param id ID del giocatore da eliminare.
     */
    public Boolean cancellaGiocatoreById(Integer id) {
        try {
            return giocatoreDAO.cancellaGiocatoreById(id);
        } catch (SQLException e) {
            log.warning("Errore nella cancellazione del giocatore con ID " + id + ": " + e.getMessage());
            return false;
        }
    }

}
