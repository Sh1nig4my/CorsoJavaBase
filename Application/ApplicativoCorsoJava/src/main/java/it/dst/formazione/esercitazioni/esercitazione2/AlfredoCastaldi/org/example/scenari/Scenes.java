package org.example.scenari;

import org.example.eventi.AmbulatorioEvents;
import org.example.eventi.Event;

import java.util.Map;
import java.util.Random;

public class Scenes {

    // ogni scenario setta dentro questa proprietà
    // i possibili scenari dove ci si può muovere
    // ho usato il tipo di dato class perchè sono incappato in un deadlock
    // richiamando la new di B dentro A, e la new di A dentro B
    // con Class lo instanzio solo dopo la scelta quindi penso sia una buona soluzione

    // aprire LaboratorioIncredibile per vedere il costruttore commentato


    public Map<Integer, Class<? extends Scenes>> newPossibleDirections;
    private static Random rng = new Random();


    // ogni costruttore di uno scenario deve fornire una mappa di eventi possibili in quello scenario
    // è possibile usare lo stesso evento per più scenari
    protected Map<Integer, Event> scenaryEvents ;

    private String scenaryName;

    // della mappa di eventi possibili ne ritorna uno casuale
    // se non ne trova usa ambulatorio perchè è la scena iniziale del gioco
    // per adesso evita le nullpointer e mi permette di iniziare il gioco da ambulatorio
    public Event randomEvent(){
        if (scenaryEvents != null) {
        return scenaryEvents.get(rng.nextInt(1,scenaryEvents.size() +1));
        } else {
            return new AmbulatorioEvents("ti risvegli");
        }
    }

    public void stampaMappa(){
        scenaryEvents.forEach( (k,v) ->
        {
            System.out.println(k +" " + v);
        });
    }

    public String getScenaryName() {
        return scenaryName;
    }

    public void setScenaryName(String scenaryName) {
        this.scenaryName = scenaryName;
    }

}
