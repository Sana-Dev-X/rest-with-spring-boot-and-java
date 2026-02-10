package br.com.sanadev.rest_with_spring_boot_and_java.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception customizada para tratar erros de Bad Request
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFountException extends RuntimeException {
    public ResourceNotFountException(String message) {
        super(message);
    }
}
