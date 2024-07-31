package com.art.arturtests.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table (name = "person_voenkomats")


public class PersonVoenkomat implements Serializable {
    @Id
    @Column (name = "voenkom_id")
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn (name = "voenkom_id")
    private Person person;



    @Column (name = "voenkom_прописка")
    private String propiska;

    @Column (name = "voenkom_служба")
    private String slugba;

    @Column (name = "voenkom_номер")
    private Long number;

    @Column (name = "voenkom_годность")
    private String godnost;

    @Column (name = "voenkom_вес")
    private Integer ves;

}
