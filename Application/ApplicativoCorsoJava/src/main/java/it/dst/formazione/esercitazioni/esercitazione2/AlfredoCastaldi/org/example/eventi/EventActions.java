package org.example.eventi;

import org.example.player.Personaggio;

/*
    ho pensato di concepire le conseguenze di un evento tramite delle lambda perchè le ho trovate flessibili
    ritornano un oggetto generico, quindi una possibile ricompensa per il giocatore, un booleano,
    la più comune è una stringa, penso che potrei concepirla meglio in futuro ma per adesso funziona così

    (giocatore) -> {
        giocatore.PerdePuntiVita();
        SYstem.out.println("oh no hai perso punti vita !!! ");
        if (minigioco == true) {
        giocatore.TrovaOggetto(new OggettoIncredibile());
        System.out.println("wow hai pure trovato un oggetto")
        } else {
        System.out.println("non hai trovato niente")
        } return "finalmente hai finito di esplorare questa stanza;
    }

    esempio esagerato ma l'idea è questa per gestire le conseguenze di un evento

    controllare la classe ProvettaEsplodeInTheFace per più info
 */



@FunctionalInterface
public interface EventActions {


    public Object getConsequence(Personaggio eventTarget);
}
