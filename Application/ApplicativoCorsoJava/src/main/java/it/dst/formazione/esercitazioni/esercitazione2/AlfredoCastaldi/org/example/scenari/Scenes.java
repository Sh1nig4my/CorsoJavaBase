package org.example.scenari;

import org.example.eventi.AmbulatorioEvents;
import org.example.eventi.Event;

import java.util.Map;
import java.util.Random;

public class Scenes {

    public Map<Integer, Class<? extends Scenes>> newPossibleDirections;
    private static Random rng = new Random();

    protected Map<Integer, Event> scenaryEvents ;

    private String scenaryName;


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
