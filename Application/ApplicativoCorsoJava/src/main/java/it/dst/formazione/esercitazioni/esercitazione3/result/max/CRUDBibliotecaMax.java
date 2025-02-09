package it.dst.formazione.esercitazioni.esercitazione3.result.max;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;
import it.dst.formazione.esercitazioni.esercitazione3.result.max.DAOManager.Table;
import it.dst.formazione.tools.InputOutputConst;

public class CRUDBibliotecaMax implements BibliotecaInterface{
		private LibriDAO libriDAO= null;
		private DAOManager daoManager=null;

		public CRUDBibliotecaMax() {
			daoManager=new DAOManager();
			
			try {
				
				this.libriDAO= (LibriDAO) daoManager.getDAO(Table.LIBRO);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	    @Override
	    public String testInserimento() {
	    	
	    	try {
	    		
	    		return libriDAO.testInserimento(InputOutputConst.libri);
	    	
		    } catch (SQLException e) {
		        System.err.println("[Test Inserimento] ERRORE - " + e.getMessage());
		    }
	    	
	    	return LibriDAO.resultStringKO;
	    }

	    @Override
	    public List<Libro> testSelezione() {
	    	try {
	    		
				return libriDAO.testSelezione();
				
			} catch (SQLException e) {
				System.err.println("[Test Selezione] ERRORE - " + e.getMessage());
			}
	    	
	    	return new ArrayList<Libro>();
	    }

	    @Override
	    public List<Libro> testSelezioneFiltrata(boolean disponibile) {
	    	try {
	    		
				return libriDAO.testSelezioneFiltrata(disponibile);

	    	} catch (SQLException e) {
				System.err.println("[Test Selezione Filtrata] ERRORE - " + e.getMessage());
			}
	    	
	    	return new ArrayList<Libro>();
	    }

	    @Override
	    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
	    	try {
	    		
				return libriDAO.testAggiornamentoDisponibilita(idLibro, disponibile);
			
	    	} catch (SQLException e) {
				System.err.println("[Test Aggiornamento Disponibilita] ERRORE - " + e.getMessage());
			}
	    	return LibriDAO.resultStringKO;
	    }

	    @Override
	    public String testEliminazione(int idLibro) {
	    	try {
	    		
				return libriDAO.testEliminazione(idLibro);
				
			} catch (SQLException e) {
				System.err.println("[Test Eliminazione] ERRORE - " + e.getMessage());
			}
	    	
	    	return LibriDAO.resultStringKO;
	    }

	    @Override
	    public String createTableLibro() {
	    	try {
	    		
				return libriDAO.createTableLibro();
				
			} catch (SQLException e) {
				System.err.println("[Test Create Table] ERRORE - " + e.getMessage());
			}
	    	
	    	return LibriDAO.resultStringKO;
	    }
	    
	    public void closeConnection() {
	    		
    		try {
    			if (daoManager!=null && !daoManager.isClosed())  {		
    				daoManager.close();
    			}	
    		} catch (SQLException e) {
				System.err.println("[Test Close Connection] ERRORE - " + e.getMessage());
    		}
	    	
	    }
}
