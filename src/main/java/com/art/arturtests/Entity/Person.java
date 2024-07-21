package com.art.arturtests.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

@Data
@Entity
@Table (name = "Persons")
public class Person {


    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "Имя")
    private String name;

    @Column (name = "Фамилия")
    private String secondName;

    @Column ( name = "Возрраст")
    private int age;

    @Column(name = "sex")
    private String sex;

    @OneToOne (mappedBy = "voenkom_person")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private PersonVoenkomat personVoenkomat;
}
