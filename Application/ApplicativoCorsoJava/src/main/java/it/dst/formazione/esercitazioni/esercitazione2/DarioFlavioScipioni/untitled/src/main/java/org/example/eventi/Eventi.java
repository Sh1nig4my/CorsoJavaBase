package org.example.eventi;

import org.example.ambientazione.Scenario;
import org.example.giocatore.Persona;
import org.example.giocatore.Ruolo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Eventi {

    Eventi evento = new Eventi();
    static List<String> avvenimenti = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void eventiRandomCorridoio(Persona personaggio) {
        avvenimenti.add("Spunta un mostro alieno davanti a te");
        avvenimenti.add("C'è un mini terremoto dovuto ad un impatto esterno, reggiti o rischi di farti del male");
        avvenimenti.add("Trovi una batteria, potrebbe tornarti utile");
        System.out.println(avvenimenti.stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get());
    }

    public static void eventiRandomSalaMacchine(Persona personaggio) {
        avvenimenti.add("Trovi un connettore, un buon pezzo per riparare la tua nave!");
        avvenimenti.add("Uno giupiteriano si palesa davanti a te, non sembra amichevole");
        avvenimenti.add("Cavi elettrici sparsi, evita di colpirli");
        System.out.println(avvenimenti.stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get());
    }

    public static void eventiRandomDormitori(Persona personaggio, Ruolo classe) {
        avvenimenti.add("Rovisti tra i cassetti dei membri dell'equipaggio, trovi soltanto cibo scaduto");
        avvenimenti.add("Un robot disattivato è appoggiato al muro, riattivandolo potrebbe aiutarti");
        avvenimenti.add("La puzza dei membri dell'equipaggio ormai morti rendi inaccessibile proseguire, torni indietro e chiudi la porta");
        String eventoDormitori = avvenimenti.stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get();
        System.out.println(eventoDormitori);
        if (eventoDormitori.contains("scaduto")) {
            System.out.println("Vuoi mangiarlo?\n>si\n>no");
            String risposta = scanner.nextLine();
            if (risposta.equals("si")) {
                System.out.println("é disgustoso!\nSazi leggermente la tua fame ma perdi 20 hp");
                classe.perdiHp(20);
                Scenario.scegliPercorso(personaggio, classe);

            } else if (risposta.equals("no")) {
                System.out.println("Lo posi dov'era e prosegui");
                Scenario.scegliPercorso(personaggio, classe);
            } else {
                System.out.println("Risposta non valida");
            }
        }
    }
}
