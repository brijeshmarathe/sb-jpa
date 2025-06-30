package org.learn.spring.sb.jpa.repository;

import org.learn.spring.sb.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // Custom query methods can be defined here if needed
    // For example:
    // List<Person> findByName(String name);
    // List<Person> findByLocation(String location);
    // List<Person> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);

}
