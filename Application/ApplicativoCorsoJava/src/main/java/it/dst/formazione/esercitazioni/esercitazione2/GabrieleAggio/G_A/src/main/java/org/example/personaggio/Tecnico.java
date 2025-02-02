package org.example.personaggio;

public class Tecnico extends Persona{

    private int hp;

    public Tecnico() {}

    public Tecnico(String nome, int anni){
        super(nome, anni);
        this.hp = 100;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
