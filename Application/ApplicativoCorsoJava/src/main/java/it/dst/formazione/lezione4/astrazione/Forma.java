package it.dst.formazione.lezione4.astrazione;

abstract class Forma {

    String colore;

    // Metodo astratto
    abstract double calcolaArea();

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }
}
