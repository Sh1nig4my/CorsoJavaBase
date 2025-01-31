package it.dst.formazione.esercitazioni.esercitazione2.FrancescoCalabro.src.main.java.org.EsercitazioneAula.personaggio;

public class SceltaPersonaggio {

    public static Persona selezione(Integer scelta) {

        Persona persona = null;

        switch (scelta) {
            case 1:
                persona = new Androide();
                System.out.println("Ecco il tuo personaggio : " + persona);
                break;
            case 2:
                persona = new Soldato();
                System.out.println("Ecco il tuo personaggio : " + persona);
                break;
            case 3:
                persona = new Alieno();
                System.out.println("Ecco il tuo personaggio : " + persona);
                break;
            default:
                System.out.println("Nessun numero corretto immesso");
                break;
        }

        return persona;
    }
}
