package org.learn.spring.sb.jpa.controller;

import java.util.List;

import org.learn.spring.sb.jpa.entity.Person;
import org.learn.spring.sb.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing {@link Person} entities.
 * <p>
 * Provides endpoints to retrieve a single person by ID or to list all persons.
 * </p>
 *
 * <ul>
 * <li>{@code GET /person/{id}} - Retrieves a person by their unique
 * identifier.</li>
 * <li>{@code GET /persons} - Retrieves a list of all persons.</li>
 * </ul>
 *
 * @author Brijesh Marathe
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    /**
     * Handles HTTP GET requests for retrieving a Person by their unique ID.
     *
     * @param id the unique identifier of the Person to retrieve
     * @return the Person object if found, or {@code null} if no Person exists with
     *         the given ID
     */
    @GetMapping(value = "/person/{id}")
    public Person getPerson(@PathVariable("id") Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @GetMapping(value = "/person/delete/{id}")
    public void deletPerson(@PathVariable("id") Long id) {
        personRepository.deleteById(id);
    }

    @GetMapping(value = "/person/byname/{name}")
    public List<Person> PersonByName(@PathVariable("name") String name) {
        return personRepository.findByName(name);
    }
    
    @GetMapping(value = "/person/bylocation/{location}")    
    public List<Person> PersonByLocation(@PathVariable("location") String location) {
        return personRepository.findByLocation(location);
    }

    /**
     * Handles HTTP GET requests for retrieving all persons.
     *
     * @return a list of all {@link Person} entities from the repository
     */
    @GetMapping(value = "/persons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @GetMapping(value = "/person/create/{name}/{location}/{dateOfBirth}")
    public Person createPerson(@PathVariable("name") String name,
            @PathVariable("location") String location,
            @PathVariable("dateOfBirth") String dateOfBirth) {
        Person person = new Person();
        person.setName(name);
        person.setLocation(location);
        person.setDateOfBirth(java.time.LocalDate.parse(dateOfBirth));
        return personRepository.save(person);
    }
}
