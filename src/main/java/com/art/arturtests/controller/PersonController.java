package com.art.arturtests.controller;

import com.art.arturtests.Entity.Person;
import com.art.arturtests.repository.PersonRepository;
import com.art.arturtests.service.PersonService;
import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artur")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;

    @PostMapping ("/artur/person/add")
    public Person addPerson (@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @DeleteMapping ("/person/delete/{id}")
    public void deletePerson (@PathVariable Long id) throws Exception {
         personService.deletePerson(id);
    }


    @PutMapping("/person/put/{id}")
    public Person updateUser(@PathVariable Long id, @RequestBody Person person) {
        return personService.putPerson(id,person);
    }

    @GetMapping ("/person/getAll")
    public List<Person> getAllPerson() {
        return  personService.getAll();
    }

    @GetMapping ("/person/getOne/{id}")
    public Person getOnePerson(@PathVariable Long id) throws Exception {
        return personService.getOnePerson (id);
    }

//    @GetMapping ("/artur/getAllVoenkomat")
//    public void goVoenkom() throws Exception {
//        //   personService.goVoenkom();
//    }


}
