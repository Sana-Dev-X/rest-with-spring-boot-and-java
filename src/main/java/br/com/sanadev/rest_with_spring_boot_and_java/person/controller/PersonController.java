package br.com.sanadev.rest_with_spring_boot_and_java.person.controller;

import br.com.sanadev.rest_with_spring_boot_and_java.person.model.Person;
import br.com.sanadev.rest_with_spring_boot_and_java.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

/**
 * Classe para estudo de verbos HTTP
 *
 * @author Sana
 * @since 27/01/2026
 */

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    // http://localhost:8080/person/1

    /**
     * Aqui a declaração especifica a url, o verbo http e o tipo e retorn
     *
     * @param id
     * @return
     */
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public Person findById(@PathVariable String id){
        try{
            Long idLong = Long.parseLong(id);
            return personService.findById(idLong);
        }catch (Exception e){
           throw new IllegalArgumentException("Invalid ID");
        }
    }

    //http://localhost:8080/person
    //@GetMapping - Utilizaremos RequestMapping, pois no futuro aplicaremos documentação automatica com Swagger
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll(){ return personService.findAll(); }

    //http://localhost:8080/person/create
    //@PostMapping
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person create(@RequestBody Person person){ return personService.create(person); }

    //http://localhost:8080/person/update
    //@PutMapping
    @RequestMapping(
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person person){ return personService.update(person); }


    //http://localhost:8080/person?id=5
    //@DeleteMapping
    @RequestMapping(
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void delete(@RequestParam String id){
        Long longId;
        try{
             longId = Long.parseLong(id);
            personService.delete(longId);
        } catch (Exception e) {
            throw new RuntimeException("Invalid ID");
        }
    }

}
