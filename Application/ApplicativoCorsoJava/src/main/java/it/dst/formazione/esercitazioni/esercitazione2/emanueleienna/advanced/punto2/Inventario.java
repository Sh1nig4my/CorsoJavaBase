package it.dst.formazione.esercitazioni.esercitazione2.emanueleienna.advanced.punto2;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<String> oggetti;



    public Inventario() {
        this.oggetti = new ArrayList<>();
    }

    public Inventario(List<String> oggetti) {
        this.oggetti = oggetti;
    }



    public List<String> getOggetti() {
        return oggetti;
    }

    public void aggiungiOggetto(String oggetto) {
        oggetti.add(oggetto);
        System.out.println("Oggetto aggiunto: " + oggetto);
    }

    public void rimuoviOggetto(String oggetto) {
        if (oggetti.contains(oggetto)) {
            oggetti.remove(oggetto);
            System.out.println("Hai usato: " + oggetto);
        } else {
            System.out.println("L'oggetto non è presente nell'inventario.");
        }
    }

    public void mostraInventario() {
        System.out.println("Inventario: " + oggetti);
    }
}
