package org.example.personaggio;

public class Soldato extends Persona{

    private int hp;

    public Soldato(String nome, int anni){
        super(nome, anni);
        this.hp = 80;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
}
