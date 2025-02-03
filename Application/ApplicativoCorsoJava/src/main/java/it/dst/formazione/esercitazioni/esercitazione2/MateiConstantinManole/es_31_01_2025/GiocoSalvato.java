
// La classe  memorizza il personaggio scelto e la missione corrente.

class GiocoSalvato {
    private Personaggio personaggio;
    private int missione;


    public GiocoSalvato(Personaggio personaggio, int missione) {
        this.personaggio = personaggio;
        this.missione = missione;
    }


    public Personaggio getPersonaggio() {
        return personaggio;
    }

    public void setPersonaggio(Personaggio personaggio) {
        this.personaggio = personaggio;
    }

    public int getMissione() {
        return missione;
    }

    public void setMissione(int missione) {
        this.missione = missione;
    }
}
