package it.dst.formazione.lezione7.esercizio;

import java.util.*;

public class DarioFlavioScipioni {

    public static void provaLezione7() {


        //Esercizio: implementare uno stream che mi permetta di vedere e mi restituisca il valore Integer piu grande
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> numeroMasismo = numbers.stream().max(Integer::compareTo);
        //nelle parentesi sto spiegando come comparare questi elementi, ed essendo integer posso usare il compareTo


        //Esercizio: se ho una lista di stringe che succede se considero valore massimo di una stringa?
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5", "6");
        Optional<String> maxString = strings.stream().max(String::compareToIgnoreCase); //ignoreCase ci dice che ignora caratteri maiuscoli o minuscoli ecc

        System.out.println(numeroMasismo.get());
        System.out.println(maxString.get());

        //Esercizio: Prendere array, leggere numeri pari e ritornare ad una lista di soli valori pari
        List<Integer> valoriPari = numbers.stream().filter(n->n%2==0).toList();
        System.out.println(valoriPari);


        //Esercizio: applicare ad una lista di parole il "toUpperCase"
        List<String> parole=Arrays.asList("ciao","pluto","paperino");
        List<String> paroleMaiusc = parole.stream().map(String::toUpperCase).toList();
        System.out.println("Parole: " + parole);
        System.out.println("Parole Maiuscole: " + paroleMaiusc);

        //Esercizio: far diventare Maiuscola solo la prima Stringa della lista
        parole.set(0,parole.get(0).toUpperCase());


    }
}
