package com.ehcacheexample.repository;

import com.ehcacheexample.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository< Person, Integer > {
  Person findByName(String name);
}
