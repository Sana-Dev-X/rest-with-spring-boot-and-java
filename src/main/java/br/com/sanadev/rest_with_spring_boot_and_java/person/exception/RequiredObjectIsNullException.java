package br.com.sanadev.rest_with_spring_boot_and_java.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException {

  public RequiredObjectIsNullException(String message) {
        super(message);
    }

  public RequiredObjectIsNullException() {
    super("It is not allowed to save or update a null object!");
  }
}
