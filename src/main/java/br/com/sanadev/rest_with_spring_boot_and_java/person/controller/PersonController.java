package br.com.sanadev.rest_with_spring_boot_and_java.person.controller;

import br.com.sanadev.rest_with_spring_boot_and_java.person.dto.PersonDTO;
import br.com.sanadev.rest_with_spring_boot_and_java.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            } )
    public EntityModel<PersonDTO> findById(@PathVariable String id){
        try{
            Long idLong = Long.parseLong(id);
            EntityModel<PersonDTO> model = EntityModel.of(personService.findById(idLong));
            model.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
            model.add(linkTo(methodOn(PersonController.class).findAll()).withRel("all"));

            return model;
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    //http://localhost:8080/person
    @GetMapping( produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE
    } )
    public CollectionModel<EntityModel<PersonDTO>> findAll(){

        List<PersonDTO> list = personService.findAll();

        List<EntityModel<PersonDTO>> personModels = list.stream()
                .map(person -> {
                    EntityModel<PersonDTO> model = EntityModel.of(person);
                    model.add(linkTo(methodOn(PersonController.class).findById(person.id().toString())).withSelfRel());
                    return model;
                })
                .collect(Collectors.toList());

        CollectionModel<EntityModel<PersonDTO>> collectionModel = CollectionModel.of(personModels);
        collectionModel.add(linkTo(methodOn(PersonController.class).findAll()).withSelfRel());

        return collectionModel;
    }

    //http://localhost:8080/person/create
    @PostMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            },
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            }
    )
    public EntityModel<PersonDTO> create(@RequestBody PersonDTO person){
        PersonDTO createdPerson = personService.create(person);
        EntityModel<PersonDTO> model = EntityModel.of(createdPerson);
        model.add(linkTo(methodOn(PersonController.class).findById(createdPerson.id().toString())).withSelfRel());
        model.add(linkTo(methodOn(PersonController.class).findAll()).withRel("all"));
        return model;
    }

    //http://localhost:8080/person/update
    @PutMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            },
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            }
    )
    public EntityModel<PersonDTO> update(@RequestBody PersonDTO person){
        PersonDTO updatedPerson = personService.update(person);
        EntityModel<PersonDTO> model = EntityModel.of(updatedPerson);
        model.add(linkTo(methodOn(PersonController.class).findById(updatedPerson.id().toString())).withSelfRel());
        model.add(linkTo(methodOn(PersonController.class).findAll()).withRel("all"));
        return model;
    }

    //http://localhost:8080/person?id=5
    @DeleteMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            },
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            }
    )
    public ResponseEntity<?> delete(@RequestParam String id){
        Long longId;
        try{
            longId = Long.parseLong(id);
            personService.delete(longId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new RuntimeException("Invalid ID");
        }
    }
}