package org.learn.spring.sb.jpa.service.impl;

import java.util.List;

import org.learn.spring.sb.jpa.entity.Person;
import org.learn.spring.sb.jpa.repository.PersonRepository;
import org.learn.spring.sb.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    private PersonRepository personRepository;
	
    /**
     * Saves the given {@link Person} entity to the repository.
     *
     * @param person the {@link Person} entity to be saved
     * @return the saved {@link Person} entity
     */
    @Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

    /**
     * Retrieves a {@link Person} entity by its unique identifier.
     *
     * @param id the unique identifier of the person to retrieve
     * @return the {@link Person} with the specified id, or {@code null} if not found
     */
	@Override
	public Person getPerson(Long id) {
		return personRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePerson(Long id) {
		if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Person with id " + id + " does not exist.");
        }
	}

	@Override
	public Person updatePerson(Long id, Person person) {
        if (personRepository.existsById(id)) {
            person.setId(id);
            return personRepository.save(person);
        } else {
            throw new IllegalArgumentException("Person with id " + id + " does not exist.");
        }
    }

	@Override
	public List<Person> getPersons() {
        return personRepository.findAll();
    }

	@Override
	public List<Person> findByName(String name) {
		return personRepository.findByName(name);
	}

	@Override
	public List<Person> findByLocation(String location) {
        return personRepository.findByLocation(location);
	}

	@Override
	public List<Person> findByNameAndLocaiton(String name, String location) {
        return personRepository.findByNameAndLocation(name, location);
    }	
}
