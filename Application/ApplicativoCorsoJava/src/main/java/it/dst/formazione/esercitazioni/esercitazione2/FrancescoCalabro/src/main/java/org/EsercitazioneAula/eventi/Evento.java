package it.dst.formazione.esercitazioni.esercitazione2.FrancescoCalabro.src.main.java.org.EsercitazioneAula.eventi;
import it.dst.formazione.esercitazioni.esercitazione2.FrancescoCalabro.src.main.java.org.EsercitazioneAula.personaggio.Persona;
import it.dst.formazione.esercitazioni.esercitazione2.FrancescoCalabro.src.main.java.org.EsercitazioneAula.personaggio.SceltaPersonaggio;
import java.time.LocalDateTime;
import java.util.*;

public class Evento {

    public static void eventoGioco() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto sulla stazione Epsilon 9!");
        System.out.println("Scegli il tuo personaggio: ");
        System.out.println("1) Androide");
        System.out.println("2) Soldato");
        System.out.println("3) Alieno");

        int scelta = scanner.nextInt();
        Persona persona = SceltaPersonaggio.selezione(scelta);

        LocalDateTime inizio = LocalDateTime.now();

        List<String> eventiPossibili = Arrays.asList(
                "1) Ci sono 4 mercenari a bordo di Epsilon 9",
                "2) Sul pannello dei comandi c'è una strana barriera",
                "3) Apri la cella e fai evadere tua madre");

        System.out.println("Scegli un evento tra quelli disponibili:");
        eventiPossibili.forEach(System.out::println);

        int scelta2 = scanner.nextInt();
        persona.usaSkill(String.valueOf(scelta2));
        persona.piuOMenoSalute(String.valueOf(scelta2));

        Map<Integer, String> oggetti = Map.of(
                1, "Casco da mercenario",
                2, "Chiave della nave",
                3, "Stemma di famiglia");

        Optional<String> oggetto = Optional.ofNullable(oggetti.get(scelta2));

        oggetto.ifPresent(item -> {
            System.out.println("Hai guadagnato: " + item);
            System.out.println("Vuoi aggiungerlo al tuo inventario? (si/no)");
            if (scanner.next().trim().equalsIgnoreCase("si")) {
                persona.aggiungiOggetto(item, 1);
                System.out.println("Oggetto aggiunto nell'inventario");
            }
        });

        LocalDateTime fine = LocalDateTime.now();
        long durata = java.time.Duration.between(inizio, fine).getSeconds();
        System.out.println("Tempo di gioco: " + durata + " secondi.");
    }
}
