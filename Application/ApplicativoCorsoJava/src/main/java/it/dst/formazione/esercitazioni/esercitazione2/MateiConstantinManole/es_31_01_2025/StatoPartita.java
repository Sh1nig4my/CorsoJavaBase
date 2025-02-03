import java.io.Serializable;

public class StatoPartita implements Serializable {

    // Variabili di istanza che tengono traccia dello stato della partita

    private int personaggioScelto;
    private int missioneScelta;
    private String nomePersonaggio;

    // Costruttore della classe che inizializza i campi con i valori passati come argomenti

    public StatoPartita(int personaggioScelto, int missioneScelta, String nomePersonaggio) {
        this.personaggioScelto = personaggioScelto;
        this.missioneScelta = missioneScelta;
        this.nomePersonaggio = nomePersonaggio;
    }
    // Metodo getter per ottenere il valore dei campi
    public int getPersonaggioScelto() {
        return personaggioScelto;
    }

    public void setPersonaggioScelto(int personaggioScelto) {
        this.personaggioScelto = personaggioScelto;
    }

    public int getMissioneScelta() {
        return missioneScelta;
    }

    public void setMissioneScelta(int missioneScelta) {
        this.missioneScelta = missioneScelta;
    }

    public String getNomePersonaggio() {
        return nomePersonaggio;
    }

    public void setNomePersonaggio(String nomePersonaggio) {
        this.nomePersonaggio = nomePersonaggio;
    }
}
