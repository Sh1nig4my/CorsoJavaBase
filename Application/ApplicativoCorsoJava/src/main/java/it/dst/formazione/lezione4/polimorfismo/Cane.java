package it.dst.formazione.lezione4.polimorfismo;

public class Cane extends Animale {
    @Override
    public void emettiSuono() {
        System.out.println("Il cane abbaia.");
    }
}
