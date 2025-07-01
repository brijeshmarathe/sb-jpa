package org.learn.spring.sb.jpa.service;

import java.util.List;

import org.learn.spring.sb.jpa.entity.Person;
import org.springframework.stereotype.Service;

/**
 * Service interface for managing Person entities.
 * Provides methods for CRUD operations and custom queries.
 */
@Service
public interface PersonService {
    public List<Person> getPersons();
    public Person getPerson(Long id);
    public Person savePerson(Person person);
    public void deletePerson(Long id);
    public Person updatePerson(Long id, Person person);
    public List<Person> findByName(String name);
    public List<Person> findByLocation(String Location);
    public List<Person> findByNameAndLocaiton(String name, String Location); 
}
