package br.com.sanadev.rest_with_spring_boot_and_java;

import br.com.sanadev.rest_with_spring_boot_and_java.person.mock.Mock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EntityScan
public class Startup {
	public static void main(String[] args) {SpringApplication.run(Startup.class, args);}
}
