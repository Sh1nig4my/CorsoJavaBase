package it.dst.formazione.lezione4.incapsulamento;

public class ContoBancario {

    private String titolare;
    private double saldo;

    public ContoBancario(String titolare, double saldoIniziale) {
        this.titolare = titolare;
        this.saldo = saldoIniziale;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposita(double importo) {
        if (importo > 0) {
            saldo += importo;
        } else {
            System.out.println("L'importo deve essere positivo.");
        }
    }

    public void preleva(double importo) {
        if (importo > 0 && importo <= saldo) {
            saldo -= importo;
        } else {
            System.out.println("Saldo insufficiente o importo non valido.");
        }
    }
}
