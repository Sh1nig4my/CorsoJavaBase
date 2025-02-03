import java.util.Random;

abstract class Personaggio {
    String nome;
    int vita;
    int anni;
    int punti_feriti;

    public Personaggio(String nome, int vita, int anni, int punti_feriti) {
        this.nome = nome;
        this.vita = vita;
        this.anni = anni;
        this.punti_feriti = punti_feriti;
    }

    public abstract void descrizione();

    public void subireDanno(int danno) {
        vita -= danno;
        if (vita < 0) vita = 0;
        System.out.println(nome + " ha subito " + danno + " danni! Vita rimanente: " + vita);
    }

    public int calcolaDanno() {
        // Implementazione di danno in base a probabilità o abilità del personaggio
        return new Random().nextInt(20) + 10; // Esempio di danno
    }

    public boolean tentativoHacking() {
        // Implementazione di probabilità di successo dell'hacking
        return new Random().nextInt(100) < 50; // 50% di probabilità di successo
    }

    public int getVita() {
        return vita;
    }
}

class PirataSpaziale extends Personaggio {
    public PirataSpaziale() {
        super("Barbarino", 90, 43, 50);
    }

    public void descrizione() {
        System.out.println("Pirata con barba corta gialla in cerca di monete, in salute");
        System.out.println("\n ----- Statistiche  ------");
        System.out.println("Nome: " + nome);
        System.out.println("Vita: " + vita);
        System.out.println("Anni: " + anni);
        System.out.println("Punti feriti: " + punti_feriti);
    }
}

class Androide extends Personaggio {
    public Androide() {
        super("C17", 150, 63, 30);
    }

    public void descrizione() {
        System.out.println("Androide in latta resistente ma debole");
        System.out.println("\n ----- Statistiche  ------");
        System.out.println("Nome: " + nome);
        System.out.println("Vita: " + vita);
        System.out.println("Anni: " + anni);
        System.out.println("Punti feriti: " + punti_feriti);
    }
}

class Alieno extends Personaggio {
    public Alieno() {
        super("Alieno", 50, 200, 120);
    }

    public void descrizione() {
        System.out.println("Alieno blu secco ma con tanta tecnologia a disposizione");
        System.out.println("\n ----- Statistiche  ------");
        System.out.println("Nome: " + nome);
        System.out.println("Vita: " + vita);
        System.out.println("Anni: " + anni);
        System.out.println("Punti feriti: " + punti_feriti);
    }
}


