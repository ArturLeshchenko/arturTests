package com.art.arturtests.controller;

import com.art.arturtests.Entity.Person;
import com.art.arturtests.Entity.PersonVoenkomat;
import com.art.arturtests.service.PersonVoenkomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/artur")
public class PersonInfoController {

    private final PersonVoenkomService personVoenkomService;

    @GetMapping ("/personVoenkom/getAll")
    public List<PersonVoenkomat> getAllPersonVoenkomat() {
        return  personVoenkomService.getAll();
    }

    @PostMapping("/personVoenkom/{id}/")
    public void setInfo(@PathVariable("id") Long personId, @RequestBody Person person) {

    }
}


