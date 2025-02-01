package it.dst.formazione.esercitazioni.esercitazione2.NicholasPorta;

import com.google.gson.Gson;
import it.dst.formazione.esercitazioni.esercitazione2.NicholasPorta.Player.Personaggio;
import it.dst.formazione.esercitazioni.esercitazione2.NicholasPorta.Ruolo.Ruoli;
import it.dst.formazione.esercitazioni.esercitazione2.NicholasPorta.Scenario.Ambientazione;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        //istanzio la classe personaggio
        Personaggio personaggio = new Personaggio();
        //creo una mappa dove definisco i ruoli dando la chiave e richiamando con il new in modo da inizzializzare
        //la mappa
        Map<Integer, Ruoli> ruoli = new HashMap<>();
        ruoli.put(1, new Ruoli("Cavaliere Stellare", " Esperto combattente armato di spada energetica, abile nell'affrontare qualsiasi nemico.",100));
        ruoli.put(2, new Ruoli("Scienziato Esploratore", " Mente brillante con un forte desiderio di scoprire nuovi mondi e tecnologie.", 150));
        ruoli.put(3, new Ruoli("Assassino Cosmico", " Maestria nell'arte della furtività e delle tecniche di eliminazione silenziosa.", 120));
        ruoli.put(4, new Ruoli("Pilota Interstellare", " Esperto di navigazione spaziale, capace di affrontare ogni tipo di avventura tra le stelle", 140));

        System.out.println("Benvenuto, giocatore!" +
                " Sei pronto ad affrontare un'avventura galattica dove ogni scelta che farai avrà un impatto sul destino delle stelle? " +
                "Scegli il tuo personaggio, esplora mondi misteriosi e affronta pericoli inaspettati. " +
                "In un universo lontano, dove la verità è nascosta tra le ombre e gli enigmi sono la chiave della sopravvivenza, il tuo viaggio sta per cominciare...");
        //registro l'inizio del gioco
        LocalDateTime inizio = LocalDateTime.now();
        //istanzio scanner cosi da poter far interagire l'utente con la console di gioco

        System.out.println("Inserisci il tuo nome ");
        personaggio.setNome(scan.nextLine());
        System.out.println("Inserisci la tua età ");
        personaggio.setEta(scan.nextInt());

        //qui con un ciclo for mostro a schermo i vari ruoli che l'utente puo scegliere
        System.out.println(personaggio.getNome() + ", scegli il tuo personaggio tra: ");
        for (Map.Entry<Integer, Ruoli> entry : ruoli.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        int scelta = scan.nextInt();
        System.out.println("hai scelto " + ruoli.get(scelta));

        //creo una mappa dove inserisco le ambientazioni di gico
        Map<Integer, Ambientazione> sceltaEffetuata = new HashMap<>();
        sceltaEffetuata.put(1, new Ambientazione("Pianeta Eremita ", " Un pianeta desolato, pieno di rovine antiche e misteri da svelare."));
        sceltaEffetuata.put(2, new Ambientazione("Stazione Orbitante Atlas ", " Una stazione spaziale avanzata che orbita intorno a un buco nero, con pericoli nascosti e strani fenomeni."));
        sceltaEffetuata.put(3, new Ambientazione("Foresta Lunare ", "  Un mondo selvaggio e oscuro con alberi giganti e creature mitiche."));
        sceltaEffetuata.put(4, new Ambientazione("Tempio degli Elementi ", "Un antico tempio, nascosto su un pianeta lontano, che nasconde i segreti della creazione dell'universo."));
        System.out.println("dove vuoi andare?fai bene le tue scelte");
        //ciclo for mostro all'utente le scelte che puo prendere
        for (Map.Entry<Integer, Ambientazione> entry : sceltaEffetuata.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        //salvo la scelta in una variabile
        int direzione = scan.nextInt();
        System.out.println(" hai scelta di andare " + sceltaEffetuata.get(direzione));
        //creo una mappa di eventi(conseguenza in base alla scelta dell'utente)
        Map<Integer, String> eventi = new HashMap<>();
        eventi.put(1, "Scavi archeologici hanno rivelato una porta segreta. Un potente guardiano alieno la protegge.");
        eventi.put(2, "La tua nave è intrappolata in un campo gravitazionale instabile. Devi ripararla per evitare il buco nero.");
        eventi.put(3, "Una tribù aliena ti mette alla prova con sfide mortali per accedere a un antico segreto.");
        eventi.put(4, "Un antico rito è stato interrotto e una forza distruttiva minaccia l'equilibrio dell'universo.");

        //filtro con stream la mappa degli eventi e trova solo quella uguale alla scelta(direzioe)
        eventi.entrySet().stream()
                .filter(entry -> entry.getKey() == direzione)
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
        //creo una mappa con delle informazioni segrete
        Map<Integer, String> informazioni = new HashMap<>();
        informazioni.put(1, "Secret: Un'antica civiltà ha nascosto nei recessi dell'universo artefatti che potrebbero cambiare il destino di interi mondi.");
        informazioni.put(2, "Secret: Una forza oscura sta cercando di manipolare le leggi della fisica, mettendo in pericolo l'equilibrio dell'universo.");
        informazioni.put(3, "Secret: Un esperimento interdimensionalmente instabile potrebbe essere la chiave per esplorare mondi sconosciuti e senza tempo.");
        informazioni.put(4, "Secret: Ci sono voci su una misteriosa porta interdimensionale che potrebbe collegare tutte le linee temporali dell'universo.");

        // con l'uso di random posso creare una casualita di vero o falso in questo caso 50% di possibilita
        // metto Optional.empy(vuoto) e con rando vero falso lo riempie
        Optional<String> eventoSegreto = Optional.empty();
        if (random.nextBoolean() && informazioni.containsKey(direzione)) {
            eventoSegreto = Optional.of(informazioni.get(direzione));
        }

        eventoSegreto.ifPresentOrElse(
                // qui se vero (riempito)stampo l'informazione
                System.out::println,
                // falso se rimane vuoto stampo il messaggio
                () -> System.out.println("Non hai trovato alcuna informazione segreta in questa zona.")
        );

        //creo una lista per il file gjson
        List<String> risultati = new ArrayList<>();
        risultati.add("Nome del personaggio: " + personaggio.getNome());
        risultati.add("Età del personaggio: " + personaggio.getEta());
        risultati.add("Ruolo scelto: " + ruoli.get(scelta).getNome());
        risultati.add("Ambientazione scelta: " + sceltaEffetuata.get(direzione).getZona());
        risultati.add("Evento accaduto: " + eventi.get(direzione));

        Gson gson = new Gson();
        String json = gson.toJson(risultati);

        // con il filewriter vado a creare/modificare il file risultati.json
        try (FileWriter writer = new FileWriter("risultati.json")) {
            writer.write(json);
            System.out.println("Risultati salvati in 'risultati.json'.");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }
        //qui vedo l'orario di fine e richiamo inizio per il calcolo del tempo trascorso
        LocalDateTime fine = LocalDateTime.now();
        long durata = java.time.Duration.between(inizio, fine).getSeconds();
        System.out.println("Tempo di gioco: " + durata + " secondi.");
        System.out.println("===============================");
        System.out.println("Ora, con tutte le tue scelte e informazioni, hai aperto un nuovo capitolo dell'avventura.");
        System.out.println("Chissà cosa ti aspetta nel futuro... o forse il destino è già scritto?");
        System.out.println("FINE");
        System.out.println("===============================");
        System.out.println("Arrivederci, " + personaggio.getNome() + ". A presto!");
    }

}


