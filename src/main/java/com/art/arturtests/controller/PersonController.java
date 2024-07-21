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

    @PostMapping ("/add")
    public Person addPerson (@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @DeleteMapping ("/delete/{id}")
    public void deletePerson (@PathVariable Long id) throws Exception {
         personService.deletePerson(id);
    }


    @PutMapping("put/{id}")
    public Person updateUser(@PathVariable Long id, @RequestBody Person person) {
        return personService.putPerson(id,person);
    }

    @GetMapping ("/getAll")
    public List<Person> getAllPerson() {
        return  personService.getAll();
    }

    @GetMapping ("/getOne/{id}")
    public Person getOnePerson(@PathVariable Long id) throws Exception {
        return personService.getOnePerson (id);
    }

    @GetMapping ("/getAllVoenkomat")
    public List<Person> goVoenkom() throws Exception {
        return personService.goVoenkom();
    }


}
