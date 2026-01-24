package br.com.sanadev.rest_with_spring_boot_and_java.controller;

import br.com.sanadev.rest_with_spring_boot_and_java.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe controller que recebe parametros via URL e retorna resultados de calculos
 *
 * @author Sana
 * @since 23/01/2026
 */

@RestController
@RequestMapping("/math")
public class MathController {

    //Passando parametros via URL
    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{first}/{second}")
    public Double sum(@PathVariable String first,
                      @PathVariable String second ){
        validateParameters(first, second);
        return convertToDouble(first)+convertToDouble(second);
    }

    //http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{first}/{second}")
    public Double subtraction(@PathVariable String first,
                      @PathVariable String second) throws Exception {
        validateParameters(first, second);
        return convertToDouble(first)-convertToDouble(second);
    }

    //http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{first}/{second}")
    public Double multiplication(@PathVariable String first,
                      @PathVariable String second ) throws Exception {
        validateParameters(first, second);
        return convertToDouble(first)*convertToDouble(second);
    }

    //http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{first}/{second}")
    public Double division(@PathVariable String first,
                      @PathVariable String second ) throws Exception {
        validateParameters(first, second);
        return convertToDouble(first)/convertToDouble(second);
    }

    //http://localhost:8080/math/squareRoot/25
    @RequestMapping("/squareRoot/{number}")
    public Double division(@PathVariable String number) throws Exception {
        if(!isNumeric(number))throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(convertToDouble(number));
    }

    //http://localhost:8080/math/average/3/5/4/4/3
    @RequestMapping("/average/{first}/{second}/{third}/{fourth}/{fifth}")
    public Double average(@PathVariable String first,
                           @PathVariable String second,
                           @PathVariable String third,
                           @PathVariable String fourth,
                           @PathVariable String fifth) throws Exception {
        validateParameters(first, second, third, fourth, fifth);

        //Soma todos e depois divide pela quantidade total de numeros
        double total = convertToDouble(first)+
                convertToDouble(second)+
                convertToDouble(third)+
                convertToDouble(fourth)+
                convertToDouble(fifth);

        return total/5;
    }

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
    private void validateParameters(String first, String second) {
        if (!isNumeric(first)|| !isNumeric(second))
            throw new UnsupportedOperationException("Please set a numeric value!");
    }

    /**
     * Sobrecarga do {@code validateParameters} para abordar o método de {@code average}
     * @param first
     * @param second
     * @param third
     * @param fourth
     * @param fifth
     */
    private void validateParameters(String first, String second, String third, String fourth, String fifth) {
        if (!isNumeric(first)|| !isNumeric(second)|| !isNumeric(third)|| !isNumeric(fourth)|| !isNumeric(fifth))
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
}
