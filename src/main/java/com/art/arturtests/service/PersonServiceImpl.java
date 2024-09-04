package com.art.arturtests.service;

import com.art.arturtests.Entity.Person;
import com.art.arturtests.Entity.PersonVoenkomat;
import com.art.arturtests.repository.PersonRepository;
import com.art.arturtests.repository.PersonVoenkomRepository;
import jakarta.persistence.Transient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonVoenkomRepository personVoenkomRepository;

    @Override
    public Person addPerson(Person person) {
        PersonVoenkomat personVoenkomat = new PersonVoenkomat();
        String godnost =proverkaNaGodnost(person);
        if (godnost.equals("годен")) {
            personVoenkomat.setPropiska(person.getPropiska());
            personVoenkomat.setGodnost(godnost);
            personVoenkomat.setId(person.getId());
            personVoenkomRepository.saveAndFlush(personVoenkomat);
        }
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

    @Override
    public String proverkaNaGodnost(Person person) {
        String godnost = null;
        if ((person.getAge() >= 18)
                && (person.getAge() < 30)
                && (person.getSex().equals("male")
                && (person.getHealth().equals("здоров")))) {
            godnost = "годен";
        } else
            godnost = "не годен";
        return godnost;
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
//    }
}