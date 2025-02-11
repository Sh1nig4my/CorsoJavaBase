package id.dst.game.example.tools;

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
