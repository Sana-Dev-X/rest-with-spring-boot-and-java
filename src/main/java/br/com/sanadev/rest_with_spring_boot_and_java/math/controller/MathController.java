package br.com.sanadev.rest_with_spring_boot_and_java.math.controller;

import br.com.sanadev.rest_with_spring_boot_and_java.math.service.MathService;
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

    private MathService service;

    public MathController() {
        this.service = new MathService();
    }

    //Passando parametros via URL
    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{first}/{second}")
    public Double sum(@PathVariable String first,
                      @PathVariable String second ){
        return service.sum(first, second);
    }

    //http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{first}/{second}")
    public Double subtraction(@PathVariable String first,
                      @PathVariable String second) {
        return service.subtraction(first, second);
    }

    //http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{first}/{second}")
    public Double multiplication(@PathVariable String first,
                      @PathVariable String second ) {
        return service.multiplication(first, second);
    }

    //http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{first}/{second}")
    public Double division(@PathVariable String first,
                      @PathVariable String second ) {
        return service.division(first, second);
    }

    //http://localhost:8080/math/square-root/25
    @RequestMapping("/square-root/{number}")
    public Double squareRoot(@PathVariable String number) throws Exception {
        return service.squareRoot(number);
    }

    //http://localhost:8080/math/average/3/5/4/4/3
    @RequestMapping("/average/{first}/{second}")
    public Double average(@PathVariable String first,
                           @PathVariable String second) throws Exception {
        return service.average(first, second);
    }

}
