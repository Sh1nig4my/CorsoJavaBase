package it.dst.formazione.lezione4.polimorfismo;

public class esempio_polimorfismo {

    public static void esempio_animali() {
        Animale animale1 = new Cane();
        Animale animale2 = new Gatto();
        Animale animale3 = new Animale();

        animale1.emettiSuono();
        animale2.emettiSuono();
        animale3.emettiSuono();
    }
}
