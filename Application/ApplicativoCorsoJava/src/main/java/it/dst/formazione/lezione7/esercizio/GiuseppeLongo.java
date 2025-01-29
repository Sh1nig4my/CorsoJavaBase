package it.dst.formazione.lezione7.esercizio;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GiuseppeLongo {

    public static void test_stream() {

        List<Integer> numbers = Arrays.asList (1, 2, 3, 4, 5, 6);

        List<String> parole = Arrays.asList( "radio", "manga", "tv");

        List<String> paroleUppercase = parole.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        Optional<Integer> maxNumber = numbers.stream().max(Integer::compareTo);



        System.out.println(maxNumber);
        System.out.println(maxNumber.get());
        System.out.println(paroleUppercase);

    }


}
