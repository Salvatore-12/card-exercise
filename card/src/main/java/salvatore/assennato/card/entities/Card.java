package salvatore.assennato.card.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import salvatore.assennato.card.Enum.Taglia;
import salvatore.assennato.card.Enum.TipoAnimale;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Card {
    @Id
    @GeneratedValue
    @JsonProperty("idCard")
    private UUID idCard;
    @JsonProperty("immagine")
    private String immagine;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("descrizione")
    private String descrizione;
    @JsonProperty("tipoAnimale")
    @Enumerated(EnumType.STRING)
    private TipoAnimale tipoAnimale;
    @JsonProperty("taglia")
    @Enumerated(EnumType.STRING)
    private Taglia taglia;

}
