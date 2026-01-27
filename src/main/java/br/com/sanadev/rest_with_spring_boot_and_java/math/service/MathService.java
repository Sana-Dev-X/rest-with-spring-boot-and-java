package br.com.sanadev.rest_with_spring_boot_and_java.math.service;

import br.com.sanadev.rest_with_spring_boot_and_java.math.NumberConverter;
import br.com.sanadev.rest_with_spring_boot_and_java.math.ParamValidator;
import br.com.sanadev.rest_with_spring_boot_and_java.math.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

/**
 * Classe service que faz os calculos, separando as regras de negocio
 *
 * @author Sana
 * @since 26/01/2026
 */
@Service
public class MathService {

    NumberConverter converter = new NumberConverter();
    ParamValidator validator = new ParamValidator();

    public Double sum(String first, String second) {
        validator.validateParameters(first, second);
        return converter.convertToDouble(first) + converter.convertToDouble(second);
    }

    public Double subtraction(String first, String second) {
        validator.validateParameters(first, second);
        return converter.convertToDouble(first) - converter.convertToDouble(second);
    }
    public Double division(String first, String second) {
        validator.validateParameters(first, second);
        return converter.convertToDouble(first) / converter.convertToDouble(second);
    }
    public Double multiplication(String first, String second) {
        validator.validateParameters(first, second);
        return converter.convertToDouble(first) * converter.convertToDouble(second);
    }
    public Double average(String first, String second) {
        validator.validateParameters(first, second);
        return (converter.convertToDouble(first) + converter.convertToDouble(second)) / 2;
    }
    public Double squareRoot(String number) throws Exception {
        if(validator.isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value!");;
        return Math.sqrt(converter.convertToDouble(number));
    }
}
