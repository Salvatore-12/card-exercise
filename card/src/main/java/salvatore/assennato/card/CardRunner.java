package salvatore.assennato.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import salvatore.assennato.card.Enum.Taglia;
import salvatore.assennato.card.Enum.TipoAnimale;
import salvatore.assennato.card.entities.Card;
import salvatore.assennato.card.repositories.CardDAO;
import salvatore.assennato.card.service.CardService;

import java.util.Scanner;

@Component
@Order(1)
public class CardRunner implements CommandLineRunner {
    @Autowired
    private CardService cardService;
    @Autowired
    private CardDAO cardDAO;
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean errors = false;
        do {
            System.out.println("Vuoi Procedere Con la Creazione delle cards? (y/n)");
            String choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "y" -> {
                    createCards();
                    errors = false;
                    System.out.println("cards creati con successo!");
                }
                case "n" -> errors = false;
                default -> {
                    System.out.println("Input non valido. Riprova.");
                    errors = true;
                }
            }
        } while (errors);
    }
    public void createCards(){
        // 1)Creazione Cards Cani
          //Sezione Taglia Piccola
          Card cardCane1 = new Card("https://plus.unsplash.com/premium_photo-1668208365386-4198381c6f6e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8c2hpYmElMjBpbnV8ZW58MHx8MHx8fDA%3D","Sbiba inu","Bellissimo Shiba inu,adatto a tutti itipi di famiglie", TipoAnimale.Cane, Taglia.Piccola);
          cardDAO.save(cardCane1);

          //Sezione Taglia Media
          Card cardCaneMedio1 = new Card("https://images.unsplash.com/photo-1667080799488-3fa8fe75cdd8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8Y2hvdyUyMGNob3d8ZW58MHx8MHx8fDA%3D","Chow chow","bellissimo cane Chow chow",TipoAnimale.Cane,Taglia.Media);
          cardDAO.save(cardCaneMedio1);

          //Sezione Taglia Grande
          Card cardCaneGrande1 = new Card("https://images.unsplash.com/photo-1651137540084-684834335af9?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8U2FuJTIwQmVybmFyZG98ZW58MHx8MHx8fDA%3D","San Bernardo","bellissimo e coccoloso San Bernardo",TipoAnimale.Cane,Taglia.Grande);
          cardDAO.save(cardCaneGrande1);

        // 2)Creazione Cards Gatti
           //Sezione Taglia Piccola
           Card cardGattoPiccolo1 = new Card("https://images.unsplash.com/photo-1693778132696-19a993323880?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Y29ybmlzaCUyMHJleHxlbnwwfHwwfHx8MA%3D%3D","cornish-rex","bellissimo gattino",TipoAnimale.Gatto,Taglia.Piccola);
           cardDAO.save(cardGattoPiccolo1);
           //Sezione Taglia Media
           Card cardGatto1 = new Card("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQM7A4PEIA1VKTHryXPShQeujrayN6SddBtQ&s","American Curl","bellissimo esemplare di American Curl,coccoloso con tutti",TipoAnimale.Gatto,Taglia.Media);
           cardDAO.save(cardGatto1);
           //Sezione Taglia Grande
           Card cardGattoGrande1 = new Card("https://images.unsplash.com/photo-1510932309205-50f8913fdb7c?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TWFpbmUlMjBDb29ufGVufDB8fDB8fHww","Maine Coon","bellissimo gatto pelosetto",TipoAnimale.Gatto,Taglia.Grande);
           cardDAO.save(cardGattoGrande1);
    }
}
