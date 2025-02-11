package id.dst.game.example.tools;

import lombok.Getter;

@Getter
public enum TipologiaGiocatoreEnum {

    GUERRIERO("GUERRIERO"),
    MAGO("MAGO");

    private final String tipologiaGiocatoreEnum;

    TipologiaGiocatoreEnum(String resultEnum) {
        this.tipologiaGiocatoreEnum = resultEnum;
    }
}
