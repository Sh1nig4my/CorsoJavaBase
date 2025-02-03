package org.example.giocatore;

public class Persona {
    String nome;
    int eta;
    int vita;
    String provenienza;

    public String getProvenienza() {
        return provenienza;
    }

    public void setProvenienza(String provenienza) {
        this.provenienza = provenienza;
    }

    public Persona() {
        this.nome = nome;
        this.eta = eta;
        this.vita = vita;
        this.provenienza = provenienza;
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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

}
