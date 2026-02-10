package br.com.sanadev.rest_with_spring_boot_and_java.repository;

import br.com.sanadev.rest_with_spring_boot_and_java.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
