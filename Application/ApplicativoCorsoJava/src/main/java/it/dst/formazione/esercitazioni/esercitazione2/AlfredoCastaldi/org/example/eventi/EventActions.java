package org.example.eventi;

import org.example.player.Personaggio;

@FunctionalInterface
public interface EventActions {


    public Object getConsequence(Personaggio eventTarget);
}
