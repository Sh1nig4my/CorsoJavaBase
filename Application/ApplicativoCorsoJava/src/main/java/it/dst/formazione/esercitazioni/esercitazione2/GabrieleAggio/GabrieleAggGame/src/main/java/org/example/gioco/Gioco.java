package org.example.gioco;

import org.example.personaggio.Persona;
import org.example.personaggio.Recluta;
import org.example.personaggio.Soldato;
import org.example.personaggio.Tecnico;
import org.example.scenario.BaseScenary;
import org.example.scenario.ScenarioLaboratorio;
import org.example.scenario.ScenarioNaveSpazialeNemica;
import org.example.scenario.ScenarioRoverLunare;

import java.util.*;
import java.util.stream.Collectors;

public class Gioco {

    Scanner scanner = new Scanner(System.in);
    Persona personaggioScelto;
    ScenarioLaboratorio scenLab = new ScenarioLaboratorio();
    ScenarioNaveSpazialeNemica scenNavSpazNem = new ScenarioNaveSpazialeNemica();
    ScenarioRoverLunare scenRovLun = new ScenarioRoverLunare();

    public List<BaseScenary> listeScenari = new ArrayList<>();

    GiocoUtils gu = new GiocoUtils();



    public Persona scegliPersonaggio() {
        try {
            int sceltaPersonaggio;
            while (true) {
                System.out.println(" ------------------------ ");
                System.out.println("Scegli il tipo di protagonista da usare:");
                System.out.println("1. Tecnico [Facile]");
                System.out.println("2. Soldato [Medio]");
                System.out.println("3. Recluta [Difficile]");
                System.out.println(" ------------------------ ");
                System.out.print("Inserisci la tua scelta (1-3): ");

                if (scanner.hasNextInt()) {
                    sceltaPersonaggio = scanner.nextInt();
                    scanner.nextLine();

                    if (sceltaPersonaggio >= 1 && sceltaPersonaggio <= 3) {
                        break;
                    } else {
                        System.out.println("Scelta non valida, riprova (1-3).");
                    }
                } else {
                    System.out.println("Input non valido! Inserisci un numero tra 1 e 3.");
                    scanner.nextLine();
                }
            }

            System.out.print("Inserisci il nome del tuo personaggio: ");
            String nome = scanner.nextLine();

            switch (sceltaPersonaggio) {
                case 1:
                    return new Tecnico(nome, 50);
                case 2:
                    return new Soldato(nome, 30);
                case 3:
                    return new Recluta(nome, 20);
                default:
                    return null;
            }
        } catch (Exception ex) {
            System.out.println("Si è verificato un errore: " + ex.getMessage());
        }
        return null;
    }

