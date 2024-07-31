package com.art.arturtests.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

@Data
@Entity
@Table (name = "person")
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

    @PrimaryKeyJoinColumn
    @OneToOne  (cascade = CascadeType.ALL, mappedBy = "person")
    private PersonVoenkomat personVoenkomat;
}
