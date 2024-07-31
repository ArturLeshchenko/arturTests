package com.art.arturtests.service;

import com.art.arturtests.Entity.Person;
import com.art.arturtests.Entity.PersonVoenkomat;
import com.art.arturtests.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;


    @Override
    public Person addPerson(Person person) {
        return personRepository.saveAndFlush(person);
    }

    @Override
    public void deletePerson(Long id) throws Exception {
        personRepository.deleteById(id);

    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getOnePerson(Long id) throws Exception {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElseThrow(() -> new Exception("Человек не найден"));
    }

    @Override
    public Person putPerson(Long id, Person person) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return personRepository.saveAndFlush(person);
    }
//    @Transactional
//    @Override
//    public void setPropiska(Long personId, String propiska) {
//        Person person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Человек не найден"));
//        PersonVoenkomat personVoenkomat = new PersonVoenkomat();
//        personVoenkomat.setPropiska(propiska);
//        personVoenkomat.setPerson(person);
//        personVoenkomat.setId(personId);
//        if ((person.getAge() > 18) && (person.getAge() < 30) && (person.getSex().equals("male"))) {
//            person.setPersonVoenkomat(personVoenkomat);
//        }
//        else
//            new RuntimeException("Нет людей, подходщих для военкомата");
//
//    }
}