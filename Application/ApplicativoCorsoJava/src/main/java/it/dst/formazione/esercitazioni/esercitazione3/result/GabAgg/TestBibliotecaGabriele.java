package it.dst.formazione.esercitazioni.esercitazione3.result.GabAgg;

import it.dst.formazione.esercitazioni.esercitazione3.Libro;

import java.sql.SQLException;
import java.util.List;

import static it.dst.formazione.tools.InputOutputConst.resultString;

public class TestBibliotecaGabriele {

    public static void main(String[] args) {


        GabrieleAggLibreriaTest testGab = new GabrieleAggLibreriaTest();

        String result;
        //testo connessione
        try {
            GabrieleAggLibreriaTest.testConnessione();

            //creo tabelle se non esistono
            result = testGab.createTableLibro();
            if(result.equalsIgnoreCase(resultString)) {
                System.out.println("\n1. PASS");
                System.out.println("Tabelle create con successo");
            }

            //Inserisco un libro
            result = testGab.testInserimentoLibriDaInputOutputConst();
            if(result.equalsIgnoreCase(resultString)) {
                System.out.println("\n2. PASS");
                System.out.println("Dati inseriti con successo (da interfaccia InputOutputConst)");
            }


            //Inserisco un libro SINGOLO FISSO
            result = testGab.testInserimento();
            if(result.equalsIgnoreCase(resultString)) {
                System.out.println("\n2.5 PASS");
                System.out.println("Dato singolo inserito con successo");
            }


            //test + stampa lista libri con select *
            List<Libro> tuttiLibri = testGab.testSelezione();
            if (!tuttiLibri.isEmpty()) {
                System.out.println("\n3. PASS");
                System.out.println("\nLibri presenti in biblioteca:");
                System.out.println("\nNumero libri disponibili: " + tuttiLibri.size());
                tuttiLibri.forEach(System.out::println);
            }

            System.out.println("______________________________________");

            //Stampo con select * libri dove la disponibilità è true.
            List<Libro> libriDisponibili = testGab.testSelezioneFiltrata(true);
            if (!libriDisponibili.isEmpty()) {
                System.out.println("\n4. PASS");
                System.out.println("\nLibri disponibili:");
                System.out.println("\nNumero libri disponibili: " + libriDisponibili.size());
                libriDisponibili.forEach(System.out::println);
            }

            System.out.println("______________________________________");

            //Aggiorno disponibilità di un libro by id
            result = testGab.testAggiornamentoDisponibilita(1, false);
            if(result.equalsIgnoreCase(resultString)) {
                System.out.println("\n5. PASS");
            }

            //BONUS 5.5 TRANSIZIONE (SEMPRE IL PRIMO RECORD PER CONFRONTO)
            List<Libro> libriAggiornati = testGab.testAggiornamentoESelezione(1, false);
            if (!libriAggiornati.isEmpty()) {
                System.out.println("\n5.5 PASS");
                System.out.println("\nNumero di libri aggiornati: " + libriAggiornati.size());
                libriAggiornati.forEach(System.out::println);
            }


            //elimino libro by id
            result = testGab.testEliminazione(4);
            if(result.equalsIgnoreCase(resultString)) {
                System.out.println("\n6. PASS");
            } else {
                System.out.println("6) Id non presente oppure eliminato nel test precedente, provare altro id");
            }
            System.out.println(" ");
            //Stampa per vedere se il libro è stato effettivamente eliminato
            tuttiLibri.forEach(System.out::println);



        } catch (SQLException exception){
            System.out.println("Messaggio: " + exception.getMessage());
            System.out.println("Codice Errore: " + exception.getErrorCode());
            System.out.println("Stato SQL: " + exception.getSQLState());
        }




        // INFO: Esercitzione molto buona. Non c'è nulla d modificare!
    }

}