    public void sceltaSvolta() {
        try {
            String scelta;

            if (scenLab.isUsato() && scenNavSpazNem.isUsato() && scenRovLun.isUsato()) {
                return;
            }

            while (true) {
                System.out.println(" ------------------------ ");
                System.out.println("Quale zona vuoi visitare:");

                if (!scenLab.isUsato()) {
                    System.out.println("1. Laboratorio");
                }
                if (!scenNavSpazNem.isUsato()) {
                    System.out.println("2. Nave spaziale");
                }
                if (!scenRovLun.isUsato()) {
                    System.out.println("3. Rover Lunare");
                }
                System.out.println(" ------------------------ ");
                System.out.print("Inserisci la tua scelta (1-3): ");

                scelta = scanner.nextLine().trim();

                if (scelta.equals("1") && !scenLab.isUsato()) {
                    scenLab.disegnoScenario();
                    scenLab.descrizioneScenario();
                    scenLab.setUsato(true);
                    break;
                } else if (scelta.equals("2") && !scenNavSpazNem.isUsato()) {
                    scenNavSpazNem.disegnoScenario();
                    scenNavSpazNem.descrizioneScenario();
                    scenNavSpazNem.setUsato(true);
                    break;
                } else if (scelta.equals("3") && !scenRovLun.isUsato()) {
                    scenRovLun.disegnoScenario();
                    scenRovLun.descrizioneScenario();
                    scenRovLun.setUsato(true);
                    break;
                } else {
                    System.out.println("Scelta non valida o zona già visitata, riprova.");
                }
            }
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }


    public void primoHacking(Persona persona){

        System.out.println("I tuoi HP: " + gu.controlloHp(persona));

        int puntiErrati = 0;

        for (int i = 1; i <= 3; i++) {
            int num1 = (int) (Math.random() * 10) + 1;
            int num2 = (int) (Math.random() * 10) + 1;

            System.out.print("Quanto fa " + num1 + " * " + num2 + "? ");
            int rispostaUtente = scanner.nextInt();

            if (rispostaUtente == num1 * num2) {
                System.out.println("Risposta corretta!");
            } else {
                System.out.println("Risposta sbagliata, la risposta corretta è: " + (num1 * num2));
                puntiErrati++;
            }
        }


        switch (puntiErrati){
            case 0:
                System.out.println("Hai risposto correttamente a tutte le domande! Nessuna penalità.");
                break;
            case 1:
                System.out.println("Hai commesso " + puntiErrati + " errore/i. I tuoi HP verranno ridotti.");
                gu.perdiHp(persona);
                break;
            case 2:
                System.out.println("Hai commesso " + puntiErrati + " errore/i. I tuoi HP verranno ridotti.");
                gu.perdiHp(persona);
                gu.perdiHp(persona);
                break;
            case 3:
                System.out.println("Hai commesso " + puntiErrati + " errore/i. I tuoi HP verranno ridotti.");
                gu.perdiHp(persona);
                gu.perdiHp(persona);
                gu.perdiHp(persona);
                break;
            default:
                System.out.println("Non dovrebbe manco esistere questo caso di default");
        }

        System.out.println("I tuoi HP finali: " + gu.controlloHp(persona));
    }

    //Al momento inutilizzato ma contiene esercizio .filter
    public List<BaseScenary> metodoPerFiltrareScenariUsati(List<BaseScenary> lista){
        // Filtra gli scenari che non sono stati usati
        return lista.stream()
                .filter(scenario -> !scenario.isUsato())  // Solo gli scenari non usati
                .collect(Collectors.toList());
    }

    public void secondoHacking(Persona persona) {
        Scanner scanner = new Scanner(System.in);

        // Stampa gli HP dell'utente
        System.out.println("I tuoi HP: " + gu.controlloHp(persona));

        // Segni Zodiacali e intervalli di date
        String[] datiGenerati = gu.generaDataCasuale();
        String dataCasuale = datiGenerati[0];
        String segnoCorretto = datiGenerati[1];

        System.out.println("Data generata: " + dataCasuale);

        // Fai scegliere all'utente il segno zodiacale
        System.out.println("Indovina il segno zodiacale:");
        System.out.println("1) Ariete");
        System.out.println("2) Toro");
        System.out.println("3) Gemelli");
        System.out.print("Inserisci il numero corrispondente al segno: ");

        int scelta = scanner.nextInt();

        // Controlla se la risposta è corretta
        if (gu.verificaRisposta(scelta, segnoCorretto)) {
            System.out.println("Corretto! La data appartiene a " + segnoCorretto + ".");
            System.out.println(gu.asciiZodiaco(segnoCorretto));
            gu.controlloHp(persona);
        } else {
            System.out.println("Sbagliato! La risposta giusta era " + segnoCorretto + ".");
            System.out.println(gu.asciiZodiaco(segnoCorretto));
            gu.perdiHp(persona);
            gu.perdiHp(persona);
        }
    }


    public void terzoHacking(Persona persona) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int numeroSegreto = random.nextInt(100) + 1;
        int tentativo = -1;
        int tentativiEffettuati = 0;
        int tentativiMassimi = 10;

        System.out.println("Per hackerare questo Computer devi indovinare il numero segreto in 10 tentativi.");
        System.out.println("Se non dovessi indovinarlo, perderai HP.");
        System.out.println("Hai " + tentativiMassimi + " tentativi per indovinarlo.");

        while (tentativiEffettuati < tentativiMassimi) {
            System.out.print("Inserisci un numero: ");

            if (scanner.hasNextInt()) {
                tentativo = scanner.nextInt();
                scanner.nextLine(); // Pulisce il buffer
                tentativiEffettuati++;

                if (tentativo > numeroSegreto) {
                    System.out.println("Troppo grande!");
                } else if (tentativo < numeroSegreto) {
                    System.out.println("Troppo piccolo!");
                } else {
                    System.out.println("Corretto! Hai indovinato in " + tentativiEffettuati + " tentativi.");
                    return;
                }
            } else {
                System.out.println("Input non valido! Devi inserire un numero.");
                scanner.nextLine(); // Consuma l'input errato
            }
        }

        // Se si esce dal ciclo, significa che l'utente ha esaurito i tentativi
        System.out.println("Hai esaurito i tentativi! Il numero corretto era " + numeroSegreto + ".");

        // Perdita di HP
        for (int i = 0; i < 4; i++) {
            gu.perdiHp(persona);
        }
    }





}

