package com.art.arturtests.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Имя")
    private String name;

    @Column(name = "Фамилия")
    private String secondName;

    @Column(name = "Возрраст")
    private int age;

    @Column(name = "Пол")
    private String sex;

    @Column(name = "Прописка")
    private String propiska;

    @Column(name = "Здоровье")
    private String health;

    @PrimaryKeyJoinColumn
    @OneToOne  (cascade = CascadeType.ALL, mappedBy = "person")
    private PersonVoenkomat personVoenkomat;
}
