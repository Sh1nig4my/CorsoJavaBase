package it.dst.formazione.esercitazioni.esercitazione2.gioco;

import it.dst.formazione.esercitazioni.esercitazione2.advanced.punto2.Inventario;

import java.util.ArrayList;
import java.util.List;

public class Giocatore implements Persona {

    private final String nome;
    private int vita;
    private final int anni;

    public Giocatore(String nome, int vita, int anni) {
        this.nome = nome;
        this.vita = vita;
        this.anni = anni;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getVita() {
        return vita;
    }

    public int getAnni() {
        return anni;
    }


    @Override
    public void subireDanno(int danno) {
        this.vita -= danno;
        System.out.println(nome + " ha subito " + danno + " danni. Vita rimanente: " + vita);
    }
}

