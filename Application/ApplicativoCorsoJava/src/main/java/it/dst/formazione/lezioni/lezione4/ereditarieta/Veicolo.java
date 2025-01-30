package it.dst.formazione.lezioni.lezione4.ereditarieta;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class Veicolo implements VeicoloInterface {

    public Integer test_richiamo = 9;
    public String tipo;
    private String proprietario;
    final Integer motore = 2;
    static Boolean hasAirBag;
    Integer ex_tmp;


    public Integer getMotore() {
        return motore;
    }


    public static Boolean getHasAirBag() {
        return hasAirBag;
    }

    public static void setHasAirBag(Boolean hasAirBag) {
        Veicolo.hasAirBag = hasAirBag;
    }


    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        if (StringUtils.isEmpty(proprietario)) {
            this.proprietario = "ERRORE";
        } else {
            this.proprietario = proprietario;
        }

    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public void accendi() {
        System.out.println("Il veicolo è acceso.");
    }
}
