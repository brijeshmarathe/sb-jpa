package org.learn.spring.sb.jpa.repository;

import java.util.List;
import org.learn.spring.sb.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
    List<Person> findByName(String name);
    List<Person> findByLocation(String location);
    List<Person> findByNameAndLocation(String name, String location);

}
