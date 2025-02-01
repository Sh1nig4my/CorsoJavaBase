package it.dst.formazione.esercitazioni.esercitazione2.FrancescoCalabro.src.main.java.org.EsercitazioneAula.personaggio;

public class Androide extends Persona {

    public Androide() {
        super("Pathfinder", 1763, 200, "Raggio Laser");
    }

    @Override
    public void usaSkill(String evento) {
        if (evento.equals("1")) {
            System.out.println("Usi il " + skill + " per distruggere i mercenari");
            // Logica per affrontare i mercenari con il laser
        } else if (evento.equals("2")) {
            System.out.println("Usi il " + skill + " per hackerare la barriera");
            // Logica per affrontare la barriera con il laser
        } else if (evento.equals("3")) {
            System.out.println("Usi il " + skill + " per liquefare le sbarre");
            // Logica per aprire la cella
        }
    }

    @Override
    public void piuOMenoSalute(String evento) {
        if (evento.equals("1")) {
            System.out.println("Durante il combattimento hai perso hp, ti rimangono " + (vita - 10) + "HP");
        } else if (evento.equals("2")) {
            System.out.println("Ti sei surriscaldato ed hai perso hp, ti rimangono " + (vita - 70) + "HP");
        } else if (evento.equals("3")) {
            System.out.println("Tua madre non ti ha riconosciuto, ti ha danneggiato gravemente!! " + (vita - 100) + "HP");
        }
    }

    @Override
    public String toString() {
        return "Androide {" + "nome= " + nome + ", anni=" + anni + ", vita=" + vita + ", skill= " + skill + '}';
    }

}
