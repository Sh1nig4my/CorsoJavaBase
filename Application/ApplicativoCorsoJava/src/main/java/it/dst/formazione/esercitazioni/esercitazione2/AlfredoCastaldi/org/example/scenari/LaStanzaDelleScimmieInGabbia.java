package org.example.scenari;

import org.example.eventi.LeScimmieTiAttaccano;

import java.util.Map;

public class LaStanzaDelleScimmieInGabbia extends Scenes {
    public LaStanzaDelleScimmieInGabbia() {
      super.setScenaryName("La stanza delle scimmie assassine");
      super.scenaryEvents = Map.of(1, new LeScimmieTiAttaccano("mankeys jumping on you !!!!"));
    }
}
