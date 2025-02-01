package org.example.eventi;

import org.example.gameplay.GameState;
import org.example.player.Personaggio;
import org.example.scenari.Scenes;
import org.example.scenari.Ambulatorio;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public abstract class Event {


    // scenario corrente
    public static Scenes currentScene = new Ambulatorio();

    // protagonista evento
    protected Personaggio target = GameState.getUserCharacterInstance();
    // descrizione evento
    protected String messaggioEvento;
    // da implementare
    protected Optional<String> possibleReward;

    // quello che succeede durante un evento
    protected Map<Integer, List<EventActions> > eventConsequences = new HashMap<>();
    // quello che puoi fare durante un evento da implementare
    protected Map<Integer, String> avaibleActions;

    public Event(String messaggioEvento,   String possibleReward) {
        this.messaggioEvento = messaggioEvento;
        this.possibleReward = Optional.ofNullable(possibleReward);
    }

    public Object runEvent(Scanner input){

        System.out.println(currentScene.getScenaryName() +":");
        Random rng = new Random();
        System.out.println(this.messaggioEvento);
        System.out.println("cosa vuoi fare? ");
        this.avaibleActions.forEach(
                (k,v)->{
                    System.out.println(k + ": " + v);
                }
        );
        String userChoice = input.nextLine(); // è un finto input, devo sistemare
        EventActions result = null;
        if (this.eventConsequences.get(Integer.parseInt(userChoice)).size() == 1 ) {
            result = this.eventConsequences.get(Integer.parseInt(userChoice)).get(0);
        } else {
         result = this.eventConsequences.get(Integer.parseInt(userChoice)).get(rng.nextInt(0, this.eventConsequences.size()-1));
        }
        return result.getConsequence(target);
    }

    public boolean isInputANumber(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public void moveChoice(Scanner input ){
        System.out.println("dove vuoi andare adesso?");
        currentScene.newPossibleDirections.forEach(
                (k,v)->{
                    System.out.println(k + ": " + v.getSimpleName());
                }
        );
        String userChoice = input.nextLine();
        if (isInputANumber(userChoice)) {
            try {
                currentScene = currentScene.newPossibleDirections.get(Integer.parseInt(userChoice)).getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("solution for wrong input to be implemented yet !!!!");
        }

    }


    @Override
    public String toString() {
        return "Event{" +
                "messaggioEvento='" + messaggioEvento + '\'' +
                '}';
    }

    public static boolean computerHackingGame(){
        Scanner hackComputerInput = new Scanner(System.in);
        List<Character> password = new ArrayList<>(Arrays.asList('1','2','3','2','3'));
        int tentativi = 3;

        for (int i = 1; i <= tentativi; i++ ){

            System.out.println("la password è composta da " + password.size() + " caratteri, seleziona un carattere da indovinare");
            System.out.println(password.stream().map(value -> "X").toList());

            Character userChoice = hackComputerInput.next().charAt(0);
            if (password.contains(userChoice)) {
                System.out.println("hai indovinato");
                password.removeIf(character -> character.equals(userChoice));
            } else {
                System.out.println("ti rimangono: " + (tentativi - i) + " tentativi");
            }
            if (password.isEmpty()) {
                System.out.println("hai vinto");
                return true;
            }

        }
        System.out.println("tentativi terminati, hai perso");
        return false;
    }
}
