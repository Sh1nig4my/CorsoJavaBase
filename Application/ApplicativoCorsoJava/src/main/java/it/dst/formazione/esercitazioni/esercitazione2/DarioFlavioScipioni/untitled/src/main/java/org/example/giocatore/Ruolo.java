package org.example.giocatore;

import java.util.List;

public class Ruolo extends Persona{
    String nome;
    String descrizione;
    List<String> abilita;

    public Ruolo(String nome, String descrizione, List<String> abilita) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.abilita = abilita;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<String> getAbilita() {
        return abilita;
    }

    public void setAbilita(List<String> abilita) {
        this.abilita = abilita;
    }

}
