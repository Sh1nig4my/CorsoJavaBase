package org.example.scenari;

import org.example.eventi.ComputerFound;
import org.example.eventi.Corridoio;

import java.util.Map;

public class CorridoioA extends Scenes{
    public CorridoioA(){
      super.newPossibleDirections = Map.of(
            1, LaboratorioIncredibile.class,
            2, LaStanzaDelleScimmieInGabbia.class,
              3,Ambulatorio.class
        );
      super.scenaryEvents = Map.of(1, new Corridoio("ti aggiri nei bianchi corridoi", null));
        super.setScenaryName("Corridoio A");
    }
}
