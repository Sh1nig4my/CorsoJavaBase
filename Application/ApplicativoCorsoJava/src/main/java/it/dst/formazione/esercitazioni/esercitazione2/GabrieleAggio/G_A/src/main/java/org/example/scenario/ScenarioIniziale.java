package org.example.scenario;

public class ScenarioIniziale implements BaseScenary{

    private boolean usato;

    @Override
    public void descrizioneScenario() {
        System.out.println("Benvenuto nella stazione spaziale abbandonata Epsilon 9\n" +
                "Lo scopo della tua missione è Hackerare 3 console per far tornare la corrente\n" +
                "e rendere la stazione di nuovo operativa!");
    }

    @Override
    public void disegnoScenario() {
        System.out.println(" .              +   .                .   . .     .  .\n" +
                "                   .                    .       .     *\n" +
                "  .       *                        . . . .  .   .  + .\n" +
                "            \"Sei qui\"            .   .  +  . . .\n" +
                ".                 |             .  .   .    .    . .\n" +
                "                  |           .     .     . +.    +  .\n" +
                "                 \\|/            .       .   . .\n" +
                "        . .       V          .    * . . .  .  +   .\n" +
                "           +      .           .   .      +\n" +
                "                            .       . +  .+. .\n" +
                "  .                      .     . + .  . .     .      .\n" +
                "           .      .    .     . .   . . .        ! /\n" +
                "      *             .    . .  +    .  .       - O -\n" +
                "          .     .    .  +   . .  *  .       . / |\n" +
                "               . + .  .  .  .. +  .\n" +
                ".      .  .  .  *   .  *  . +..  .            *\n" +
                " .      .   . .   .   .   . .  +   .    .            +");
    }

    @Override
    public boolean isUsato() {
        return usato;  // Ritorna se lo scenario è stato usato
    }

    @Override
    public void setUsato(boolean usato) {
        this.usato = usato;  // Imposta lo stato "usato"
    }


}
