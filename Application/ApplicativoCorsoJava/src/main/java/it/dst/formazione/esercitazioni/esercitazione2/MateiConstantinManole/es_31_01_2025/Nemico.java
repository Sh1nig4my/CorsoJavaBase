import java.util.Random;

class Nemico {
    private String nome;
    private int vita;
    private int attacco;

    public Nemico(String nome, int vita, int attacco) {
        this.nome = nome;
        this.vita = vita;
        this.attacco = attacco;
    }

    public String getNome() {
        return nome;
    }

    public int getVita() {
        return vita;
    }

    public void subireDanno(int danno) {
        vita -= danno;
        if (vita < 0) vita = 0;
        System.out.println(nome + " ha subito " + danno + " danni! Vita rimanente: " + vita);
    }

    public int calcolaDanno() {
        return new Random().nextInt(attacco) + 5;
    }

    public void ataccca(Personaggio personaggio) {
        int danno = new Random().nextInt(attacco) + 5;
        personaggio.subireDanno(danno);
    }
}