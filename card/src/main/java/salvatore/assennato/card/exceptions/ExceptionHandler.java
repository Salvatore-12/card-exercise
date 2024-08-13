package salvatore.assennato.card.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ResponseStatus;
import salvatore.assennato.card.payloads.ErrorPayloadsList;

import java.util.ArrayList;
import java.util.List;

public class ExceptionHandler {
    //400
    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorPayloadsList handleBadRequest(BadRequestException e){
        List<String>  errorsMessage = new ArrayList<>();
        if (e.getErrorList() != null)
            errorsMessage = e.getErrorList().stream().map(err ->err.getDefaultMessage()).toList();
        return new ErrorPayloadsList(e.getMessage(),errorsMessage);
    }

    //401
    @org.springframework.web.bind.annotation.ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorsPayload handleUnauthorized(UnauthorizedException ex){
        return new ErrorsPayload(ex.getMessage());
    }

    //403
    @org.springframework.web.bind.annotation.ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorsPayload handleAccessDenied(AccessDeniedException ex){
        return new ErrorsPayload("Il tuo ruolo non permette di accedere a questa funzionalità!");
    }

    //404
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload handleNotFoundEXc(NotFoundException ex){
        return new ErrorsPayload(ex.getMessage());
    }

    //500
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayload handleGenericError(Exception ex){
        ex.printStackTrace();
        return new ErrorsPayload("Problema lato server");
    }

}
