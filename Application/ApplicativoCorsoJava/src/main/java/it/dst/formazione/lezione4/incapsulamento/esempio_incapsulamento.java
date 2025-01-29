package it.dst.formazione.lezione4.incapsulamento;

public class esempio_incapsulamento {

    public static void esempio_contobancario() {
        ContoBancario conto = new ContoBancario("Mario Rossi", 1000);
        conto.deposita(500);
        System.out.println("Saldo attuale: " + conto.getSaldo());
        conto.preleva(300);
        System.out.println("Saldo dopo il prelievo: " + conto.getSaldo());

    }

}
