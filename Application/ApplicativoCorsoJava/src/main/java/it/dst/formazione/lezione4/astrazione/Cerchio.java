package it.dst.formazione.lezione4.astrazione;

class Cerchio extends Forma {
    double raggio;

    public Cerchio(double raggio) {
        this.raggio = raggio;
    }

    @Override
    double calcolaArea() {
        return Math.PI * raggio * raggio;
    }
}
