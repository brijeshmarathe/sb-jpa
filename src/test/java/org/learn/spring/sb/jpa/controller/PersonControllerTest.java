package org.learn.spring.sb.jpa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.learn.spring.sb.jpa.entity.Person;
import org.learn.spring.sb.jpa.repository.PersonRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class PersonControllerTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonController personController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPersons_returnsListOfPersons() {
        Person person1 = new Person();
        person1.setId(1L);
        person1.setName("Alice");

        Person person2 = new Person();
        person2.setId(2L);
        person2.setName("Bob");

        List<Person> mockPersons = Arrays.asList(person1, person2);
        when(personRepository.findAll()).thenReturn(mockPersons);

        List<Person> result = personController.getPersons();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals("Bob", result.get(1).getName());
        verify(personRepository, times(1)).findAll();
    }

    @Test
    void getPersons_returnsEmptyListWhenNoPersons() {
        when(personRepository.findAll()).thenReturn(Collections.emptyList());

        List<Person> result = personController.getPersons();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(personRepository, times(1)).findAll();
    }
}