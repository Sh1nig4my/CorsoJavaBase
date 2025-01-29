package it.dst.formazione.lezione7.optional;

import java.util.Optional;

public class OptionalUtils {

    public static void lezione7_optional() {
        // Creazione di un Optional con valore assente
        Optional<String> optionalValue = Optional.ofNullable(getValue());

        // Utilizzo di ifPresentOrElse per gestire la presenza o assenza del valore
        optionalValue.ifPresentOrElse(
                value -> System.out.println("Valore presente: " + value),
                () -> System.out.println("Valore assente")
        );

        // Utilizzo di orElse per fornire un valore predefinito
        String defaultValue = optionalValue.orElse("Valore di default");
        System.out.println("Valore restituito: " + defaultValue);

        // Utilizzo di map per trasformare il valore se presente
        Optional<Integer> length = optionalValue.map(String::length);
        length.ifPresent(len -> System.out.println("Lunghezza del valore: " + len));
    }

    private static String getValue() {
        return null; // Cambia con "Java" per testare il valore presente
    }
}
