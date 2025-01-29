package it.dst.formazione.lezione7.esercizio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MauroSiciliano {

    public static void mauroSiciliano() {

        List<String> strings = Arrays.asList("aaaaa","55555","apert","APERT","zzzzz","1","2","3","4","5","6");

        Optional<String> maxString = strings.stream().max(String::compareToIgnoreCase);

        System.out.println(maxString);
        System.out.println(maxString.get());

        List<Integer> numbers = Arrays.asList(1,2,20,4,10,6,3,8,11,17);

        List<Integer> nPari = numbers.stream().filter(n -> n%2==0).collect(Collectors.toList());

        System.out.println(nPari);

        List<String> parole = Arrays.asList("java","stream","api");

        parole.stream()
                .map(String::toUpperCase);

        System.out.println(parole);











    }
}
