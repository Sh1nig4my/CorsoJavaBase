package it.dst.formazione.esercitazioni.esercitazione3.result.max;

import java.sql.SQLException;
import java.util.List;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;
import it.dst.formazione.esercitazioni.esercitazione3.result.max.DAOManager.Table;

public class CRUDBibliotecaMax implements BibliotecaInterface{
		private LibriDAO libriDAO= null;

		public CRUDBibliotecaMax() {
			DAOManager daoManager=new DAOManager();
			
			try {
				
				this.libriDAO= (LibriDAO) daoManager.getDAO(Table.LIBRO);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	    @Override
	    public String testInserimento() {
	    	return libriDAO.testInserimento();
	    }

	    @Override
	    public List<Libro> testSelezione() {
	    	return libriDAO.testSelezione();
	    }

	    @Override
	    public List<Libro> testSelezioneFiltrata(boolean disponibile) {
	    	return libriDAO.testSelezioneFiltrata(disponibile);
	    }

	    @Override
	    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
	    	return libriDAO.testAggiornamentoDisponibilita(idLibro, disponibile);
	    }

	    @Override
	    public String testEliminazione(int idLibro) {
	    	return libriDAO.testEliminazione(idLibro);
	    }

	    @Override
	    public String createTableLibro() {
	    	return libriDAO.createTableLibro();
	    }
}
