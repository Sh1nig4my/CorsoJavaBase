package it.dst.formazione.esercitazioni.esercitazione2.FrancescoCalabro.src.main.java.org.EsercitazioneAula.personaggio;

public class Soldato extends Persona {

    public Soldato() {
        super("Snake", 36, 100, "Maestro delle armi");
    }

    @Override
    public void usaSkill(String evento) {
        if (evento.equals("1")) {
            System.out.println("Usi la " + skill + " per affrontare con il tuo fucile i mercenari");
        } else if (evento.equals("2")) {
            System.out.println("Utilizzi la " + skill + " per distruggere il pannello dei comandi dalla distanza");
        } else if (evento.equals("3")) {
            System.out.println("Sei un soldato! riesci a scassinare la cella ");
        }
    }

    @Override
    public void piuOMenoSalute(String evento) {
        if (evento.equals("1")) {
            System.out.println("Durante il combattimento hai perso hp, ti rimangono " + (vita - 30) + "HP");
        } else if (evento.equals("2")) {
            System.out.println("Sei stato bravo sparando da lontano, non ti sei ferito troppo, ti rimangono " + (vita - 10) + "HP");
        } else if (evento.equals("3")) {
            System.out.println("L'amore di una madre é immenso hai guadagnato hp!! " + (vita + 30) + "HP");
        }
    }

    @Override
    public String toString() {
        return "Soldato {" + "nome= " + nome + ", anni=" + anni + ", vita=" + vita + ", skill= " + skill + '}';
    }

}
