package br.com.sanadev.rest_with_spring_boot_and_java.person.mock;

import br.com.sanadev.rest_with_spring_boot_and_java.person.model.Person;
import br.com.sanadev.rest_with_spring_boot_and_java.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.logging.Logger;

/**
 * Classe para realizar Mock de coisas específicas.
 * Por enquanto, nada elaborado.
 * Usando somente para fins de estudo.
 *
 * @author Sana
 * @since 29/01/2026
 */
@Component
public class Mock implements CommandLineRunner {

    Logger logger = Logger.getLogger("Mock.class");

    @Autowired
    private PersonService service;

    @Override
    public void run(String... args) throws Exception {

        logger.info("The mock is running!");
/*
        Person person1 = new Person("Deiverson", "Amorim", "Rua Caçapava", "Male");
        Person person2 = new Person("Livia", "Curty", "Rua Caçapava", "Female");
        Person person3 = new Person("Azazel", "Zinho", "Rua Caçapava", "Male");
        Person person4 = new Person("Duqueza", "1", "Rua Caçapava", "Female");
        service.create(person1);
        service.create(person2);
        service.create(person3);
        service.create(person4);

        logger.info("The mock is finished! \nFour people were added to the list!");*/

        List<Person> people = service.findAll();

        logger.info("The people created were:");
                people.forEach(person -> logger.info(person.getFirstName()));
    }
}
