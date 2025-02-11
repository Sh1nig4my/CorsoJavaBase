package id.dst.game.tools;

import lombok.Getter;

@Getter
public enum TipologiaGiocatoreEnum {

    PNG("PNG"),
    PG("PG");

    private final String tipologiaGiocatoreEnum;

    TipologiaGiocatoreEnum(String resultEnum) {
        this.tipologiaGiocatoreEnum = resultEnum;
    }
}
