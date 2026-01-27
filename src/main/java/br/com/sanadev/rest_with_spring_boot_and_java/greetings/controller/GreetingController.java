package br.com.sanadev.rest_with_spring_boot_and_java.greetings.controller;

import br.com.sanadev.rest_with_spring_boot_and_java.greetings.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Classe controller que devolve uma saudação ao nome que é passado via query param
 *
 * @author Sana
 * @since 23/01/2026
 */
@RestController
public class GreetingController {

    private static final String template = "Olá, %s!";
    private final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/greeting?name=Sana
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
