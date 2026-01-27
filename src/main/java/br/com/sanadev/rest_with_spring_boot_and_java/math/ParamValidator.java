package br.com.sanadev.rest_with_spring_boot_and_java.math;

public class ParamValidator {

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
    public boolean isNumeric(String stringNumber) {
        if(stringNumber.isEmpty() || stringNumber == null)
            throw new UnsupportedOperationException("Please set a numeric value!");
        String number = stringNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
