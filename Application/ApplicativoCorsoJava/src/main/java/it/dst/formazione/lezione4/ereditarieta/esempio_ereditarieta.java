package it.dst.formazione.lezione4.ereditarieta;

public class esempio_ereditarieta {

    public static void esempio_auto() {
        Auto auto = new Auto();
        auto.tipo = "Automobile";
        auto.numeroPorte = 4;
        auto.accendi();
        auto.mostraDettagli();
    }

    public static void lezione9() {
        Auto miaAuto = new Auto();
        miaAuto.accendi();
        miaAuto.avvia(); // Output: Il veicolo sta partendo.

    }

}
