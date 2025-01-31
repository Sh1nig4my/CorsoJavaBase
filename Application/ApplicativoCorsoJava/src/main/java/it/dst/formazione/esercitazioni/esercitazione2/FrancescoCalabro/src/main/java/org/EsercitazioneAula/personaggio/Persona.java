package it.dst.formazione.esercitazioni.esercitazione2.FrancescoCalabro.src.main.java.org.EsercitazioneAula.personaggio;

import java.util.HashMap;

public class Persona {

    String nome;
    Integer anni;
    Integer vita;
    String skill;
    HashMap<String, Integer> inventario = new HashMap<>();

    public Persona(String nome, Integer anni, Integer vita, String skill) {
        this.nome = nome;
        this.anni = anni;
        this.vita = vita;
        this.skill = skill;
    }

    public void aggiungiOggetto(String oggetto, Integer quantita) {
        inventario.put(oggetto, inventario.getOrDefault(oggetto, 0) + quantita);
    }

    public HashMap<String, Integer> getInventario() {
        return inventario;
    }

    public void usaSkill(String evento) {
    }

    public void piuOMenoSalute(String evento) {

    }
}
