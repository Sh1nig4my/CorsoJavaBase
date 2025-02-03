package org.example.eventi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Eventi {

    static List<String> avvenimenti = new ArrayList<>();

    public static void eventiRandomCorridoio(){
        avvenimenti.add("Spunta un mostro alieno davanti a te");
        avvenimenti.add("C'è un mini terremoto dovuto ad un impatto esterno, reggiti o rischi di farti del male");
        avvenimenti.add("Trovi una batteria, potrebbe tornarti utile");
        System.out.println(avvenimenti.stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get());
    }
    public static void eventiRandomSalaMacchine(){
        avvenimenti.add("Trovi un connettore, un buon pezzo per riparare la tua nave!");
        avvenimenti.add("Uno giupiteriano si palesa davanti a te, non sembra amichevole");
        avvenimenti.add("Cavi elettrici sparsi, evita di colpirli");
        System.out.println(avvenimenti.stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get());
    }
    public static void eventiRandomDormitori(){
        avvenimenti.add("Rovisti tra i cassetti dei membri dell'equipaggio, trovi soltanto cibo scaduto");
        avvenimenti.add("Un robot disattivato è appoggiato al muro, riattivandolo potrebbe aiutarti");
        avvenimenti.add("La puzza dei membri dell'equipaggio ormai morti rendi inaccessibile proseguire, torni indietro e chiudi la porta");
        System.out.println(avvenimenti.stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get());
    }





}
