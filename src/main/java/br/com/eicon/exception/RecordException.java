package br.com.eicon.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RecordException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public RecordException(final String message) {
        super(message);
    }
}
