package it.dst.formazione.esercitazioni.esercitazione2.NicholasPorta.Scenario;

import java.util.Map;

public class Ambientazione {

    private String zona;
    private  String descrizione;

    public Ambientazione(String zona, String descrizione) {
        this.zona = zona;
        this.descrizione = descrizione;
    }


    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return zona +  descrizione ;
    }
}
