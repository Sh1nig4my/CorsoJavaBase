package it.dst.formazione.lezione7.esercizi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EdoardoRosati {

    public static void geronimo () {
        List<String> parole = Arrays.asList("Pi", "Po", "Alfred", "Jericho", "Daje", "Menelao", "Richard");

        List<String> upper = parole.stream().map(String::toUpperCase).toList();

        System.out.println("Risultato: " + parole);
    }

}
