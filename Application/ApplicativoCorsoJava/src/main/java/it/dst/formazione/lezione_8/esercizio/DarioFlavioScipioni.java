package it.dst.formazione.lezione_8.esercizio;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DarioFlavioScipioni {
    public static void main(String[] args) {

       DarioFlavioScipioni.esercizioConStreamOptional();

    }
    public static void esercizio(){
        List<String> nomi = Arrays.asList("Marco","Mario", null, "Camilla", null,"Chiara");
        System.out.println(nomi);
        for(int count=0; count<nomi.size(); count++){
            if (nomi.get(count)!=null){
                System.out.println(nomi.get(count));
            } else {
                System.out.println("Nome non valido");
            }
        }
    }
    public static void esercizioConStreamOptional(){

        List<String> nomi = Arrays.asList("Marco","Mario", null, "Camilla", null,"Chiara");
        //Utilizzo Stream per filtrare e gestire i null attraverso gli Optional
        //map trasforma ogni elemento in un nuovo valore.
        nomi.stream().map(n-> Optional.ofNullable(n).orElse("Nome non valido")).forEach(System.out::println);
    }
}
