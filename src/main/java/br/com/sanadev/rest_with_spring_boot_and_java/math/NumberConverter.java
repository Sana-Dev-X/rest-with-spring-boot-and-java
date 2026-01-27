package br.com.sanadev.rest_with_spring_boot_and_java.math;

public class NumberConverter {

    /**
     * Converte as Strings em double
     *
     * @param stringNumber
     * @return {@link Double}
     */
    public Double convertToDouble(String stringNumber) {
        String number = stringNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
}
