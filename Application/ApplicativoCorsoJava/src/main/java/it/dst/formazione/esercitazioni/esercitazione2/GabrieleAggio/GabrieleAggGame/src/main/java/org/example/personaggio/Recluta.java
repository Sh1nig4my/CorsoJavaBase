package org.example.personaggio;

public class Recluta extends Persona{

    private int hp;

    public Recluta(String nome, int anni){
        super(nome, anni);
        this.hp = 60;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
