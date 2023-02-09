package com.sky.people.persistence;

import com.sky.people.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository <Person, Integer > {
}
