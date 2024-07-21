package com.art.arturtests.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table (name = "PersonVoenkomats")


public class PersonVoenkomat implements Serializable {
    @Id
    @OneToOne
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    @JoinColumn(name = "voenkom_id", referencedColumnName = "id")
    private Person voenkom_person;

//    @Column (name = "voenkom_Имя")
//    private String name;
//
//    @Column (name = "voenkom_Фамилия")
//    private String secondName;
//
//    @Column ( name = "voenkom_Возрраст")
//    private int age;

    @Column (name = "voenkom_Прописка")
    private String propiska;

}
