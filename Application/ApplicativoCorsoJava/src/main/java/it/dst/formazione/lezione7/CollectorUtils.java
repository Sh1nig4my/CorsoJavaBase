package it.dst.formazione.lezione7;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorUtils {

    public static void lezione7_collector() {
        List<String> words = List.of("Java", "Stream", "API");

        // Collector personalizzato per concatenare stringhe con separatore
        Collector<CharSequence, ?, String> customCollector =
                Collectors.joining(" - ");

        String result = words.stream().collect(customCollector);
        System.out.println("Risultato: " + result); // Output: Java - Stream - API
    }

}
