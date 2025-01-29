package it.dst.formazione.lezione_8.esercizio;

import java.lang.reflect.Array;
import java.util.*;

public class CastaldiAlfredo {

public static void mainAlfredo(){
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,null,null));
    List<String> stringLengths = new ArrayList<>(Arrays.asList("ciao",null, null, null, "ba"));



    List<Integer> fixedList = numbers.stream()
                                     .map(Optional::ofNullable)
                                     .filter(Optional::isPresent)
                                     .map(Optional::get)
                                     .toList();

    System.out.println(fixedList);

    List<Integer> stringCounter = fixCollectionsFromNulls(stringLengths).stream().map(String::length).toList();

    System.out.println(stringCounter);


}


    private static <T>Collection<T> fixCollectionsFromNulls(Collection<T> collection){
      return   collection.stream()
                            .map(Optional::ofNullable)
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .toList();
    }
}
