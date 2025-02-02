package org.example.personaggio;

public class Persona {

    private String nome;
    private Integer anni;
    private Integer hp;

    public Persona(){}

    public Persona(String nome, int anni) {
        this.nome = nome;
        this.anni = anni;
    }

    public Integer getAnni() {
        return anni;
    }

    public void setAnni(Integer anni) {
        this.anni = anni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
