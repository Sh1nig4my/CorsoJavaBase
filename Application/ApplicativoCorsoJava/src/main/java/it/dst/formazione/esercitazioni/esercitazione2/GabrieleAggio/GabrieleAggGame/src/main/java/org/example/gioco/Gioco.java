package org.example.gioco;

import org.example.personaggio.Persona;
import org.example.personaggio.Recluta;
import org.example.personaggio.Soldato;
import org.example.personaggio.Tecnico;
import org.example.scenario.BaseScenary;
import org.example.scenario.ScenarioLaboratorio;
import org.example.scenario.ScenarioNaveSpazialeNemica;
import org.example.scenario.ScenarioRoverLunare;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Gioco {

    Scanner scanner = new Scanner(System.in);
    Persona personaggioScelto;
    ScenarioLaboratorio scenLab = new ScenarioLaboratorio();
    ScenarioNaveSpazialeNemica scenNavSpazNem = new ScenarioNaveSpazialeNemica();
    ScenarioRoverLunare scenRovLun = new ScenarioRoverLunare();

    public List<BaseScenary> listeScenari = new ArrayList<>();

    GiocoUtils gu = new GiocoUtils();


    public Persona scegliPersonaggio(){

        try {

            String sceltaPersonaggio;
            while (true) {
                System.out.println(" ------------------------ ");
                System.out.println("Scegli il tipo di protagonista da usare:");
                System.out.println("1. Tecnico [Facile]");
                System.out.println("2. Soldato [Medio]");
                System.out.println("3. Recluta [Difficile]");
                System.out.println(" ------------------------ ");
                System.out.print("Inserisci la tua scelta (1-3): ");
                sceltaPersonaggio = scanner.nextLine();

                // Se la scelta è valida 1, 2, o 3, usciamo dal ciclo
                if (sceltaPersonaggio.equals("1") || sceltaPersonaggio.equals("2") || sceltaPersonaggio.equals("3")) {
                    break;
                } else {
                    System.out.println("Scelta non valida, riprova (1, 2 o 3).");
                }
            }

            System.out.print("Inserisci il nome del tuo personaggio: ");
            String nome = scanner.nextLine();

            switch (sceltaPersonaggio) {
                case "1":
                    return new Tecnico(nome, 50);
                case "2":
                    return new Soldato(nome, 30);
                case "3":
                    return new Recluta(nome, 20);
                default:
                    System.out.println("Scelta non valida, riprova.");
                    return null;
            }
        } catch (InputMismatchException ex){
            System.out.println("Errore, Inserisci la tua scelta (1-3):");
        }
        return personaggioScelto;
    }

//    public void sceltaSvolta(){
//        try {
//
//            String scelta;
//            while (true) {
//                System.out.println(" ------------------------ ");
//                System.out.println("Quale zona vuoi visitare:");
//                System.out.println("Laboratorio");
//                System.out.println("Nave spaziale");
//                System.out.println("Rover Lunare");
//                System.out.println(" ------------------------ ");
//                System.out.print("Inserisci la tua scelta (1-3): ");
//                scelta = scanner.nextLine();
//
//                // Se la scelta è valida 1, 2, o 3, usciamo dal ciclo
//                if (scelta.equals("1") || scelta.equals("2") || scelta.equals("3")) {
//                    break;
//                } else {
//                    System.out.println("Scelta non valida, riprova (1, 2 o 3).");
//                }
//            }
//
//            switch (scelta) {
//                case "1":
//                    scenLab.disegnoScenario();
//                    scenLab.descrizioneScenario();
//                    scenLab.setUsato(true);
//                    break;
//                case "2":
//                    scenNavSpazNem.disegnoScenario();
//                    scenNavSpazNem.descrizioneScenario();
//                    scenNavSpazNem.setUsato(true);
//                    break;
//                case "3":
//                    scenRovLun.disegnoScenario();
//                    scenRovLun.descrizioneScenario();
//                    scenRovLun.setUsato(true);
//                    break;
//                default:
//                    System.out.println("Scelta non valida, riprova.");
//            }
//
//        } catch (InputMismatchException exception){
//            System.out.println("Errore, riprova");
//        }
//    }
    public void sceltaSvolta() {
        try {
            String scelta;

            // Chiediamo l'utente di scegliere una zona
            while (true) {
                System.out.println(" ------------------------ ");
                System.out.println("Quale zona vuoi visitare:");

                // Mostra tutte le opzioni disponibili (anche quelle già usate, ma le rimuoviamo subito)
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
                scelta = scanner.nextLine();

                // Se la scelta è valida 1, 2, o 3, usciamo dal ciclo
                if (scelta.equals("1") && !scenLab.isUsato()) {
                    scenLab.setUsato(true); // Segna come usato
                    break;
                } else if (scelta.equals("2") && !scenNavSpazNem.isUsato()) {
                    scenNavSpazNem.setUsato(true); // Segna come usato
                    break;
                } else if (scelta.equals("3") && !scenRovLun.isUsato()) {
                    scenRovLun.setUsato(true); // Segna come usato
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
        String[] segni = {"Ariete", "Gemelli", "Bilancia"};
        String segnoCorretto = gu.generaDataCasuale();
        System.out.println(segnoCorretto);

        // Fai scegliere all'utente il segno zodiacale
        System.out.println("Indovina il segno zodiacale:");
        System.out.println("1) Ariete");
        System.out.println("2) Gemelli");
        System.out.println("3) Bilancia");
        System.out.print("Inserisci il numero corrispondente al segno: ");

        int scelta = scanner.nextInt();

        // Controlla se la risposta è corretta
        if (gu.verificaRisposta(scelta, segnoCorretto)) {
            System.out.println("Corretto! La data appartiene a " + segnoCorretto + ".");
        } else {
            System.out.println("Sbagliato! La risposta giusta era " + segnoCorretto + ".");
        }
    }



}
