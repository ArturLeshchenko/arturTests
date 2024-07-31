package com.art.arturtests.service;


import com.art.arturtests.Entity.Person;

import java.util.List;

public interface PersonService {
    Person addPerson (Person person) ;
    void deletePerson (Long id) throws Exception;
    List <Person> getAll ();
    Person getOnePerson (Long id) throws Exception;
    Person putPerson (Long id, Person person);
   // void setPropiska (Long personId, String propiska);;
}
