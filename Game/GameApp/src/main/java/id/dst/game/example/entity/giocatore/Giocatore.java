package id.dst.game.example.entity.giocatore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data  // Include automaticamente getter, setter, toString(), equals() e hashCode()
@AllArgsConstructor  // Crea automaticamente un costruttore con tutti i parametri
@NoArgsConstructor
public class Giocatore extends Personaggio {

    private Integer id ;
    private Integer forza;
    private Integer destrezza;
    private Integer intelligenza;
    private String tipo;

    // INFO: si può migliorare?
    public Giocatore(Integer id, String nome, Integer eta, Integer hp, Integer forza, Integer destrezza, Integer intelligenza, String tipo) {
        super(nome, eta, hp);
        this.id = id;
        this.forza = forza;
        this.destrezza = destrezza;
        this.intelligenza = intelligenza;
        this.tipo = tipo;
    }

}
