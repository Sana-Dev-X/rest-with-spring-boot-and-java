package br.com.sanadev.rest_with_spring_boot_and_java.person.service;

import br.com.sanadev.rest_with_spring_boot_and_java.person.model.Person;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());
    static List<Person> people = new ArrayList<>();

    public PersonService(){
        //mock
        logger.info("The mock is running!");

        Person person1 = new Person("Deiverson", "Amorim", "Rua Caçapava", "Male");
        person1.setId(counter.incrementAndGet());
        people.add(person1);

        Person person2 = new Person("Livia", "Curty", "Rua Caçapava", "Female");
        person2.setId(counter.incrementAndGet());
        people.add(person2);

        Person person3 = new Person("Azazel", "Zinho", "Rua Caçapava", "Male");
        person3.setId(counter.incrementAndGet());
        people.add(person3);

        Person person4 = new Person("Duqueza", "1", "Rua Caçapava", "Female");
        person4.setId(counter.incrementAndGet());
        people.add(person4);
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
        if(person.getId() == 0){
            logger.info("Creating one Person!");
            person.setId(counter.incrementAndGet());
            people.add(person);
            logger.info("Person created successfully");
            return person;
            }

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
                logger.info("Person updated successfully!");
                return people;
            }
        }
            return null;
    }
}
