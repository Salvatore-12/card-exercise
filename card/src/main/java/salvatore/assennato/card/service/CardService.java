package salvatore.assennato.card.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import salvatore.assennato.card.Enum.Taglia;
import salvatore.assennato.card.Enum.TipoAnimale;
import salvatore.assennato.card.entities.Card;
import salvatore.assennato.card.exceptions.NotFoundException;
import salvatore.assennato.card.payloads.CardDTO;
import salvatore.assennato.card.repositories.CardDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CardService {
    private static final Logger logger = LoggerFactory.getLogger(CardService.class);
    @Autowired
    private CardDAO cardDAO;

    public Page<Card> aggiungiCard(Page<Card> paginaCards, Card card){
      List<Card> cards =new ArrayList<>(paginaCards.getContent());
      cards.add(card);
      return new PageImpl<>(cards, paginaCards.getPageable(), paginaCards.getTotalElements());
    }
    public Card findById(UUID id){
        return cardDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public Card save(CardDTO body, UUID id){
        Card newcard = new Card();
        newcard.setImmagine(body.immagine());
        newcard.setNome(body.nome());
        newcard.setDescrizione(body.descrizione());
        newcard.setTipoAnimale(body.tipoAnimale());
        newcard.setTaglia(body.taglia());
        logger.info("Salvataggio della card nel database: {}",newcard);
        return cardDAO.save(newcard);
    }

    public CardDTO getCardById(UUID id) {
        Card card = cardDAO.findById(id)
                .orElseThrow(() -> new NotFoundException("Card non trovata con ID: " + id));
        return new CardDTO(
                card.getIdCard(),
                card.getImmagine(),
                card.getNome(),
                card.getDescrizione(),
                card.getTipoAnimale(),
                card.getTaglia()
        );
    }

    public Card update(UUID id,CardDTO body){
        Card found = this.findById(id);
        found.setImmagine(body.immagine());
        found.setNome(body.nome());
        found.setDescrizione(body.descrizione());
        found.setTipoAnimale(body.tipoAnimale());
        found.setTaglia(body.taglia());
        return cardDAO.save(found);
    }
    public void findByIdAndDelete(UUID id){
        Card found = this.findById(id);
        cardDAO.delete(found);
    }

   public void delete(UUID id){
        cardDAO.deleteById(id);
   }

   //1)Query cards per il cane
  public List<Card> getAllCardsCane(){
        return cardDAO.findByTipoAnimale(TipoAnimale.Cane);
  }
  public List<Card> getCardsCaniETagliaPiccola(){
        return cardDAO.findByTipoAnimaleAndTaglia(TipoAnimale.Cane,Taglia.Piccola);
  }
  public List<Card> getCardsCaniETagliaMedia(){
       return cardDAO.findByTipoAnimaleAndTaglia(TipoAnimale.Cane,Taglia.Media);
  }
  public List<Card> getCardsCaniETagliaGrande(){
      return cardDAO.findByTipoAnimaleAndTaglia(TipoAnimale.Cane,Taglia.Grande);
  }

  //Query cards per il gatto
  public List<Card> getAllCardsGatto(){
      return cardDAO.findByTipoAnimale(TipoAnimale.Gatto);
  }
  public List<Card> gettCardsGattiETagliaPiccola(){
      return cardDAO.findByTipoAnimaleAndTaglia(TipoAnimale.Gatto,Taglia.Piccola);
  }
}
