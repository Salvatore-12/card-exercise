package salvatore.assennato.card.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatore.assennato.card.Enum.Taglia;
import salvatore.assennato.card.Enum.TipoAnimale;
import salvatore.assennato.card.entities.Card;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardDAO extends JpaRepository<Card,UUID> {
    Optional<Card> findById(UUID id);
    List<Card> findByTipoAnimale(TipoAnimale tipoAnimale);
    List<Card> findByTipoAnimaleAndTaglia(TipoAnimale tipoAnimale, Taglia taglia);
    List<Card> findByNome(String nome);
    List<Card> findByNomeContaining(String parteDelNome);
    public void deleteById(UUID id);
}
