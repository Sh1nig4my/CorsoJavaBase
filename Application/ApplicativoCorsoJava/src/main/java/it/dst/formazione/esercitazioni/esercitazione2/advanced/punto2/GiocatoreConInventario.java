package it.dst.formazione.esercitazioni.esercitazione2.advanced.punto2;

import it.dst.formazione.esercitazioni.esercitazione2.advanced.punto1.GiocatoreAvanzato;

import java.util.List;

// Modifica nel GiocatoreAvanzato per includere l'inventario
public class GiocatoreConInventario extends GiocatoreAvanzato {

    public Inventario inventario;

    public Inventario getInventario() {
        return inventario;
    }

    public GiocatoreConInventario(String nome, int vita, int anni, int ossigeno) {
        super(nome, vita, anni, ossigeno);
        this.inventario = new Inventario();
    }

    public List<String> getOggetti() {
        return inventario.getOggetti();
    }
}
