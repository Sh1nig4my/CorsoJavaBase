import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LocalDateTime inizio = LocalDateTime.now();
        // location
        System.out.println("benvenuto su Epsilon 9, una stazione spaziale abbandonata da 1 ora");

        // scelta del personaggio con controllo in caso di risposta non giusta
        System.out.println("---------- Scegli il tuo personaggio ---------");
        System.out.println("1. Pirata Spaziale");
        System.out.println("2. Androide");
        System.out.println("3. Alieno");

        int scelta = -1;


        while (scelta < 1 || scelta > 3) {
            System.out.print("inserisci il numero corrispondente al personaggio: ");
            scelta = scanner.nextInt();


            if (scelta < 1 || scelta > 3) {
                System.out.println("la scelta deve essere 1, 2 o 3.");
            }
        }

        Personaggio personaggio = scegliPersonaggio(scelta);
        personaggio.descrizione();
        // scelta specifica della location con controllo in caso di risposta non giusta
        System.out.println("--------- Scegli la tua missione ----------");
        System.out.println("1) Esplora i laboratori segreti");
        System.out.println("2) Esamina la baia di carico");

        int missione = -1;

        while (missione < 1 || missione > 2) {
            System.out.print("Inserisci il numero corrispondente alla missione: ");
            missione = scanner.nextInt();


            if (missione < 1 || missione > 2) {
                System.out.println("Errore! La scelta deve essere 1 o 2.");
            }
        }


            //lista eventi casuali che potrebbero accadere
        List<String> eventi = Arrays.asList(
                "trovi un terminale di sicurezza attivo",
                "un robot di pattuglia ti ha visto",
                "accedi ai registri segreti della stazione",
                "un'esplosione improvvisa danneggia il modulo",
                "un'intelligenza artificiale tenta di comunicare con te",
                "il terminale di sicurezza richiede un codice di accesso"
        );


        List<String> eventiFiltrati = eventi.stream()
                .sorted()  // Eventi ordinati
                .collect(Collectors.toList());
        // Se ci sono eventi filtrati ne viene scelto uno e viene applicato un danno al personaggio
        if (!eventiFiltrati.isEmpty()) {
            String eventoCasuale = eventiFiltrati.get(new Random().nextInt(eventiFiltrati.size()));
            System.out.println("Evento casuale: " + eventoCasuale);

            int dannoCasuale = new Random().nextInt(16) + 5;
            personaggio.subireDanno(dannoCasuale);
        }

        // Controlla se sono state trovate informazioni segrete
            Optional<String> informazioniSegrete = trovaInformazioniSegrete();
            informazioniSegrete.ifPresentOrElse(
                    info -> System.out.println("Hai trovato informazioni segrete: " + info),
                    () -> System.out.println("Non hai trovato nessuna informazione segreta.")
            );
        // Esegue il combattimento o tentativo di hacking
            combattimentoEHacking(personaggio);
        // Salva lo stato della partita
            GiocoSalvato nuovoGioco = new GiocoSalvato(personaggio, missione);
            salvaPartita(nuovoGioco);

        // Calcola e stampa il tempo di gioco
        LocalDateTime fine = LocalDateTime.now();
        long durata = Duration.between(inizio, fine).getSeconds();
        System.out.println("Tempo di gioco: " + durata + " secondi.");

        scanner.close();
    }
    // Metodo per scegliere il personaggio in base alla scelta dell'utente
    private static Personaggio scegliPersonaggio(int scelta) {
        switch (scelta) {
            case 1:
                return new PirataSpaziale();
            case 2:
                return new Androide();
            case 3:
                return new Alieno();
            default:
                throw new IllegalArgumentException("scelta non valida");
        }
    }
    // Metodo per trovare informazioni segrete casuali
    private static Optional<String> trovaInformazioniSegrete() {
        List<String> informazioni = Arrays.asList(
                "codice di accesso ai laboratori segreti",
                "identità dell'intelligenza artificiale della stazione"
        );
        return new Random().nextBoolean() ? Optional.of(informazioni.get(new Random().nextInt(informazioni.size()))) : Optional.empty();
    }

    // Metodo che gestisce il combattimento o l'hacking
    private static void combattimentoEHacking(Personaggio personaggio) {
        System.out.println("\n ------- Combattimento / Hacking -------");


        Nemico nemico = new Nemico("Robot di Pattuglia", 80, 10);
        System.out.println("Un " + nemico.getNome() + " si presenta");

        // Se l'azione è combattimento

        Random random = new Random();
        int sceltaAzione = random.nextInt(2);

        if (sceltaAzione == 0) {
            System.out.println("Hai scelto di combattere il nemico");
            int dannoPersonaggio = personaggio.calcolaDanno();
            int dannoNemico = nemico.calcolaDanno();
            // Combattimento finché uno dei due non muore
            while (personaggio.getVita() > 0 && nemico.getVita() > 0) {
                nemico.subireDanno(dannoPersonaggio);
                if (nemico.getVita() <= 0) {
                    System.out.println("Hai sconfitto il nemico");
                    break;
                }

                personaggio.subireDanno(dannoNemico);
                if (personaggio.getVita() <= 0) {
                    System.out.println("Sei stato sconfitto");
                    break;
                }
            }
        } else {

            // Se l'azione è hacking

            System.out.println("Hai scelto di tentare un hacking");
            boolean successoHacking = personaggio.tentativoHacking();
            if (successoHacking) {
                System.out.println("L'hacking ha avuto successo! Hai ottenuto informazioni utili.");
            } else {
                System.out.println("L'hacking è fallito. Il nemico ti ha individuato");
                nemico.ataccca(personaggio);
            }
        }
    }

    // Metodo per salvare lo stato della partita in un file JSON
    private static void salvaPartita(GiocoSalvato gioco) {
        try (Writer writer = new FileWriter("partita_salvata.json")) {
            Gson gson = new Gson();
            gson.toJson(gioco, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}