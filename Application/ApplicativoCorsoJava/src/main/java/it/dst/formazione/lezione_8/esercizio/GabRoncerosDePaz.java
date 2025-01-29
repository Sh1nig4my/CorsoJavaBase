//package it.dst.formazione.lezione_8.esercizio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Collectors;

class Studente {
    private String nome;
    private int eta;
    private double voto;

    public Studente(String nome, int eta, double voto) {
        this.nome = nome;
        this.eta = eta;
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public double getVoto() {
        return voto;
    }

    @Override
    public String toString() {
        return nome + " (" + eta + " anni) - Voto: " + voto;
    }
}

public class GabRoncerosDePaz {
    public static void main(String[] args) {
        List<Studente> studenti = Arrays.asList(
                new Studente("Alice", 22, 28),
                new Studente("Carlo", 24, 30),
                new Studente("GianGiorgio", 21, 18),
                new Studente("Gab", 29, 18));

        // 1 Utilizzare Stream API per processare collezioni di dati in modo
        // dichiarativo
        // Filtro gli studenti con un voto maggiore di 25
        List<Studente> studentiMeritevoli = studenti.stream()
                .filter(studente -> studente.getVoto() >= 25)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));

        System.out.println("Studenti con voto >= 25:");
        studentiMeritevoli.forEach(System.out::println);
        // 2 Implementare Optional per gestire valori nulli senza rischiare eccezioni
        // Troviamo lo studente con il voto più alto
        Optional<Studente> topStudente = studenti.stream()
                .max(Comparator.comparingDouble(Studente::getVoto));

        // 2b Gestiamo il caso in cui la lista potrebbe essere vuota
        // 3 Combinare le due tecnologie per creare un'applicazione robusta e leggibile.
        // Gestiamo il caso in cui la lista potrebbe essere vuota con ifPresentOrElse
        topStudente.ifPresentOrElse(
                studente -> System.out.println("\nMiglior studente: " + studente),
                () -> System.out.println("\nNessuno studente presente."));
    }
}
