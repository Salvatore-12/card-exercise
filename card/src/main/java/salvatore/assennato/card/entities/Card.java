package salvatore.assennato.card.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

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
}
