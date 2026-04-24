package br.com.sanadev.rest_with_spring_boot_and_java.person.controller;

import br.com.sanadev.rest_with_spring_boot_and_java.dto.PersonDTO;
import br.com.sanadev.rest_with_spring_boot_and_java.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public PersonDTO findById(@PathVariable String id){
        try{
            Long idLong = Long.parseLong(id);
            return personService.findById(idLong);
        }catch (Exception e){
           throw new IllegalArgumentException("Invalid ID");
        }
    }

    //http://localhost:8080/person
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
    public List<PersonDTO> findAll(){

        List<PersonDTO> list = personService.findAll();

        return list;
    }

    //http://localhost:8080/person/create
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO person){ return personService.create(person); }

    //http://localhost:8080/person/update
    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update(@RequestBody PersonDTO person){ return personService.update(person); }


    //http://localhost:8080/person?id=5
    @DeleteMapping(
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
