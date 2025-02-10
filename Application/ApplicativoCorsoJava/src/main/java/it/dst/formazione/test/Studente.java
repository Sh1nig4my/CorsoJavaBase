package it.dst.formazione.test;

public class Studente {

    // TODO
    int idStudente;
    String nome;
    String cognome;
    String email;

    public Studente(String nome, String cognome, String email) {

        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public Studente(int idStudente, String cognome, String nome, String email) {
        this.idStudente = idStudente;
        this.cognome = cognome;
        this.nome = nome;
        this.email = email;
    }

    public int getIdStudente() {
        return idStudente;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "idStudente=" + idStudente +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
