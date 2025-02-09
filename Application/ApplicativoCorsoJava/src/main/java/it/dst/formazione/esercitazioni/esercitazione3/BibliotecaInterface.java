package it.dst.formazione.esercitazioni.esercitazione3;

import java.util.List;

public interface BibliotecaInterface {

    String createTableLibro();
    String testInserimento();
    List<Libro> testSelezione();
    List<Libro> testSelezioneFiltrata(boolean disponibile);
    String testAggiornamentoDisponibilita(int idLibro, boolean disponibile);
    String testEliminazione(int idLibro);

}
