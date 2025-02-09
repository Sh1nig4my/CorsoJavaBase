package it.dst.formazione.lezioni.lezione4.astrazione;

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
