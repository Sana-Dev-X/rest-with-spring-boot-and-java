package br.com.sanadev.rest_with_spring_boot_and_java.person.mock;

import br.com.sanadev.rest_with_spring_boot_and_java.dto.PersonDTO;
import br.com.sanadev.rest_with_spring_boot_and_java.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

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

        logger.log(Level.FINE,"The mock is running!");

        List<PersonDTO> people = service.findAll();

        if(people.isEmpty()){

            logger.log(Level.FINE,"The list is empty!");
            logger.log(Level.FINE,"The mock is starting!");

            //Mock
            PersonDTO person1 = new PersonDTO(null,"Deiverson", "Amorim", "Rua Caçapava", "Male");
            PersonDTO person2 = new PersonDTO(null,"Livia", "Curty", "Rua Caçapava", "Female");
            PersonDTO person3 = new PersonDTO(null,"Azazel", "Zinho", "Rua Caçapava", "Male");
            PersonDTO person4 = new PersonDTO(null,"Duqueza", "1", "Rua Caçapava", "Female");
            service.create(person1);
            service.create(person2);
            service.create(person3);
            service.create(person4);

            logger.log(Level.FINE, "The mock is finished! \nFour people were added to the list!");
            people = service.findAll();
            logger.log(Level.FINE,"The people created were:");
        }
        people.forEach(person -> logger.log(Level.FINE,person.firstName()));
    }
}
