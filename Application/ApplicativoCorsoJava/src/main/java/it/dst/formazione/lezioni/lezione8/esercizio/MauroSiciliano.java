package it.dst.formazione.lezione_8.esercizio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MauroSiciliano {

    public static void main (String[] args){
        /*
         variabile nome di tipo lista (come ci lavoro) = istanzio in memoria un oggetto di tipo arrayList
                                    List<String> nomi = new ArrayList<>();
        */

        List<String> videogiochi = Arrays.asList("Metal Gear Solid", "Final Fantasy", "Dark Souls", "Overwatch", "Kingdom Hearts");

        List<String> videogiochiFiltrati = videogiochi.stream().filter(titolo->titolo.length()>10).toList();

        System.out.println(videogiochi);
        System.out.println(videogiochiFiltrati);
    }


}
