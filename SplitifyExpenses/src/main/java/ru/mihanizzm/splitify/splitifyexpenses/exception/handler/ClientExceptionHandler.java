package ru.mihanizzm.splitify.splitifyexpenses.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.mihanizzm.splitify.splitifyexpenses.exception.JsonMappingException;

@ControllerAdvice
@Slf4j
public class ClientExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<?> handleJsonMappingException(JsonMappingException e) {
        log.error("got json mapping exception", e);
        return new ResponseEntity<>("JsonMappingException handled", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
