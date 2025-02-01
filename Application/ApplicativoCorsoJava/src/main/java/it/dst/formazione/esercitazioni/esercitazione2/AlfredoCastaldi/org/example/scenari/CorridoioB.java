package org.example.scenari;

import org.example.eventi.Corridoio;

import java.util.Map;

public class CorridoioB extends Scenes{
    public CorridoioB() {
        super.newPossibleDirections = Map.of(
                1, HangarMaledetto.class,
                2, Ambulatorio.class
        );
        super.setScenaryName("Corridoio B");
        super.scenaryEvents = Map.of(1, new Corridoio("ti aggiri nei bianchi corridoi", null));

    }
}
