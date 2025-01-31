package org.example;

import org.example.ambientazione.Scenario;
import org.example.eventi.Eventi;
import org.example.giocatore.Persona;
import org.example.giocatore.Ruolo;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona personaggio = new Persona();
        System.out.println("Benvenuto in Cosmic Impact!\nCome ti chiami.\nInserisci nome: ");
        personaggio.setNome(scanner.nextLine());
        LocalDateTime inizio = LocalDateTime.now();
        System.out.println("Benvenuto comandante: " + personaggio.getNome());
        System.out.println("Da dove provieni?\n>");
        personaggio.setProvenienza(scanner.nextLine());
        System.out.println("La tua navicella dopo aver impattato un asteroide ha attivato il sistema di sicurezza che prevede l'ibernazione dell'equipaggio.\nAvete vagato per 3 anni nello spazio, ma purtroppo sei l'unico sopravvissuto.\nPer tua fortuna sei approdato in questa stazione spaziale abbadonata.\nBenvenuto a EPSILON 9.\nTrova il modo di riparare la tua nave e tornare sul Pianeta " + personaggio.getProvenienza());

        System.out.println("Scegli il tuo ruolo");
        Ruolo umano = new Ruolo("Umano ", "L'umano è un personaggio equilibrato tra attacco e difesa, consigliato per chi si approccia al gioco per la prima volta. ", Arrays.asList("Empatico", "Equilibrato"));
        Ruolo alieno = new Ruolo("Alieno ", "L'alieno è un personaggio che punta molto sul suo equipaggiamento innovativo, ha pochi punti vita, ma un attacco alto. ", Arrays.asList("Innovativo", "PotenteArsenale"));
        Ruolo robot = new Ruolo("Robot", "Il robot è un personaggio molto resistente, con un attacco basso, ma con molti punti vita. ", Arrays.asList("ScudoDifensivo", "Intoccabile"));
        System.out.println(">1 " + umano.getNome() + "Spiegazione: " + umano.getDescrizione() + "Abilità: " + umano.getAbilita());
        System.out.println(">2 " + alieno.getNome() + "Spiegazione: " + alieno.getDescrizione() + "Abilità: " + alieno.getAbilita());
        System.out.println(">3 " + robot.getNome() + "Spiegazione: " + robot.getDescrizione() + "Abilità: " + robot.getAbilita());


        int sceltaPersonaggio = scanner.nextInt();
        if (sceltaPersonaggio == 1) {
            System.out.println("Hai scelto: " + umano.getNome().toUpperCase());
        } else if (sceltaPersonaggio == 2) {
            System.out.println("Hai scelto: " + alieno.getNome().toUpperCase());

        } else if (sceltaPersonaggio == 3) {
            System.out.println("Hai scelto: " + robot.getNome().toUpperCase());

        } else {
            System.out.println("Non corrisponde a nessuna classe");
        }

        /*switch (sceltaPersonaggio) {
            case 1:
                System.out.println("Hai scelto: " + umano.getNome().toUpperCase());
                break;

            case 2:
                System.out.println("Hai scelto: " + alieno.getNome().toUpperCase());
                break;

            case 3:
                System.out.println("Hai scelto: " + robot.getNome().toUpperCase());

            default:
                System.out.println("Non corrisponde a nessuna classe");*/

        Scenario percorso1 = new Scenario("Corridoio buio, sembra pericoloso");
        Scenario percorso2 = new Scenario("Sala macchine");
        Scenario percorso3 = new Scenario("Dormitori");

        System.out.println("Bene " +personaggio.getNome() + " Possiamo iniziare!\n Sei nella sala principale della stazione spaziale.\nDavanti a te hai tre percorsi\n");
        System.out.println("1> " + percorso1.getPercorso());
        System.out.println("2> " + percorso2.getPercorso());
        System.out.println("3> " + percorso3.getPercorso());
        System.out.println("\nDove vuoi andare?\n>");
        int sceltaPercorso = scanner.nextInt();


        if (sceltaPercorso == 1) {
            System.out.println("Ti trovi nel " + percorso1.getPercorso());
        } else if (sceltaPercorso == 2) {
            System.out.println("Ti trovi nella " + percorso2.getPercorso());
        } else if (sceltaPercorso == 3) {
            System.out.println("Ti trovi nei " + percorso3.getPercorso());
        } else {
            System.out.println("Scelta non valida");
        }
        Eventi.generaAvvenimentoRandom();
    }
}
