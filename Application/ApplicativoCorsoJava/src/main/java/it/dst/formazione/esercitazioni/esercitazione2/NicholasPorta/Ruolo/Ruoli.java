
package it.dst.formazione.esercitazioni.esercitazione2.NicholasPorta.Ruolo;

import it.dst.formazione.esercitazioni.esercitazione2.NicholasPorta.Player.Personaggio;



    public class Ruoli extends Personaggio {

        private String nome;
        private String descrizione;
        private int vita;

        public Ruoli(String nome, String descrizione, int vita) {
            this.nome = nome;
            this.descrizione = descrizione;
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

        public int getVita() {
            return vita;
        }

        public void setVita(int vita) {
            this.vita = vita;
        }

        @Override
        public String toString() {
            return  nome  + descrizione  + vita ;
        }
    }