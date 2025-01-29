import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MateiConstantinManole {
    public static void main(String[] args) {
        // creo una lista di stringhe con dei null
        List<String> nomi = Arrays.asList("Giovannu", "Lica", "Gioele", null, "lario", "ide", null, "aaaa", null);
        // filtro la lista per levare i null
        List<String> risultati = nomi.stream()
                .filter(nome -> Optional.ofNullable(nome).isPresent())
                .collect(Collectors.toList());

        //veridico se rimangono degli elementi dopo il filtro e se ci sono per ogni stringa vado a stampare la sua
        //lunghezza in caso contrario stampo che non ci sono righe
        if (!risultati.isEmpty()) {
            risultati.forEach(nome -> System.out.println("lunghezza di " + nome + ": " + nome.length()));
        } else {
            System.out.println("non ci sono stringhe");
        }

        //vado a stampare la lista finale rimanente in caso ci sia qualcosa altrimenti faccio partire l'else dove
        //comunica che la lista e vuota
        System.out.println(Optional.of(risultati)
                .filter(list -> !list.isEmpty())
                .map(Object::toString)
                .orElse("la lista non ha stringhe o ha valori null"));
    }
}
