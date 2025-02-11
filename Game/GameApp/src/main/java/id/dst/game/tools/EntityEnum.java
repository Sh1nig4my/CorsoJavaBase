package id.dst.game.tools;

import lombok.Getter;

@Getter
public enum EntityEnum {

    SCENRIO("SCENARIO"),
    GIOCATORE("GIOCATORE");

    private final String tableName;

    EntityEnum(String tableName) {
        this.tableName = tableName;
    }

}
