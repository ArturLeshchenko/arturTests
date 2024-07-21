package com.art.arturtests.service;

import com.art.arturtests.Entity.Person;
import com.art.arturtests.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        return personRepository.findAll().stream().peek(k -> k.setName(k.getName())).collect(Collectors.toList());
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

    @Override
    public List <Person> goVoenkom ()  {
//       List <Person> personList = personRepository.findAll().stream().peek(k ->
//               k.setName(k.getName())).collect(Collectors.toList());
//       for (Person p : personList) {
//           if ((p.getAge()>18)&&(p.getAge()<30)) {
//                personRepository.saveAndFlush(p);
//           }
//       }
       return personRepository.findAll().stream().
               filter(p -> p.getAge() < 30)
               .filter(p -> p.getAge() > 18)
               .filter(p -> p.getSex().equals("mail"))
               .peek(p -> p.setName(p.getName()))
               .collect(Collectors.toList());
    }
}