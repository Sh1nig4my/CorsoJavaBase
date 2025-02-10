package id.dst.game.entity.giocatore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaggio {

    private String nome;
    private Integer eta;
    private Integer hp;

}
