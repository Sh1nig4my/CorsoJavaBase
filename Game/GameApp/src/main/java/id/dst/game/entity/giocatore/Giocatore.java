package id.dst.game.entity.giocatore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data  // Include automaticamente getter, setter, toString(), equals() e hashCode()
@AllArgsConstructor  // Crea automaticamente un costruttore con tutti i parametri
@NoArgsConstructor
public class Giocatore extends Personaggio {

    public Integer id ;
    public Integer forza;
    public Integer destrezza;
    public Integer intelligenza;
    public String tipo;

    // INFO: si può migliorare?
    public Giocatore(Integer id, String nome, Integer eta, Integer hp, Integer forza, Integer destrezza, Integer intelligenza, String tipo) {
        super(nome, eta, hp);
        this.id = id;
        this.forza = forza;
        this.destrezza = destrezza;
        this.intelligenza = intelligenza;
        this.tipo = tipo;

        Giocatore player_test =new Giocatore();
        player_test.getForza();
    }
}
