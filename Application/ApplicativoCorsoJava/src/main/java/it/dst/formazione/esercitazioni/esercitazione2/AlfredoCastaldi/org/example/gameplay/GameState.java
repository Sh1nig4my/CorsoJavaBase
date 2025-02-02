package org.example.gameplay;

import org.example.player.Personaggio;
import org.example.player.AstralBerserker;
import org.example.player.SpaceMagician;
import org.example.player.StormTrooper;
import org.example.eventi.Event;

import java.lang.reflect.InvocationTargetException;
import java.sql.Time;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameState {

    LocalDateTime time;
    LocalDateTime time2;

    private static Personaggio userCharacterInstance;

    // una collection delle disponibili classi java da instanziare come ruolo per il giocatore

    public static Personaggio getUserCharacterInstance() {
        return userCharacterInstance;
    }

    Map<Integer, Class<? extends Personaggio>> classiDisponibili = Map.of(
            1, AstralBerserker.class,
            2, SpaceMagician.class,
            3, StormTrooper.class
    );

    private Scanner input = new Scanner(System.in);


    // il codice che permette al giocatore di scegliere nome età e la classe da instanziare che diventerà il suo ruolo

    public void choseClass(){
        System.out.println("scegli la tua classe: ");
        classiDisponibili.forEach(
                (chiave, classe)->{
                        System.out.println(chiave + ": " + classe.getSimpleName());
                }
        );
        String userChoice;
        Class<? extends Personaggio> userCharacter;
        while (true){
            userChoice = input.nextLine();
            if (isInputNumber(userChoice)) {
                userCharacter = this.classiDisponibili.get(Integer.parseInt(userChoice));
                break;
            } else {
                System.out.println("please insert a valid value");
            }
        }
        // scelta nome
        System.out.println("what is your name?");
        String userName = input.nextLine();
        // scelta anni check dell'input
        System.out.println("and what is your age? ");
        String userAgeChoice;
        int userAge = getIntInput(input);

        Personaggio result = null;

        try {
            result = userCharacter.getDeclaredConstructor(String.class, Integer.class).newInstance(userName, userAge);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e){
            System.out.println(e.getStackTrace());
        }

        if (result != null) {
        userCharacterInstance = result;
        System.out.println("sei un: " + result);
        } else {
        userCharacterInstance = new AstralBerserker("default name", 99);
        System.out.println("un errore è stato riscontrato nella creazione della classe");
        }

    }


    private int getIntInput(Scanner input){
        while (true){
            String userAge = input.nextLine();
            if (isInputNumber(userAge)) {
               return Integer.parseInt(userAge);
            } else {
                System.out.println("please insert a valid value");
            }
        }
    }

    // qui voglio gestire il flusso del gioco, per adesso il loop termina al ritorno di un booleano di un certo evento
    // termina se il field del giocatore va a 0 o meno, e ricomincia quando l'evento ritorna una stringa dal suffisso LOOK
    // per permettere al giocatore di scegliere se fermarsi ad esplorare o muoversi

    public void runScenario(){

        while (true) {

         Event evento = Event.currentScene.randomEvent();
         Object result = evento.runEvent(input);
         if (result instanceof Boolean) {
             if ((Boolean) result){
                 System.out.println("hai vinto grande");
                 time2 = LocalDateTime.now();
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss");
                 System.out.println("tempo iniziale: " + formatter.format(time) + " tempo finale: " + formatter.format(time2));
                 break;
             }
         }
         if (result instanceof String){
             System.out.println(result);
             if (((String) result).startsWith("LOOK")){
                 continue;
             }
         }
        if (userCharacterInstance.getVita() <= 0){
            System.out.println("sei morto");
            time2 = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss");
            System.out.println("tempo iniziale: " + formatter.format(time) + " tempo finale: " + formatter.format(time2));
            break;
        }

            evento.moveChoice(input);

        }
    }

    private boolean isInputNumber(String input){
        try {
        Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    //  Definizione dell'ambientazione: Il gioco si svolge sulla stazione spaziale abbandonata "Epsilon 9".
    //  Descrivi il contesto e gli obiettivi della missione.

    public void gameInit(){

        time = LocalDateTime.now();
        System.out.println(" Healbot: bzzz... ah... you finally awake... bzzz... \n" +
                " [downloading.language.ita........terminated], hey bzzz... sei sveglio finalmente!... \n" +
                " le tue funzioni vitali sembrano stabili, benvenuto sulla stazione Epsilon 9, l'ultimo baluardo per il progetto benesis \n" +
                " ( fasci verdi dall'unico occhio della macchina attraversano il tuo corpo più e più volte ) bzzz... [scanning...] \n" +
                " oh.. bzzz... non riesco a determinare la tua mansione... prego inserire manualmente la mansione assegnata");
    }
    public void gameContext(){
        System.out.println("Healbot: bene, benvenuto a bordo " + userCharacterInstance.getNome() + " sei stato risvegliato dopo l'incidente vicino ai laboratori" +
                " dove delle scimmie assassine hanno preso il controllo della nave, la tua missione attuale è di ristabilire l'ordine prendendole a pugni" +
                " buona fortuna");
    }


}
