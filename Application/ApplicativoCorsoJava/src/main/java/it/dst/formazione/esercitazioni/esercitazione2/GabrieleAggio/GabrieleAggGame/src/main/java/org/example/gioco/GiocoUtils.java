package org.example.gioco;

import org.example.personaggio.Persona;
import org.example.personaggio.Recluta;
import org.example.personaggio.Soldato;
import org.example.personaggio.Tecnico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class GiocoUtils {

    public int controlloHp(Persona giocatore){

        int hp = 0;

        if (giocatore instanceof Recluta) {
            Recluta recluta = (Recluta) giocatore; // Cast a Recluta
            hp = recluta.getHp();
        } else if (giocatore instanceof Soldato) {
            Soldato soldato = (Soldato) giocatore; // Cast a Soldato
            hp = soldato.getHp();
        } else if (giocatore instanceof Tecnico) {
            Tecnico tecnico = (Tecnico) giocatore; // Cast a Tecnico
            hp = tecnico.getHp();
        } else {
            System.out.println("Errore: Tipo di personaggio sconosciuto.");
        }
        return hp;
    }

    public void perdiHp(Persona giocatore){

        if (giocatore instanceof Recluta) {
            Recluta recluta = (Recluta) giocatore; // Cast a Recluta
            int nuoviHP = recluta.getHp() - 20;
            recluta.setHp(nuoviHP);
        } else if (giocatore instanceof Soldato) {
            Soldato soldato = (Soldato) giocatore; // Cast a Soldato
            int nuoviHP = soldato.getHp() - 20;
            soldato.setHp(nuoviHP);
        } else if (giocatore instanceof Tecnico) {
            Tecnico tecnico = (Tecnico) giocatore; // Cast a Tecnico
            int nuoviHP = tecnico.getHp() - 20;
            tecnico.setHp(nuoviHP);
        } else {
            System.out.println("Errore: Tipo di personaggio sconosciuto.");
        }
    }

    public void aumentaHp(Persona giocatore){
        if (giocatore instanceof Recluta) {
            Recluta recluta = (Recluta) giocatore; // Cast a Recluta
            int nuoviHP = recluta.getHp() + 20;
            recluta.setHp(nuoviHP);
        } else if (giocatore instanceof Soldato) {
            Soldato soldato = (Soldato) giocatore; // Cast a Soldato
            int nuoviHP = soldato.getHp() + 20;
            soldato.setHp(nuoviHP);
        } else if (giocatore instanceof Tecnico) {
            Tecnico tecnico = (Tecnico) giocatore; // Cast a Tecnico
            int nuoviHP = tecnico.getHp() + 20;
            tecnico.setHp(nuoviHP);
        } else {
            System.out.println("Errore: Tipo di personaggio sconosciuto.");
        }
    }

    public void gestisciOggettiSegreti(Persona giocatore) {

        Optional<List<String>> oggetti = trovaOggettiSegreti(giocatore);

        oggetti.ifPresentOrElse(
                lista -> {
                    System.out.println(giocatore.getNome() + " ha trovato i seguenti oggetti segreti:");
                    lista.forEach(System.out::println);  // Stampa tutti gli oggetti trovati
                },
                () -> System.out.println(giocatore.getNome() + " non ha trovato alcun oggetto segreto.")
        );
    }

    private Optional<List<String>> trovaOggettiSegreti(Persona giocatore) {

        List<String> oggettiTrovati = new ArrayList<>();

        if (Math.random() < 0.5) {  // 50% di probabilità
            oggettiTrovati.add("Mappa Stazione");
        }

        if (Math.random() < 0.5) {  // 50% di probabilità
            oggettiTrovati.add("Chiave Laboratorio");
        }

        if (Math.random() < 0.5) {  // 50% di probabilità
            oggettiTrovati.add("Pass Sicurezza");
        }

        if (!oggettiTrovati.isEmpty()) {
            return Optional.of(oggettiTrovati);
        } else {
            return Optional.empty();
        }
    }

    public boolean ControlloSconfitta(Persona giocatore){
        if (controlloHp(giocatore) <= 0){
            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣶⣿⣿⡿⠿⠛⠛⠋⠉⠉⠉⠉⠉⠉⠛⠛⠻⢿⣿⣿⣷⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⣿⠿⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠻⣿⣿⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⡿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣿⣦⡀⠀⢀⣠⣤⣶⡄⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⡶⠶⠛⠛⠋⠉⠉⠛⠛⠳⠶⢤⣄⡀⠀⠀⠀⠀⠀⠀⠀⣀⣨⣿⣿⣿⡿⠿⠛⠛⢿⣿⡀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⠞⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢶⣄⣠⣤⣶⣶⡿⠿⠟⠛⠉⠁⢀⣀⠀⠀⠘⣿⣇⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⣠⡾⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣴⣶⣾⣿⠿⠟⠋⠉⠀⢀⣀⣴⡴⣾⣿⣿⣿⣷⡄⠀⢹⣿⡄⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⢀⣾⣿⠇⠀⠀⠀⠀⠀⠀⠀⣴⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⣶⣾⣿⠿⠛⠋⠉⠀⠀⠀⢠⣶⣾⣿⣿⠿⠟⠃⢹⣿⡄⠈⣿⣧⠀⠀⣿⣧⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⣼⣿⡏⠀⠀⠀⠀⠀⠀⠀⣼⠋⠀⠀⠀⢀⣀⣤⣤⣶⣾⡿⠿⠛⠛⠉⠁⢀⣤⣤⣄⠸⣿⣆⠀⠸⣿⡇⢿⣧⠀⢀⣠⠈⣿⣷⣶⣿⡏⠀⠀⠸⣿⣇⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⢠⣿⣿⠁⠀⠀⠀⠀⠀⠀⣸⣏⣠⣤⣶⣿⡿⠿⠟⠛⠉⠀⠀⠀⠀⠀⠀⠀⣾⣿⠻⣿⣧⠹⣿⣆⠀⣿⡇⠸⣿⣿⣿⠿⠇⠸⣿⡏⢻⣿⣆⠀⠀⢿⣿⡀⠀\n" +
                    "⠀⠀⠀⠀⠀⢸⣿⡟⠀⠀⣀⣠⣴⣶⣿⣿⠿⠟⠋⠉⠀⢀⣠⣤⣶⣾⣧⠀⠀⠀⠀⠀⠀⣿⣿⠀⠈⣿⣧⠘⣿⣆⣿⣿⠀⢻⣿⡄⠀⠀⣀⢻⣿⡀⠙⣿⣷⠄⠘⣿⣧⠀\n" +
                    "⠀⠀⠀⢀⣀⣾⣿⣷⣾⡿⠿⠛⠋⠉⠀⠀⣤⣤⠀⢸⣿⡌⣿⣿⠋⠉⠁⠀⠀⠀⠀⠀⠀⠸⣿⣇⠀⢸⣿⡇⠘⣿⣾⣿⠀⠈⣿⣷⣾⣿⡿⠮⠛⠃⠀⢀⣀⣠⣤⣾⣿⠄\n" +
                    "⣴⣶⣾⡿⠿⠛⠛⠉⠁⠀⠀⠀⣶⣿⣆⠀⢹⣿⣧⣸⣿⣧⠸⣿⣦⣤⣶⣆⠀⠀⠀⠀⠀⠀⢻⣿⣄⢀⣿⡇⠀⠘⣿⣿⡆⠀⠘⠛⠉⠁⣀⣠⣤⣶⣾⣿⠿⠟⠛⠉⠁⠀\n" +
                    "⢹⣿⣇⠀⠀⠀⣴⣿⣿⣷⡄⠀⢹⡿⣿⣆⠈⣿⣿⣿⣿⢿⣆⢻⣿⠟⠋⠉⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⡿⠃⠀⠀⠀⠀⣀⣠⣴⣶⣿⣿⠿⠟⠋⢩⣿⣿⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⢿⣿⡀⠀⠀⣿⣟⠈⠛⠋⠀⢸⣿⠈⣿⣆⠸⣿⣻⣿⡾⣿⡌⣿⣇⣀⣤⣴⡆⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⣶⣾⣿⠿⣿⠛⠉⠁⠀⠀⠀⠀⢸⣿⡟⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠸⣿⣧⠀⠀⢻⣿⠀⣶⣾⣧⠘⣿⣷⣾⣿⣆⢿⣧⠉⠁⢻⣧⢹⣿⡿⠿⠛⠃⠀⢀⣀⣤⣴⣶⡾⡿⠟⠋⠛⠉⠁⠀⣰⠏⠀⠀⠀⠀⠀⠀⠀⣿⣿⠇⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⢹⣿⡄⠀⠈⣿⣧⠙⠙⣿⡆⣿⣟⠉⠘⣿⣾⣿⡆⠀⠀⠛⠁⢀⣀⣠⣤⣶⣿⡿⠿⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⣴⠟⠀⠀⠀⠀⠀⠀⠀⣸⣿⡏⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⣿⣷⠀⠀⠘⣿⣷⣴⣿⡏⣿⡿⠀⠀⠈⠉⢀⣀⣠⣴⣶⣿⡿⠿⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⠋⠀⠀⠀⠀⠀⠀⠀⣰⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠸⣿⡆⠀⠀⠈⠛⠛⠋⠀⢀⣀⣤⣴⣶⣿⡿⠿⣿⣋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⢻⣿⡄⢀⣀⣤⣴⣶⣿⠿⠿⠛⠋⠉⠀⠀⠀⠈⠙⠳⢦⣤⣀⣀⠀⠀⠀⠀⠀⢀⣀⣠⣤⠶⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠈⣿⣿⡿⠿⠛⠙⢿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠙⠛⠛⠛⠛⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⣿⣷⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣾⣿⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠿⢿⣿⣷⣦⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣶⣿⣿⡿⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⠿⣿⣿⣿⣿⣷⣶⣶⣶⣾⣿⣿⣿⣿⡿⠿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
            return true;
        }
        return false;
    }

    //Secondo Hacking da qui in poi
    public String generaDataCasuale() {
        Random random = new Random();
        int mese = random.nextInt(6) + 3;  // Mesi tra marzo (3) e agosto (8)
        int giorno;

        switch (mese) {
            case 3: // Ariete
                giorno = random.nextInt(31 - 21) + 21;  // 21-31 marzo
                return "Ariete";
            case 5: // Gemelli
                giorno = random.nextInt(31 - 21) + 21;  // 21-31 maggio
                return "Gemelli";
            case 6: // Gemelli
                giorno = random.nextInt(30 - 21) + 21;  // 21-30 giugno
                return "Gemelli";
            case 9: // Bilancia
                giorno = random.nextInt(30 - 23) + 23;  // 23-30 settembre
                return "Bilancia";
            case 10: // Bilancia
                giorno = random.nextInt(23 - 1) + 1;   // 1-22 ottobre
                return "Bilancia";
            default:
                return "";
        }
    }

    public boolean verificaRisposta(int scelta, String segnoCorretto) {
        if (scelta == 1 && segnoCorretto.equals("Ariete")) {
            return true;
        } else if (scelta == 2 && segnoCorretto.equals("Gemelli")) {
            return true;
        } else if (scelta == 3 && segnoCorretto.equals("Bilancia")) {
            return true;
        }
        return false;
    }
    //Fine secondo hacking







}
