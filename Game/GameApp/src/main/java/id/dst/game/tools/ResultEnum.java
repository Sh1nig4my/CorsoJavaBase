package id.dst.game.tools;

import lombok.Getter;

@Getter
public enum ResultEnum {

    OK("OK"),
    KO("KO");

    private final String resultEnum;

    ResultEnum(String resultEnum) {
        this.resultEnum = resultEnum;
    }
}
