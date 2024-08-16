package salvatore.assennato.card.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salvatore.assennato.card.entities.Card;
import salvatore.assennato.card.service.CardService;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    //1)VARI ENDPOINT PER I PRODOTTI PER IL Cane
    @GetMapping("/cards-cane")
    public List<Card> getAllCardsCane(){
        return cardService.getAllCardsCane();
    }
    @GetMapping("/cani-tagliaPiccola")
    public List<Card> getCardsCaniEtagliaPiccola(){
        return cardService.getCardsCaniETagliaPiccola();
    }
    @GetMapping("/cane-tagliaMedia")
    public List<Card> getCardsCaniEtagliaMedia(){
        return cardService.getCardsCaniETagliaMedia();
    }
    @GetMapping("/cane-tagliaGrande")
    public List<Card> getCardsCaniEtagliaGrande(){
        return cardService.getCardsCaniETagliaGrande();
    }

    //2)//1)VARI ENDPOINT PER I PRODOTTI PER IL GATTO
    @GetMapping("/cards-gatto")
    public List<Card> getAllCardsGatto(){
        return cardService.getAllCardsGatto();
    }
    @GetMapping("/gatto-tagliaPiccola")
    public List<Card> getCardsGattiETagliaPiccola(){
        return cardService.getCardsGattiETagliaPiccola();
    }
}
