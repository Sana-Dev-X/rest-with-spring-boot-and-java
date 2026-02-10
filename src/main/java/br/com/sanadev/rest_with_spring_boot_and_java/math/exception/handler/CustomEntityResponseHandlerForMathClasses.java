package br.com.sanadev.rest_with_spring_boot_and_java.math.exception.handler;

import br.com.sanadev.rest_with_spring_boot_and_java.math.exception.ExceptionResponse;
import br.com.sanadev.rest_with_spring_boot_and_java.math.exception.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * Esta classe atua captando as Exceptions de todos os controller por meio da anotação @ControllerAdvice
 *
 * @author Sana
 * @since 24/01/2026
 */
@RestController
@ControllerAdvice
public class CustomEntityResponseHandlerForMathClasses extends ResponseEntityExceptionHandler {

    /**
     * Retorna um {@code ResponseEntity} formatado quando houver erros genéricos no servidor
     *
     * @param exception
     * @param request
     * @return {@code ResponseEntity}
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request){
         ExceptionResponse response = new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Retorna um {@code ResponseEntity} formatado específico para Bad Requests
     *
     * @param exception
     * @param request
     * @return {@code ResponseEntity}
     */
    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception exception, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
