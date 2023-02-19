package com.ehcacheexample.service;

import com.ehcacheexample.entity.Person;
import com.ehcacheexample.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log
@CacheConfig(cacheNames = "person")
public class PersonService {

private final PersonRepository personRepository;

  @CachePut(cacheNames = "cacheStore", key = "#name")
  public Person generatePerson(String name) {
    Person person = new Person(name, "Switzerland");
    log.info("Generated Person: {}"+ person);
    personRepository.save(person);
    return person;
  }

  @Cacheable
  public Person getPersonByName(String name) {
    log.info("Person request received = {}"+ name);

    return     personRepository.findByName(name);
  }

  @CacheEvict( allEntries = true )
  public void deletePerson(Integer id) {
    log.info("evicting Person = {}"+ id);
    personRepository.deleteById(id);

  }

@Cacheable
  public Person fetchById(Integer id) {
    return personRepository.getReferenceById(id);
  }
}