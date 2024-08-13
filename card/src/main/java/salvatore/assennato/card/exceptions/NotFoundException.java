package salvatore.assennato.card.exceptions;

import java.util.UUID;

public class NotFoundException  extends RuntimeException{
    public NotFoundException(UUID id) {
        super("Item with id" + id + "not found");
    }

    public  NotFoundException(long id){
        super("Item with id" + id + "not found");
    }
    public  NotFoundException(String message){
        super(message);
    }

}
