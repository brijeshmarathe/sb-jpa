package org.learn.spring.sb.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.java.Log;

@SpringBootApplication
public class JpaApplication {
	
	//@Autowired
	//private static PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
		//System.out.println("Persons: \n" + personRepository.findAll());
	}

}
