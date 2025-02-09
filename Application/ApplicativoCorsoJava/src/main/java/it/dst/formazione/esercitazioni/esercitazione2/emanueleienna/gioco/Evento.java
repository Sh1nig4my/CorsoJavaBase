package it.dst.formazione.esercitazioni.esercitazione2.emanueleienna.gioco;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Evento {

    private static final List<String> eventi = Arrays.asList(
            "Trovi un terminale di sicurezza attivo",
            "Un robot di pattuglia ti avvista",
            "Accedi ai registri segreti della stazione",
            "Un'esplosione improvvisa danneggia il modulo"
    );

    public static String generaEvento() {
        List<String> eventiFiltrati = eventi.stream()
                .filter(evento -> !evento.contains("esplosione"))
                .sorted()
                .toList();

        return eventiFiltrati.get(new Random().nextInt(eventiFiltrati.size()));
    }
}
