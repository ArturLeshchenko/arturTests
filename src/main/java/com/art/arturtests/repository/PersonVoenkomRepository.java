package com.art.arturtests.repository;
import com.art.arturtests.Entity.Person;
import com.art.arturtests.Entity.PersonVoenkomat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonVoenkomRepository extends JpaRepository <PersonVoenkomat, Long> {


}

