package br.com.sanadev.rest_with_spring_boot_and_java.service;

import br.com.sanadev.rest_with_spring_boot_and_java.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

/**
 * Classe service que faz os calculos, separando as regras de negocio
 *
 * @author Sana
 * @since 26/01/2026
 */
@Service
public class MathService {

    /**
     * Converte as Strings em double
     *
     * @param stringNumber
     * @return {@link Double}
     */
    private Double convertToDouble(String stringNumber) {
        String number = stringNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    /**
     * Valida ambos os parametros ao mesmo tempo para evitar reescrita de código
     *
     * @param first
     * @param second
     */
    public void validateParameters(String first, String second) {
        if (!isNumeric(first)|| !isNumeric(second))
            throw new UnsupportedOperationException("Please set a numeric value!");
    }

    /**
     * Valida se a variável está vazia, se pode ser formatada em double
     *
     * @param stringNumber
     * @return {@code true}
     */
    private boolean isNumeric(String stringNumber) {
        if(stringNumber.isEmpty() || stringNumber == null)
            throw new UnsupportedOperationException("Please set a numeric value!");
        String number = stringNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public Double sum(String first, String second) {
        validateParameters(first, second);
        return convertToDouble(first) + convertToDouble(second);
    }

    public Double subtraction(String first, String second) {
        validateParameters(first, second);
        return convertToDouble(first) - convertToDouble(second);
    }
    public Double division(String first, String second) {
        validateParameters(first, second);
        return convertToDouble(first) / convertToDouble(second);
    }
    public Double multiplication(String first, String second) {
        validateParameters(first, second);
        return convertToDouble(first) * convertToDouble(second);
    }
    public Double average(String first, String second) {
        validateParameters(first, second);
        return (convertToDouble(first) + convertToDouble(second)) / 2;
    }
    public Double squareRoot(String number) throws Exception {
        if(isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value!");;
        return Math.sqrt(convertToDouble(number));
    }
}
