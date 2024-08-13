package salvatore.assennato.card.payloads;

import jakarta.validation.constraints.NotEmpty;
import salvatore.assennato.card.Enum.Taglia;
import salvatore.assennato.card.Enum.TipoAnimale;

import java.util.UUID;

public record CardDTO(
        UUID id,
        String immagine,
        @NotEmpty(message="inserisci il nome")
        String nome,
        @NotEmpty(message="inserisci la descrizione")
        String descrizione,
        @NotEmpty(message="inserisci il tipoAnimale")
        TipoAnimale tipoAnimale,
        @NotEmpty(message="inserisci la taglia")
        Taglia taglia
) {
}
