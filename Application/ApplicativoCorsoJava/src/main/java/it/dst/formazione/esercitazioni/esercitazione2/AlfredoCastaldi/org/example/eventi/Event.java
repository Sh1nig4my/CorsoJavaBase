package org.example.eventi;

import org.example.gameplay.GameState;
import org.example.player.Personaggio;
import org.example.scenari.LaboratorioIncredibile;
import org.example.scenari.Scenes;
import org.example.scenari.Ambulatorio;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public abstract class Event {

    // questa proprietà rappresenta la posizione attuale del giocatore, necessaria per determinare a quali eventi può essere soggetto
    public static Scenes currentScene = new Ambulatorio();

    // questo pointer al giocatore instanziato è necessario per poter richiamare o settare le proprietà dentro giocatore
    // come conseguenza di un evento nel caso l'evento lo prevedesse
    protected Personaggio target = GameState.getUserCharacterInstance();
    // descrizione evento
    protected String messaggioEvento;
    // da implementare
    protected Optional<String> possibleReward;

    // questa è la mappa delle conseguenze, la chiave è un intero e corrisponde alla scelta del giocatore
    // il valore è la collection di possibili outcome legata alla scelta del giocatore
    // può capitare che una di queste liste abbia un valore solo perchè magari
    // è stato deciso che quell'evento dovesse avere un solo outcome
    protected Map<Integer, List<EventActions> > eventConsequences = new HashMap<>();
    // questa è una mappa che serve ad associare un input del giocatore ad un messaggio, esempio
    // 1 provi a schivare, questo 1 verrà usato come chiave per prendere la lista delle conseguenze
    protected Map<Integer, String> avaibleActions;


    public Event(String messaggioEvento,   String possibleReward) {
        this.messaggioEvento = messaggioEvento;
        // ricompense ancora da implementare, invece di string userò un oggetto che rappresenta un item dell'inventario
        // è ancora possibile passare null al costruttore evento
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
        String userChoice;

        EventActions result = null;
        Optional<Map<Integer, List<EventActions>>> eventConsequencesOtp = Optional.ofNullable(this.eventConsequences);
        while (true) {
            if (eventConsequencesOtp.isPresent()) {
                 userChoice = input.nextLine();
                if (isInputANumber(userChoice)) {
                    if (this.eventConsequences.get(Integer.parseInt(userChoice)).size() == 1 ) {
                        result = this.eventConsequences.get(Integer.parseInt(userChoice)).get(0);
                        break;
                    } else {
                    result = this.eventConsequences.get(Integer.parseInt(userChoice)).get(rng.nextInt(0, this.eventConsequences.size() - 1));
                    break;
                    }
                } else {
                    System.out.println("please insert a number");
                }
            } else {
                throw new RuntimeException("errore la mappa consequenze eventi è null");
            }
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

    // questo permette al giocatore di muoversi tra i vari scenari
    // ogni scenario è " collegato " ad altri scenari tramite la propria proprietà
    // newPossibleDirections
    // ed è per questo che ho trovato importante la gestione della proprietà currentScene
    // al cambiare dello scenario quindi della currentscene i luoghi su cui spostarsi cambiano

    public void moveChoice(Scanner input ){
        System.out.println("dove vuoi andare adesso?");
        currentScene.newPossibleDirections.forEach(
                (k,v)->{
                    System.out.println(k + ": " + v.getSimpleName());
                }
        );
        String userChoice;
        while (true) {
            userChoice = input.nextLine();
        if (isInputANumber(userChoice)) {
                try {
                    Optional<Scenes> currentSceneOtp = Optional.ofNullable(currentScene.newPossibleDirections.get(Integer.parseInt(userChoice)).getConstructor().newInstance());
                    currentScene = currentSceneOtp.orElseThrow(()->{throw new RuntimeException("scenario non trovato");});
                    break;
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace().toString());
                }
            } else {
                System.out.println("please insert a valid number");
            }
        }

    }



    @Override
    public String toString() {
        return "Event{" +
                "messaggioEvento='" + messaggioEvento + '\'' +
                '}';
    }


    // minigioco dell'hacking del computer che può essere invocato tramite evento
    // ancora da implementare una vera ricompensa ed una vera penalità
    public static boolean computerHackingGame(){
        Scanner hackComputerInput = new Scanner(System.in);
        List<Character> password = new ArrayList<>(Arrays.asList('1','2','3','2','3'));
        int tentativi = 3;

        for (int i = 1; i <= tentativi; i++ ){

            System.out.println("la password è composta da " + password.size() + " caratteri, seleziona un carattere da indovinare");
            System.out.println(password.stream().map(value -> "X").toList());

            // non credo che questo input possa generare un eccezione
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
