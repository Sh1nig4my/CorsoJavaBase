package org.example.scenario;

public class ScenarioNaveSpazialeNemica implements BaseScenary{

    private boolean usato;

    @Override
    public void descrizioneScenario() {
        System.out.println("Un pirata spaziale di nome Leela ti ha trovato, hackera la sua nave\n" +
                "prima che lei hackeri la tua o sarà GAME OVER");
    }

    @Override
    public void disegnoScenario() {
        System.out.println("                     `. ___\n" +
                "                    __,' __`.                _..----....____\n" +
                "        __...--.'``;.   ,.   ;``--..__     .'    ,-._    _.-'\n" +
                "  _..-''-------'   `'   `'   `'     O ``-''._   (,;') _,'\n" +
                ",'________________                          \\`-._`-','\n" +
                " `._              ```````````------...___   '-.._'-:\n" +
                "    ```--.._      ,.                     ````--...__\\-.\n" +
                "            `.--. `-`                       ____    |  |`\n" +
                "              `. `.                       ,'`````.  ;  ;`\n" +
                "                `._`.        __________   `.      \\'__/`\n" +
                "                   `-:._____/______/___/____`.     \\  `\n" +
                "                               |       `._    `.    \\\n" +
                "                               `._________`-.   `.   `.___\n" +
                "                                                  `------'`");
    }

    @Override
    public boolean isUsato() {
        return usato;
    }

    @Override
    public void setUsato(boolean usato) {
        this.usato = usato;
    }
}
