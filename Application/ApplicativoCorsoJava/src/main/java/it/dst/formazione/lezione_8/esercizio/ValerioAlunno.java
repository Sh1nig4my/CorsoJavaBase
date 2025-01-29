package it.dst.formazione.lezione_8.esercizio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ValerioAlunno {
    public static void main(String[] args){
        List<Integer> numeri = Arrays.asList(1,2,3,4,5,6);
        int somma = numeri.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue).sum();
        System.out.println("La somma dei numeri pari e':"+ somma);


        int risultati = numeri.stream()
                .filter(Optional::ofNullable) // Gestione valori nulli
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Numeri trasformati: " + risultati);

    }

}
