package org.example.scenario;

public class ScenarioLaboratorio implements BaseScenary{

    private boolean usato;

    @Override
    public void descrizioneScenario() {
        System.out.println("Sei nei laboratori segreti, da cui provengono rumori..." +
                "una pirata spaziale ti sta cercando, hackera prima che ti trovi");
    }

    @Override
    public void disegnoScenario() {
        System.out.println("         _.----.                          \n" +
                "       .-\"       \\-.                       \n" +
                "      /           ; \\                      \n" +
                "     :           /:  \\                     \n" +
                "     ;         .'  ;  ;                    \n" +
                "     ;      .-\"    :  :                    \n" +
                "    :   _.+(   .-- :  :                    \n" +
                "    ;  ;   ' :  :                    \n" +
                "    ;  :           ;  ;                    \n" +
                "    :   ;    -    :  :                     \n" +
                "     )  '   .-.   '  :                     \n" +
                "    (    '. `\"' .'   ;                     \n" +
                "     \"-._.:`---':-\"-.'+'                   \n" +
                "          ;     ;    \"                     \n" +
                "   _..__.-. -. (:                          \n" +
                " ,'   .:(o);     \"-._                      \n" +
                " :    _: 0 ;        \\`.                    \n" +
                " ;  .'/.\\-/-.        `:                    \n" +
                ":  : :  -U--:\"-.  \\    ;                   \n" +
                ";  ; :  ----;   \"-.L.-\" \\                  \n" +
                "'. '  \\ ---(      ;O:    ;                 \n" +
                "  \\ '. '-;-'      :-:    :                 \n" +
                "   `. \"\"/         ; :    ;                 \n" +
                "     \"\"T      .-\":  :`. /                  \n" +
                "       :  --\"\"   :   ; Y                   \n" +
                "        ;        ;   : :                   \n" +
                "        :       :     ; ;                  \n" +
                "         ;      :   ; : :                  \n" +
                "         :      ;   :  ; \\                 \n" +
                "          ;    :    ;  :  \\_               \n" +
                "          :    :        \\  \\\"-.            \n" +
                "          ;    ;         \\  `. \"-.         \n" +
                "         :    :     c     \\   `./\"-._      \n" +
                "         ;    :            \\    \\    \"-.   \n" +
                "        :     ;             `.   ;-.  -.`. \n" +
                "        :    :       __..--\"\" \\  :  `.\\.`.\\\n" +
                "        ;    :_..--\"\";  ;  _.-'\\  ;   \")))T\n" +
                "       :     ;      _L.-'\"\"     ; :    '-='\n" +
                "       ;    :_..--\"\"            :  ;       \n" +
                "      /     ;                   ;; :       \n" +
                "    .'     /                    ;: J       \n" +
                "    `.    /                     ;'\"        \n" +
                "      :-.'         /\\           ;          \n" +
                "      ;           /  ;          :          \n" +
                "     :           /   :          :          \n" +
                "     ;          /     ;         :          \n" +
                "    :          /  bug ;         :          \n" +
                "    ;         /       :         :          \n" +
                "   :         /        :         :");
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
