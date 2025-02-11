package id.dst.game.service.giocatore;

import id.dst.game.entity.giocatore.Giocatore;
import id.dst.game.repository.giocatore.GiocatoreDAO;
import id.dst.game.tools.ResultEnum;


import java.sql.SQLException;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


public class GiocatoreService {

    private static final Logger log = Logger.getLogger(GiocatoreService.class.getName());
    private final GiocatoreDAO giocatoreDAO = new GiocatoreDAO();

    /**
     * Crea la tabella per i giocatori nel database.
     * @return ResultEnum.OK se la creazione ha successo, ResultEnum.KO altrimenti.
     */
    public String createTable() {
        try {
            return giocatoreDAO.createTable();
        } catch (SQLException e) {
            log.warning("Errore nella creazione della tabella: " + e.getMessage());
            return ResultEnum.KO.getResultEnum();
        }
    }

    /**
     * Inserisce un nuovo giocatore nel database.
     * @param giocatore L'oggetto Giocatore da inserire.
     * @return ResultEnum.OK se l'inserimento ha successo, ResultEnum.KO altrimenti.
     */
    public String insertGiocatore(Giocatore giocatore) {
        try {
            return giocatoreDAO.insertGiocatore(giocatore);
        } catch (SQLException e) {
            log.warning("Errore nell'inserimento del giocatore: " + e.getMessage());
            return ResultEnum.KO.getResultEnum();
        }
    }

    /**
     * Aggiorna un giocatore nel database in base al suo ID.
     * @param id ID del giocatore da aggiornare.
     * @param giocatore Nuovi dati del giocatore.
     * @return ResultEnum.OK se l'aggiornamento ha successo, ResultEnum.KO altrimenti.
     */
    public String updateGiocatoreById(Integer id, Giocatore giocatore) {
        try {
            return giocatoreDAO.updateGiocatoreById(id, giocatore);
        } catch (SQLException e) {
            log.warning("Errore nell'aggiornamento del giocatore con ID " + id + ": " + e.getMessage());
            return ResultEnum.KO.getResultEnum();
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
            return list; // Ritorna una lista vuota in caso di errore
        }

        return list;
    }

    /**
     * Cancella un giocatore dal database tramite ID.
     * @param id ID del giocatore da eliminare.
     * @return ResultEnum.OK se l'eliminazione ha successo, ResultEnum.KO altrimenti.
     */
    public String cancellaGiocatoreById(Integer id) {
        try {
            return giocatoreDAO.cancellaGiocatoreById(id);
        } catch (SQLException e) {
            log.warning("Errore nella cancellazione del giocatore con ID " + id + ": " + e.getMessage());
            return ResultEnum.KO.getResultEnum();
        }
    }

}
