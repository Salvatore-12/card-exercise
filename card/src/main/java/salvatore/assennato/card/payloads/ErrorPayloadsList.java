package salvatore.assennato.card.payloads;

import java.util.List;

public record ErrorPayloadsList(
        String message,
        List<String> errorsList) {
}
