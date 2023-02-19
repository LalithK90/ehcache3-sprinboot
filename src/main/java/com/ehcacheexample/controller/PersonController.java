package com.ehcacheexample.controller;

import com.ehcacheexample.entity.Person;
import com.ehcacheexample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonService service;


  @GetMapping("/{name}")
  public Person generatePerson(@PathVariable(value = "name") String name) {
    return service.generatePerson(name);
  }
  @GetMapping("/get/{name}")
  public Person getPerson(@PathVariable(value = "name") String name) {
    return service.getPersonByName(name);
  }

  @GetMapping("/get_id/{id}")
  public Person getById(@PathVariable(value = "id") Integer id) {
    return service.fetchById(id);
  }
}