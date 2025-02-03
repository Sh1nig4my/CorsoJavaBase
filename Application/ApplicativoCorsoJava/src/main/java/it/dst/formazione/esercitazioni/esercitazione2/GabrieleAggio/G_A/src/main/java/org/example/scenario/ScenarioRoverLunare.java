package org.example.scenario;

public class ScenarioRoverLunare implements BaseScenary{

    private boolean usato;

    @Override
    public void descrizioneScenario() {
        System.out.println("Questo è il modulo lunare abbandonato\n" +
                "hackeralo per ripristinare la connessione con il modulo principale\n");
    }

    @Override
    public void disegnoScenario() {
        System.out.println("Rover: " +
                "                                                                    ||\n" +
                "                                                  __..--\".          ||\n" +
                "                                 __..--\"\"`._..--\"\" . . . .`.        ||\n" +
                "                         __..--\"\". . . . . . .`. . . . . . .`.      ||\n" +
                "                 __..--\"\". . . . .`. . . . . . .`. . . . . . .`.   //\n" +
                "         __..--\"\". . `.  . . . . . .`. . . . . . .`. . . . . . .`.//\n" +
                "  _..--\"\"  . . . . . . `.  . . . . . .`. . . . . . .`. . . . . . .||\n" +
                ":\". . . .`.  . . . . . . `.  . . . . . .`. . . . . . .`. . . . . .||`.\n" +
                "`:. . . . .`.  . . . . . . `.  . . . . . .`. . . . . . .`. . . . .||__>\n" +
                "  `:. . . . .`.  . . . . . . `.  . . . . . .`. . . . . . .`.__..-o||\n" +
                "    `:. . . . .`.  . . . . . . `.  . . . . . .`. . . . .`;Y\"->.  \"\"\n" +
                "      `:. . . . .`.  . . . . . . `.  . . . . . .`. . . __.>.:'\n" +
                "        `:. . . . .`.  . . . . . . `.  . . . . __..--\"\" ..+\"`.\n" +
                "   _..-._ `:. . . . .`.  . . . . . . `.__..--\"\" ....:::::.|   `.\n" +
                " .\"`` \\_--\" >:. . . . .`.  . . __..,-|\" . ..::::::::::::::`--\"\"-:.\n" +
                "' ..`\\J.-  \"8-`:. . .  __..--\"\" ...-I  \\ `. `::::::::::::::::::::\".\n" +
                "`/'\\\\88o. ,O \\  `:.--\"\"....:|:::'''`'\\ ='. }-._'::::::::::::::::::|\n" +
                "8  8|PP|\"(:. \\-\" \"\"`:::::::|:::.((::='/ .\\\"\"-.:_ ':::::::::::''_.'  _..\n" +
                " 8  8|::/ \\`::Y  _____`:::::|::::.\\\\[ .\\ \"/\"..* *\"-. '''__..--\"\")\\,\"\".-.\\_\n" +
                "`\\b d/\"\"===\\==V::.--..__`:::|:::::.|,'*.\"\".:.. \"_-.*`.\"\"    _.-\"-\"\"\\? \"_=``.\n" +
                "\\\\`\".`\"' .: :-.::.        `:|:::.'.'*.' __..--\"\"   `.*`:--\"\".-\"?,  .)=\"\"`\\ \\\\\n" +
                " `.``...''_/   ``::      _\\\\--.'.'*.'-\"\"   _..-._ _..>.*;-\"\"@_.-/-\" `\\.-\"\"\"-.\\\n" +
                "   `-::--\"            .-\"@\"}.'.'*.:)     .\"\\` \\ \\`.--'_`-'     `\\. \\-'-\"\"-   `.\n" +
                "                     <\\  _...'*.'      .' \\.`\\ `\\ \\\\\"\"         `\\ `' ' .-.\\   |\n" +
                "                     _\\\"\" .---'        -\\. `\\.-\"\"\"-.\\           \\`|    ._)/   '\n" +
                "                   .\"\\.`-\"\\`.         `\\. \\-'-\"\"-   `.           \\\\  `---\"   /\n" +
                "                 .' \\.`\\ `\\ \\\\        `\\ `' ' .-.\\   |            `.       _/\n" +
                "                 -\\. `\\.-\"\"\"-.\\        \\`|    ._)/   '              `-..--\"\n" +
                "                `\\. \\-'-\"\"-   `.        \\\\  `---\"   /\n" +
                "                `\\ `' ' .-.\\   |         `.       _/\n" +
                "                 \\`|    ._)/   '           `-..--\"\n" +
                "                  \\\\  `---\"   /\n" +
                "                   `.       _/\n" +
                "                     `-..--\"");
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
