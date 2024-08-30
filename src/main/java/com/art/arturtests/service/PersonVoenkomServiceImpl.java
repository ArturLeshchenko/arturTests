package com.art.arturtests.service;
import com.art.arturtests.Entity.Person;
import com.art.arturtests.Entity.PersonVoenkomat;
import com.art.arturtests.repository.PersonRepository;
import com.art.arturtests.repository.PersonVoenkomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonVoenkomServiceImpl  implements PersonVoenkomService {

    private final PersonVoenkomRepository personVoenkomRepository;
    private final PersonRepository personRepository;

    @Override
    public List<PersonVoenkomat> getAll() {
        return personVoenkomRepository.findAll();
    }



    @Transactional
    @Override
    public void setInfo(Long personId, Person person) {
        person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Человек не найден"));
        PersonVoenkomat personVoenkomat = new PersonVoenkomat();
        personVoenkomat.setPropiska(person.getPropiska());
        personVoenkomat.setGodnost(proverkaNaGodnost(person));
        personVoenkomat.setId(personId);
       // person.setPersonVoenkomat(personVoenkomat);
        }


    private String proverkaNaGodnost(Person person) {
        String godnost = null;
        if ((person.getAge() > 18)
                && (person.getAge() < 30)
                && (person.getSex().equals("male")
                && (person.getHealth().equals("здоров")))) {
                 godnost = "годен";
        }
        else
                godnost = "не годен";
        return godnost;
    }
}
