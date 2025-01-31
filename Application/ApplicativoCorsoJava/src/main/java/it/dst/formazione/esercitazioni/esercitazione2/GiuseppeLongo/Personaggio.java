package it.dst.formazione.esercitazioni.esercitazione2.GiuseppeLongo;

import java.util.Optional;

public class Personaggio implements PersonaggioBase {
    private String tipo;
    private int hp;
    private int potere;
    private String fazione;
    private static final int HP_MAX = 200;

    public Personaggio(String tipo, int hp, int potere, String fazione) {
        this.tipo = tipo;
        this.hp = hp;
        this.potere = potere;
        this.fazione = fazione;
    }

    @Override
    public void mostraStatistiche() {
        System.out.println("Tipo: " + tipo + " | HP: " + hp + " | Potere: " + potere + " | Fazione: " + fazione);
    }

    @Override
    public void subisciDanno(int danno) {
        this.hp = Math.max(this.hp - danno, 0);
        if (!eVivo()) {
            System.out.println("ATTENZIONE: " + tipo + " è stato eliminato!");
        }
    }

    @Override
    public boolean eVivo() {
        return this.hp > 0;
    }

    public int getPotere() {
        return this.potere;
    }

    // metodi per gli eventi
    public void cura(int quantita) {
        this.hp = Math.min(this.hp + quantita, HP_MAX);  // Limita la cura al massimo degli HP
        System.out.println(tipo + " si è curato di " + quantita + " HP. HP attuali: " + hp);
    }

    public void aumentaPotenza(int quantita) {
        this.potere += quantita;
        System.out.println(tipo + " ha aumentato la sua potenza di " + quantita + ". Potenza attuale: " + potere);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setPotere(int potere) {
        this.potere = potere;
    }

    public void setFazione(String fazione) {
        this.fazione = fazione;
    }

    public String getTipo() {
        return tipo;
    }

    public int getHp() {
        return hp;
    }

    public String getFazione() {
        return fazione;
    }
}
