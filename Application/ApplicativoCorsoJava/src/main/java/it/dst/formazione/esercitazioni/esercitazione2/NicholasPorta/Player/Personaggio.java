package it.dst.formazione.esercitazioni.esercitazione2.NicholasPorta.Player;

public class Personaggio {

    private String nome;
    private int eta;




    public Personaggio() {
        this.eta = eta;
        this.nome = nome;


    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.matches("^[A-Za-zà-ÿ]+(?: [A-Za-zà-ÿ]+)*$")) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("ERRORE Il nome può contenere solo lettere e spazi riprova ");
        }
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }




}



