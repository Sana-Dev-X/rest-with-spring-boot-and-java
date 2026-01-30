package br.com.sanadev.rest_with_spring_boot_and_java.person.mock;

import br.com.sanadev.rest_with_spring_boot_and_java.person.model.Person;
import br.com.sanadev.rest_with_spring_boot_and_java.person.service.PersonService;


import java.util.logging.Logger;

/**
 * Classe para realizar Mock de coisas específicas.
 * Por enquanto, nada elaborado.
 * Usando somente para fins de estudo.
 *
 * @author Sana
 * @since 29/01/2026
 */
public class Mock {

    Logger logger = Logger.getLogger("Mock.class");

    public void mockPerson() {

        logger.info("The mock is running!");

        Person person1 = new Person("Deiverson", "Amorim", "Rua Caçapava", "Male");
        person1.setId(PersonService.counter.incrementAndGet());
        PersonService.people.add(person1);

        Person person2 = new Person("Livia", "Curty", "Rua Caçapava", "Female");
        person2.setId(PersonService.counter.incrementAndGet());
        PersonService.people.add(person2);

        Person person3 = new Person("Azazel", "Zinho", "Rua Caçapava", "Male");
        person3.setId(PersonService.counter.incrementAndGet());
        PersonService.people.add(person3);

        Person person4 = new Person("Duqueza", "1", "Rua Caçapava", "Female");
        person4.setId(PersonService.counter.incrementAndGet());
        PersonService.people.add(person4);

        logger.info("The mock is finished! \nFour people were added to the list!");
    }
}
