package com.art.arturtests.service;
import com.art.arturtests.Entity.Person;
import com.art.arturtests.Entity.PersonVoenkomat;
import com.art.arturtests.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonVoenkomServiceImpl implements PersonVoenkomService {

    private final PersonRepository personVoenkomRepository;
    private final PersonRepository personRepository;

    @Override
    public List<PersonVoenkomat> getAll() {
        return personVoenkomRepository.findAll();
    }



    @Transactional
    @Override
    public void setInfo(Long personId, String propiska, String slugba, Long number, String godnost, Integer ves) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Человек не найден"));
        PersonVoenkomat personVoenkomat = new PersonVoenkomat();
        personVoenkomat.setPropiska(propiska);
        personVoenkomat.setSlugba(slugba);
        personVoenkomat.setNumber(number);
        personVoenkomat.setGodnost(godnost);
        personVoenkomat.setVes(ves);
        personVoenkomat.setPerson(person);
        personVoenkomat.setId(personId);
        if ((person.getAge() > 18) && (person.getAge() < 30) && (person.getSex().equals("male"))) {
            person.setPersonVoenkomat(personVoenkomat);
        }
        else
            new RuntimeException("Нет людей, подходщих для военкомата");
        }




}
