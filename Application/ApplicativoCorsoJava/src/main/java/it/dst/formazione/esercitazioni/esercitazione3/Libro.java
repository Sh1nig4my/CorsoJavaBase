package it.dst.formazione.esercitazioni.esercitazione3;

public class Libro {

    private int id;

    private final String titolo;
    private final String autore;
    private final int annoPubblicazione;
    private boolean disponibile;

    public Libro(int id, String titolo, String autore, int annoPubblicazione, boolean disponibile) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.disponibile = disponibile;
    }

    public Libro(String titolo, String autore, int annoPubblicazione, boolean disponibile) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.disponibile = disponibile;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", disponibile=" + disponibile +
                '}';
    }

}
