package com.art.arturtests.service;
import com.art.arturtests.Entity.PersonVoenkomat;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonVoenkomService {
    @Transactional
    List<PersonVoenkomat> getAll ();
    void setInfo (Long personId, String propiska, String slugba, Long number,String godnost,Integer ves);
}
