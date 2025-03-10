package it.dst.formazione.esercitazioni.esercitazione3;

import static it.dst.formazione.tools.InputOutputConst.resultString;
import java.util.List;
import it.dst.formazione.esercitazioni.esercitazione3.result.max.CRUDBibliotecaMax;
import it.dst.formazione.esercitazioni.esercitazione3.result.max.DAOManager;

public class TestBiblioteca {

    public static void main(String[] args) {
    	DAOManager daoManager = new DAOManager();
    	daoManager.getConnection();
    	CRUDBibliotecaMax crud = new CRUDBibliotecaMax(daoManager);
        String result;

        result = crud.createTableLibro();
        if(result.equalsIgnoreCase(resultString)) {
            System.out.println("\n1. PASS");
        }

        result = crud.testInserimento();
        if(result.equalsIgnoreCase(resultString)) {
            System.out.println("\n2. PASS");
        }

        List<Libro> tuttiLibri = crud.testSelezione();
        if (!tuttiLibri.isEmpty()) {
            System.out.println("\n3. PASS");
            System.out.println("\nLibri presenti in biblioteca:");
            System.out.println("\nNumero libri disponibili: " + tuttiLibri.size());
            tuttiLibri.forEach(System.out::println);

        }

        List<Libro> libriDisponibili = crud.testSelezioneFiltrata(true);
        if (!libriDisponibili.isEmpty()) {
            System.out.println("\n4. PASS");
            System.out.println("\nLibri disponibili:");
            System.out.println("\nNumero libri disponibili: " + libriDisponibili.size());
            libriDisponibili.forEach(System.out::println);
        }


        result = crud.testAggiornamentoDisponibilita(1, false);
        if(result.equalsIgnoreCase(resultString)) {
            System.out.println("\n5. PASS");
        }

        result = crud.testEliminazione(2);
        if(result.equalsIgnoreCase(resultString)) {
            System.out.println("\n6. PASS");
        }
        
        daoManager.closeConnection();
    }

}
