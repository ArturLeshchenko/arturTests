package com.art.arturtests.controller;

import com.art.arturtests.Entity.Person;
import com.art.arturtests.Entity.PersonVoenkomat;
import com.art.arturtests.service.PersonVoenkomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/info")
public class PersonInfoController {

    private final PersonVoenkomService personVoenkomService;

    @GetMapping ("/getAll")
    public List<PersonVoenkomat> getAllPersonVoenkomat() {
        return  personVoenkomService.getAll();
    }

    @PostMapping("/{id}/propiska")
    public void setInfo (@PathVariable ("id") Long personId, @RequestBody String propiska, @RequestBody String slugba,
                         @RequestBody Long number,@RequestBody String godnost, @RequestBody Integer ves ) {
    personVoenkomService.setInfo(personId, propiska, slugba, number, godnost, ves );
    }
}

