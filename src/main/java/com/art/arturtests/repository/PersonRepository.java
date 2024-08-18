package com.art.arturtests.repository;

import com.art.arturtests.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonRepository extends JpaRepository <Person, Long> {
}

