package it.dst.formazione.esercitazioni.esercitazione3.result.max;

import static it.dst.formazione.tools.InputOutputConst.query;
import static it.dst.formazione.tools.InputOutputConst.resultString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.dst.formazione.esercitazioni.esercitazione3.Libro;

public class LibriDAO extends GenericDAO {
	
	public static final String resultStringKO 		= "KO";
	private final String queryInsert				= "INSERT INTO libri (titolo, autore, anno_pubblicazione, disponibile)"
															  + " VALUES (?, ?, ?, ?)";
	
	private final String querySelectLibriDisponibili= "SELECT * FROM libri "
														    + " WHERE disponibile = ?";
	
	private final String querySelectAll				= "SELECT * FROM libri";
	private final String queryAggiornaDisponibili   = "UPDATE libri SET disponibile = ? "
															    + " WHERE id = ?";
	
	private final String queryDeleteByID			= "DELETE FROM libri "
															    + " WHERE id = ?";
	
	
	public LibriDAO(Connection conn) throws SQLException{
		
        super(conn, "Libri");
    }
	
    public String testInserimento(List<Libro> libri) throws SQLException{

        PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(queryInsert);
			
			for (Libro libro : libri) {
				
				pstmt.setString(1, libro.getTitolo());
				pstmt.setString(2, libro.getAutore());
				pstmt.setInt(3, libro.getAnnoPubblicazione());
				pstmt.setBoolean(4, libro.isDisponibile());
				pstmt.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
        System.out.println("[Test Inserimento] OK - Righe inserite ");
        return resultString;
    }

	public List<Libro> testSelezione() throws SQLException{
		List<Libro> libri = new ArrayList<>();

		PreparedStatement pstmt = conn.prepareStatement(querySelectAll);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Libro libro = new Libro(rs.getInt("id"), 
									rs.getString("titolo"), 
									rs.getString("autore"),
									rs.getInt("anno_pubblicazione"), 
									rs.getBoolean("disponibile"));
			libri.add(libro);
		}

		return libri;
	}

    public List<Libro> testSelezioneFiltrata(boolean disponibile) throws SQLException{
        List<Libro> libri = new ArrayList<>();

        PreparedStatement pstmt = conn.prepareStatement(querySelectLibriDisponibili);

        pstmt.setBoolean(1, disponibile);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Libro libro = new Libro(
                    rs.getInt("id"),
                    rs.getString("titolo"),
                    rs.getString("autore"),
                    rs.getInt("anno_pubblicazione"),
                    rs.getBoolean("disponibile")
            );
            libri.add(libro);
        }

        return libri;
    }

    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) throws SQLException{
            PreparedStatement pstmt = conn.prepareStatement(queryAggiornaDisponibili);

            pstmt.setBoolean(1, disponibile);
            pstmt.setInt(2, idLibro);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println("\n[Test Aggiornamento] OK - Righe aggiornate: " + rowsAffected);

        

        return resultString;
    }

    public String testEliminazione(int idLibro) throws SQLException{

            PreparedStatement pstmt = conn.prepareStatement(queryDeleteByID);

            pstmt.setInt(1, idLibro);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println("\n[Test Eliminazione] OK - Righe eliminate: " + rowsAffected);


        return resultString;
    }

    public String createTableLibro() throws SQLException{
        try {
             Statement stmt = conn.createStatement();

            stmt.executeUpdate(query);
            System.out.println("Tabella 'libri' creata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nella creazione della tabella: " + e.getMessage());
        }

        return resultString;
    }
}
