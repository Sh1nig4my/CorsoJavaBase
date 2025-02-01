package org.example.scenari;

import org.example.eventi.ProvettaEsplodeInTheFace;

import java.util.Map;

public class LaboratorioIncredibile extends Scenes {

    public LaboratorioIncredibile() {
        super.setScenaryName("Laboratorio incredibile");
        super.newPossibleDirections = Map.of(1, LaStanzaDelleScimmieInGabbia.class, 2, Ambulatorio.class);
        super.scenaryEvents = Map.of(1,new ProvettaEsplodeInTheFace("ti scoppia una provetta in the face!!!"
        , null
        ));

    }
}
