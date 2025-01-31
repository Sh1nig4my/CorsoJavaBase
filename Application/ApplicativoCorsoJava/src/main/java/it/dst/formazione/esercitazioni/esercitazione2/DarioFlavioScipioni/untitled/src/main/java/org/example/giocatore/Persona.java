package org.example.giocatore;

public class Persona {
    String nome;
    int eta;
    int vita;
    String provenienza;

    public String getProvenienza() {
        return provenienza;
    }

    public void setProvenienza(String provenienza) {
        this.provenienza = provenienza;
    }

    public Persona() {
        this.nome = nome;
        this.eta = eta;
        this.vita = vita;
        this.provenienza=provenienza;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
/*public static void creaPersonaggio(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Crea il tuo personaggio!\nScegli il tuo nome\n>");
        String nome= scanner.nextLine();
        System.out.println("Quanti anni hai?\n>");
        int eta=scanner.nextInt();
        System.out.println("Benvenuto "+ nome +"!");
    }*/

}
