package org.example.giocatore;

import java.util.Scanner;

public class Persona {
    String nome;
    int eta;
    String provenienza;

    public String getProvenienza() {
        return provenienza;
    }

    public void setProvenienza(String provenienza) {
        this.provenienza = provenienza;
    }

    public Persona() {
        this.nome = nome;
        this.eta = eta;

        this.provenienza = provenienza;
    }


    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }


    public void setEta(int eta) {
        this.eta = eta;
    }

    public static Persona creaPersonaggio() {
        Scanner scanner = new Scanner(System.in);
        Persona personaggio = new Persona();
        System.out.println("Benvenuto in Cosmic Impact!\nCome ti chiami.\nInserisci nome: ");

        personaggio.setNome(scanner.nextLine());
        System.out.println("Benvenuto comandante: " + personaggio.getNome());
        System.out.println("Da che pianeta provieni?");
        personaggio.setProvenienza(scanner.nextLine());
        System.out.println("NOME-> " + personaggio.getNome());
        System.out.println("PIANETA DI PROVENIENZA-> " + personaggio.getProvenienza() + "\n");
        System.out.println("La tua navicella dopo aver impattato un asteroide ha attivato il sistema di sicurezza che prevede l'ibernazione dell'equipaggio.\nAvete vagato per 3 anni nello spazio, ma purtroppo sei l'unico sopravvissuto.\nPer tua fortuna sei approdato in questa stazione spaziale abbadonata.\nBenvenuto a EPSILON 9!\n\nMISSIONE: Trova il modo di riparare la tua nave e tornare sul Pianeta " + personaggio.getProvenienza());
        System.out.println("Bene " + personaggio.getNome() + " Possiamo iniziare!\n\nSei nella sala principale,buia e cupa, della stazione spaziale.\n\nDavanti a te hai tre percorsi\n");
        return personaggio;
    }






}
