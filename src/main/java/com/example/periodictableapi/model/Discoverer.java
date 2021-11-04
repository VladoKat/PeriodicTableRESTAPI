package com.example.periodictableapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "discoverer")
public class Discoverer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String name;


    @ManyToMany(mappedBy = "discoverers")
    private List<Element> elementsDiscovered;

    public Discoverer() {}

    public Discoverer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
