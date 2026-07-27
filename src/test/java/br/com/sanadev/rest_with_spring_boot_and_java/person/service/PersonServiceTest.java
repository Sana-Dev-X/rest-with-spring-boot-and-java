package br.com.sanadev.rest_with_spring_boot_and_java.person.service;

import br.com.sanadev.rest_with_spring_boot_and_java.person.dto.PersonDTO;
import br.com.sanadev.rest_with_spring_boot_and_java.person.exception.RequiredObjectIsNullException;
import br.com.sanadev.rest_with_spring_boot_and_java.person.model.Person;
import br.com.sanadev.rest_with_spring_boot_and_java.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;

    private Person person;
    private PersonDTO personDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
        Long id = 1L;
        person = new Person(1L, "João", "Silva", "Rua Teste, 123", "Male");
        personDTO = new PersonDTO(1L, "João", "Silva", "Rua Teste, 123", "Male");

        when(repository.findById(id)).thenReturn(Optional.of(person));
        PersonDTO result = service.findById(id);

        //verificar o objeto
        assertNotNull(result);
        assertNotNull(result.id());
        assertEquals(person.getId(), result.id());
        assertEquals(person.getFirstName(), result.firstName());
        verify(repository, times(1)).findById(id);
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
        Long id = 1L;

        PersonDTO personDTO = new PersonDTO(null,"João", "Silva", "Rua Teste, 123", "Male");
        Person personToSave = new Person("João", "Silva", "Rua Teste, 123", "Male");
        Person savedPerson = new Person(id, "João", "Silva", "Rua Teste, 123", "Male");

        when(repository.save(personToSave)).thenReturn(savedPerson);
        PersonDTO result = service.create(personDTO);

        //verificar o objeto
        assertNotNull(result);
        assertNotNull(result.id());
        assertEquals(id, result.id());
        assertEquals(personToSave.getFirstName(), result.firstName());
        verify(repository, times(1)).save(personToSave);
    }

    @Test
    void update() {
        Long id = 1L;

        PersonDTO personDTO = new PersonDTO(id,"Luis", "Silva", "Rua Teste, 123", "Male");
        Person existingPerson = new Person(id,"João", "Silva", "Rua Teste, 123", "Male");
        Person updatedPerson = new Person(id, "Luis", "Silva", "Rua Teste, 123", "Male");

        when(repository.findById(id)).thenReturn(Optional.of(existingPerson));
        when(repository.save(updatedPerson)).thenReturn(updatedPerson);

        PersonDTO result = service.update(personDTO);

        //verificar o objeto
        assertNotNull(result);
        assertNotNull(result.id());
        assertEquals(id, result.id());
        assertEquals(updatedPerson.getFirstName(), result.firstName());
        verify(repository, times(1)).save(updatedPerson);
    }

    @Test
    void delete() {
        Long id = 1L;
        Person person = new Person(id,"João", "Silva", "Rua Teste, 123", "Male");

        when(repository.findById(id)).thenReturn(Optional.of(person));
        doNothing().when(repository).deleteById(id);

        service.delete(id);

        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void addHateoasLinksToSingle() {

        Long id = 1L;
        person = new Person(1L, "João", "Silva", "Rua Teste, 123", "Male");
        personDTO = new PersonDTO(1L, "João", "Silva", "Rua Teste, 123", "Male");

        when(repository.findById(id)).thenReturn(Optional.of(person));

        PersonDTO result = service.findById(id);
        EntityModel<PersonDTO> entityModel = service.addHateoasLinksToSingle(result);

        //verificar o HATEOAS
        assertNotNull(entityModel);
        assertNotNull(entityModel.getLinks());

        // Verifica se cada link está presente
        assertTrue(entityModel.hasLink("self"));
        assertTrue(entityModel.hasLink("findAll"));
        assertTrue(entityModel.hasLink("create"));
        assertTrue(entityModel.hasLink("update"));
        assertTrue(entityModel.hasLink("delete"));

    }

    @Test
    void addHateoasLinksToCollection() {
    }

    @Test
    void createWithNullException() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class,
                () -> {
                    service.create(null);
                }
        );

        String expectedMessage = "It is not allowed to save or update a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void updateWithNullException() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class,
                () -> {
                    service.update(null);
                }
        );

        String expectedMessage = "It is not allowed to save or update a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}