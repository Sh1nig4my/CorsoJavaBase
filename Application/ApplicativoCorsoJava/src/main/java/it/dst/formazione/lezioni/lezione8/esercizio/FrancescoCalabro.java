package it.dst.formazione.lezioni.lezione8.esercizio;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FrancescoCalabro {

    public static void streamAuto() {
        List<String> auto = Arrays.asList("Bmw", null, "Ford", "Fiat", null);

        List<String> autoIta = auto.stream()
                .filter(Objects::nonNull)
                .filter(veicoli -> veicoli.startsWith("F"))
                .toList();

        System.out.println("Le auto italiane dalla lista sono :" + autoIta);

        Optional<String> autoFiat = auto.stream()
                .filter(Objects::nonNull)
                .filter(veicoliIta -> veicoliIta.equalsIgnoreCase("Fiat"))
                .findFirst();
        System.out.println("Le auto della fiat sono : " + autoFiat.orElse("Nulla"));

    }
}
