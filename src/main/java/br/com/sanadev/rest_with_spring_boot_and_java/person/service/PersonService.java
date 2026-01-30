package br.com.sanadev.rest_with_spring_boot_and_java.person.service;

import br.com.sanadev.rest_with_spring_boot_and_java.person.mock.Mock;
import br.com.sanadev.rest_with_spring_boot_and_java.person.model.Person;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    public static final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());
    public static List<Person> people = new ArrayList<>();
    Mock mock = new Mock();

    public PersonService(){
        mock.mockPerson();
    }

    public Person findById(String id){
        logger.info("Finding one Person!");
        return people.stream()
                .filter(person -> person.getId() == Long.parseLong(id))
                .findFirst()
                .orElse(null);
    }

    public List<Person> findAll() {
        logger.info("Finding all People!");
        return people;
    }

    public Person create(Person person) {
        // Se não possuir ID, cria uma nova pessoa
        if(person.getId() == 0){
            logger.info("Creating one Person!");
            person.setId(counter.incrementAndGet());
            people.add(person);
            logger.info("Person created successfully");
            return person;
            }

        // Se já tiver ID, atualiza a pessoa com o ID igual ao do parametro, com dados do parametro
        logger.info("Updating one Person!");
        for(int i = 0; i < people.size(); i++) {
            if(people.get(i).getId() == person.getId()) {
                people.set(i, person); // Substitui a pessoa antiga pela nova
                logger.info("Person updated successfully!");
                return person;
            }
        }
        return null;
    }

    public List<Person> delete(String id) {
        logger.info("Deleting one Person!");
        for(int i = 0; i < people.size(); i++) {
            if(people.get(i).getId() == Long.parseLong(id)) {
                people.remove(i);
                logger.info("Person deleted successfully!");
                return people;
            }
        }
            return null;
    }
}
