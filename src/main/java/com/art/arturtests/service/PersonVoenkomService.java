package com.art.arturtests.service;
import com.art.arturtests.Entity.Person;
import com.art.arturtests.Entity.PersonVoenkomat;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonVoenkomService {
    List<PersonVoenkomat> getAll ();
    void setInfo (Long personId, Person person);
}
