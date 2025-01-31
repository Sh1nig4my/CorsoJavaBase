package it.dst.formazione.esercitazioni.esercitazione2.FrancescoCalabro.src.main.java.org.EsercitazioneAula.personaggio;

public class Alieno extends Persona {

    public Alieno() {
        super("Morbius", 2437, 150, "Telecinesi");
    }

    @Override
    public void usaSkill(String evento) {
        if (evento.equals("1")) {
            System.out.println("Usi la " + skill + " per sollevare i mercenari e intrappolarli");
        } else if (evento.equals("2")) {
            System.out.println("Usi la " + skill + " per creare un campo di forza e rompere la barriera");
        } else if (evento.equals("3")) {
            System.out.println("Usi la " + skill + " per piegare le sbarre della cella");
        }
    }

    @Override
    public void piuOMenoSalute(String evento) {
        if (evento.equals("1")) {
            System.out.println("Durante il combattimento hai divorato tutti, complimenti hai guadagnato hp: " + (vita + 120));
        } else if (evento.equals("2")) {
            System.out.println("Durante l'azione ti sei ferito, ti rimangono " + (vita - 60) + "HP");
        } else if (evento.equals("3")) {
            System.out.println("E' stato piú difficile del previsto!! hai perso vita e ti sono rimasti: " + (vita - 80) + "HP");
        }
    }

    @Override
    public String toString() {
        return "Alieno {" + "nome= " + nome + ", anni=" + anni + ", vita=" + vita + ", skill= " + skill + '}';
    }
}
