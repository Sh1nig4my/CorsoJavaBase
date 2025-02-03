package org.example.giocatore;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ruolo extends Persona {
    String nome;
    String descrizione;
    List<String> abilita;
    int vita;

    public Ruolo(String nome, String descrizione, List<String> abilita) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.abilita = abilita;
    }

    public Ruolo() {
    }

    @Override
    public int getVita() {
        return vita;
    }

    @Override
    public void setVita(int vita) {
        this.vita = vita;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<String> getAbilita() {
        return abilita;
    }

    public void setAbilita(List<String> abilita) {
        this.abilita = abilita;
    }

    public static Ruolo scegliRuolo() {
        Scanner scanner = new Scanner(System.in);

        int sceltaPersonaggio;

        while (true) {
            System.out.println("\nScegli il tuo ruolo");
            System.out.println("1> Umano");
            System.out.println("2> Alieno");
            System.out.println("3> Robot");
            if (scanner.hasNextInt()) {

                sceltaPersonaggio = scanner.nextInt();
                if (sceltaPersonaggio == 1 || sceltaPersonaggio == 2 || sceltaPersonaggio == 3) {
                    break;
                } else {
                    System.out.println("Puoi scegliere soltanto 1,2 o 3.");
                }
            } else {
                System.out.println("Devi inserire un numero");
                scanner.next();
            }
        }
        Ruolo ruoloGenerico = new Ruolo();
        {
            if (sceltaPersonaggio == 1) {
                ruoloGenerico.setNome("Umano");
                ruoloGenerico.setDescrizione("L'umano è un personaggio equilibrato tra attacco e difesa, consigliato per chi si approccia al gioco per la prima volta.");
                ruoloGenerico.setVita(100);
                ruoloGenerico.setAbilita(Arrays.asList("Empatico", "EquilibrioInteriore"));

            } else if (sceltaPersonaggio == 2) {
                ruoloGenerico.setNome("Alieno");
                ruoloGenerico.setDescrizione("L'alieno è un personaggio che punta molto sul suo equipaggiamento innovativo, ha pochi punti vita, ma un attacco alto. ");
                ruoloGenerico.setVita(50);
                ruoloGenerico.setAbilita(Arrays.asList("IngegnoSuperiore", "PotenteArsenale"));


            } else {
                ruoloGenerico.setNome("Robot");
                ruoloGenerico.setDescrizione("Il robot è un personaggio molto resistente, con un attacco basso, ma con molti punti vita. ");
                ruoloGenerico.setVita(150);
                ruoloGenerico.setAbilita(Arrays.asList("ScudoDifensivo", "Intoccabile"));
            }

        }
        System.out.println("\nClasse selezionata: " + ruoloGenerico.getNome() + "\nPunti vita: " + ruoloGenerico.getVita() + "\nAbilità: " + ruoloGenerico.getAbilita());
        return ruoloGenerico;
    }
}
