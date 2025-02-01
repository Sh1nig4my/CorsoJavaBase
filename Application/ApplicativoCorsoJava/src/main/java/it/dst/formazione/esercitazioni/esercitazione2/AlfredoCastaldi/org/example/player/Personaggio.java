package org.example.player;

public abstract class Personaggio {

    private int vita;
    private String nome;
    private int anni;

    public Personaggio(int vita, String nome, Integer anni) {
        this.vita = vita;
        this.nome = nome;
        this.anni = anni;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() +
                " vita=" + vita +
                ", nome='" + nome + '\'' +
                ", anni=" + anni +
                '}';
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnni() {
        return anni;
    }

    public void setAnni(int anni) {
        this.anni = anni;
    }



/*
    Scelta del personaggio: Il giocatore deve poter scegliere tra diversi personaggi di gioco
    (esempio pirata spaziale, un androide, ..), si consiglia di utilizzare una classe/interfaccia
    Persona per la creazione dei diversi personaggi di gioco; ogni personaggio dovrà avere attributi
    come nome, vita, anni, punti feriti, inventario,
     */
}
