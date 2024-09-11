package salvatore.assennato.card.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salvatore.assennato.card.entities.Card;
import salvatore.assennato.card.service.CardService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    public CardController() {
        System.out.println("CardController istanziato");
    }


    //1)VARI ENDPOINT PER LE VARIE CARD PER IL CANE
    @GetMapping("/cards-cane")
    public List<Card> getAllCardsCane(){
        List<Card> cards = cardService.getAllCardsCane();
        System.out.println("Numero di carte trovate per i cani: " + cards.size());
        return cards;
    }
    @GetMapping("/cane-tagliaPiccola")
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

    //2)VARI ENDPOINT PER LE VARIE CARD PER IL GATTO
    @GetMapping("/cards-gatto")
    public List<Card> getAllCardsGatto(){
        return cardService.getAllCardsGatto();
    }
    @GetMapping("/gatto-tagliaPiccola")
    public List<Card> getCardsGattiETagliaPiccola(){
        return cardService.getCardsGattiETagliaPiccola();
    }

    @GetMapping("/gatto-tagliaMedia")
    public List<Card> getCardsGattiETagliaMedia(){
        return cardService.getCardsGattiETagliaMedia();
    }

    @GetMapping("/gatto-tagliaGrande")
    public List<Card> getCardsGattiETagliaGrande(){
        return cardService.getCardsGattiETagliaGrande();
    }

    //2)VARI ENDPOINT PER LE VARIE CARD PER L'UCCELLO
    @GetMapping("/cards-uccello")
    public List<Card> getAllCardsUccello(){
        return  cardService.getAllCardsUccello();
    }
    @GetMapping("/uccello-tagliaPiccola")
    public List<Card> getCardsUccelliETagliaPiccola(){
        return cardService.getCardsUccelliETagliaPiccola();
    }

    @GetMapping("/uccello-tagliaMedia")
    public List<Card> getCardsUccelliETagliaMedia(){
        return cardService.getCardsUccelliETagliaMedia();
    }

    @GetMapping("/uccello-tagliaGrande")
    public List<Card> getCardsUccelliETagliaGrande(){
        return cardService.getCardsUccelliETagliaGrande();
    }
}
