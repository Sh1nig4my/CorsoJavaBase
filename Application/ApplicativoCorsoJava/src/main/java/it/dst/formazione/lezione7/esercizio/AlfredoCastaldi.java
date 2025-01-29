package it.dst.formazione.lezione7.esercizio;

import java.util.*;

public class AlfredoCastaldi {


    public static void esercizioMainMetodo(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3222,4,5,6,7));

        Optional<Integer> maxNumber = numbers.stream()
                .max((value1, value2)->{ return value1.compareTo(value2);});

        // è l'equivalente di scrivere Integer::compareTo, lo trovo più chiaro da capire

        // piccola prova dell'optional, o mi ritorna un valore o throwa un eccezione personalizzata
        Integer maxNumberGet = maxNumber.orElseThrow(()-> new MaxNumberNotFoundException("valore non trovato"));
        System.out.println(maxNumberGet);

        List<Integer> evenNumbers = numbers.stream().filter( n -> n%2 == 0).toList();

        List<String> paroleTest = new ArrayList<>(Arrays.asList("Albero", "mandarino", "babbuino","zebra","Macchina","astronave"));

        System.out.println(paroleTest);

        paroleTest.replaceAll(String::toUpperCase);

    }

    private static class MaxNumberNotFoundException extends RuntimeException {


        private String message;

        public MaxNumberNotFoundException(String msg){
            this.message = msg;
        }
    }
}
