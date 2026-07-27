package br.com.sanadev.rest_with_spring_boot_and_java.person.service;

import br.com.sanadev.rest_with_spring_boot_and_java.person.controller.PersonController;
import br.com.sanadev.rest_with_spring_boot_and_java.person.exception.RequiredObjectIsNullException;
import br.com.sanadev.rest_with_spring_boot_and_java.person.exception.ResourceNotFountException;
import br.com.sanadev.rest_with_spring_boot_and_java.person.model.Person;
import br.com.sanadev.rest_with_spring_boot_and_java.person.dto.PersonDTO;
import br.com.sanadev.rest_with_spring_boot_and_java.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository repository;

    public PersonDTO findById(Long id) {
        logger.log(Level.FINE, "Finding one Person!");
        Person person = repository.findById(id).orElseThrow(
                () -> new ResourceNotFountException("No records found for this ID")
        );
        logger.log(Level.FINE, "Person found successfully!");
        return new PersonDTO(person.getId(), person.getFirstName(), person.getLastName(), person.getAddress(), person.getGender());
    }

    public List<PersonDTO> findAll() {
        logger.log(Level.FINE, "Finding all People!");
        List<Person> people = repository.findAll();
        logger.log(Level.FINE, "People found successfully!");

        List<PersonDTO> personDTOList = new ArrayList<>();
        people.forEach(result ->
                personDTOList.add(new PersonDTO(
                        result.getId(),
                        result.getFirstName(),
                        result.getLastName(),
                        result.getAddress(),
                        result.getGender()
                ))
        );
        return personDTOList;
    }

    public PersonDTO create(PersonDTO person) {
        logger.log(Level.FINE, "Creating one Person!");

        if (person == null) {
            throw new RequiredObjectIsNullException();
        }

        try {
            Person personToSave = new Person(person.firstName(), person.lastName(), person.address(), person.gender());
            Person entity = repository.save(personToSave);

            PersonDTO entityRecord = new PersonDTO(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getAddress(), entity.getGender());

            logger.log(Level.FINE, "Person created successfully!");
            return entityRecord;
        } catch (Exception e) {
            throw new RuntimeException("Error creating person!");
        }
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one Person!");


        if (person == null) {
            throw new RequiredObjectIsNullException();
        }

        try {
            Optional<Person> optionalPerson = repository.findById(person.id());
            if (optionalPerson.isEmpty()) {
                throw new ResourceNotFountException("No records found for this ID");
            }

            Person updated = repository.save(
                    new Person(
                            person.id(),
                            person.firstName(),
                            person.lastName(),
                            person.address(),
                            person.gender()
                    ));

            logger.info("Person updated successfully!");
            return new PersonDTO(
                    updated.getId(),
                    updated.getFirstName(),
                    updated.getLastName(),
                    updated.getAddress(),
                    updated.getGender());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error updating person!" + e.getMessage(), e);
            throw new RuntimeException("Error updating person!" + e.getMessage());
        }
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        try {
            Optional<Person> optionalPerson = repository.findById(id);
            if (optionalPerson.isEmpty()) {
                throw new ResourceNotFountException("No records found for this ID");
            }
            repository.deleteById(id);
            logger.info("Person deleted successfully!");
        } catch (Exception e) {
            throw new RuntimeException("Error deleting person!");
        }
    }

    public EntityModel<PersonDTO> addHateoasLinksToSingle(PersonDTO dto){
        EntityModel<PersonDTO> model = EntityModel.of(dto);
        //Self Link
        model.add(linkTo(methodOn(PersonController.class).findById(dto.id().toString())).withSelfRel().withType("GET"));

        //Links
        model.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
        model.add(linkTo(methodOn(PersonController.class).create(null)).withRel("create").withType("POST"));
        model.add(linkTo(methodOn(PersonController.class).update(null)).withRel("update").withType("PUT"));
        model.add(linkTo(methodOn(PersonController.class).delete(dto.id().toString())).withRel("delete").withType("DELETE"));

        return model;
    }

    public CollectionModel<EntityModel<PersonDTO>> addHateoasLinksToCollection(List<PersonDTO> dtoList){

        List<EntityModel<PersonDTO>> entities = dtoList.stream()
                .map(this::addHateoasLinksToSingle)
                .collect(Collectors.toList());
        CollectionModel<EntityModel<PersonDTO>> collectionModel = CollectionModel.of(entities);

        //Links
        collectionModel.add(linkTo(methodOn(PersonController.class).findAll()).withSelfRel().withType("GET"));
        collectionModel.add(linkTo(methodOn(PersonController.class).create(null)).withRel("create").withType("POST"));

        return collectionModel;
    }

}