package it.dst.formazione.lezione7.optional;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalPipeline {

    public static void lezione7_optional_pipeline() {
        Stream<Optional<String>> stream = Stream.of(
                Optional.of("Java"),
                Optional.empty(),
                Optional.of("Stream")
        );

        // Filtra ed elabora solo i valori presenti
        stream.filter(Optional::isPresent)
                .map(Optional::get)
                .map(String::toUpperCase)
                .forEach(System.out::println); // Output: JAVA STREAM
    }
}
