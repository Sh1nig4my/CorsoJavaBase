package org.example.eventi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Eventi {

    static List<String> avvenimenti = new ArrayList<>();

    public static void generaAvvenimentoRandom(){
        avvenimenti.add("Spunta un mostro alieno davanti a te");
        avvenimenti.add("C'è un mini terremoto dovuto ad un impatto esterno, reggiti o rischi di farti del male");
        avvenimenti.add("Trovi una batteria, potrebbe tornarti utile");
        System.out.println(avvenimenti.stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get());
    }



}
