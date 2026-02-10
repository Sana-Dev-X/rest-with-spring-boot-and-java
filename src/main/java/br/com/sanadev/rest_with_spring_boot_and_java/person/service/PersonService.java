package br.com.sanadev.rest_with_spring_boot_and_java.person.service;

import br.com.sanadev.rest_with_spring_boot_and_java.person.exception.ResourceNotFountException;
import br.com.sanadev.rest_with_spring_boot_and_java.person.mock.Mock;
import br.com.sanadev.rest_with_spring_boot_and_java.person.model.Person;
import br.com.sanadev.rest_with_spring_boot_and_java.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService{

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository repository;

    public Person findById(Long id){
        logger.info("Finding one Person!");
        Person person = repository.findById(id).orElseThrow(
                () -> new ResourceNotFountException("No records found for this ID")
        );
        logger.info("Person found successfully!");
        return person;
    }

    public List<Person> findAll() {
        logger.info("Finding all People!");
        try {
            List<Person> people = repository.findAll();
            logger.info("People found successfully!");
            return people;
        } catch (Exception e) {
            throw new ResourceNotFountException("No records found");
        }
    }

    public Person create(Person person) {
        logger.info("Creating one Person!");
        try {
            Person entity = repository.save(person);
            logger.info("Person created/updated successfully!");
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Error creating person!");
        }
    }

    public Person update(Person person) {
        logger.info("Updating one Person!");
        try{
            Optional<Person> optionalPerson = repository.findById(person.getId());
            if(optionalPerson.isEmpty()) throw new ResourceNotFountException("No records found for this ID");
            logger.info("Person updated successfully!");
            return repository.save(person);
        }catch (Exception e){
            throw new RuntimeException("Error updating person!");
        }
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        try{
            Optional<Person> optionalPerson = repository.findById(id);
            if(optionalPerson.isEmpty()){throw new RuntimeException("No records found for this ID");}
            repository.deleteById(id);
            logger.info("Person deleted successfully!");
        }catch (Exception e){
            throw new RuntimeException("Error deleting person!");
        }
    }
}
