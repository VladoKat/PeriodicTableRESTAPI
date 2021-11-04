package com.example.periodictableapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "element")
public class Element {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "atomic_number")
    private int atomicNumber;

    @Column(name="alternative_name")
    private String alternativeName;

    @Column(name="name")
    private String name;

    @Column(name="appearance")
    private String appearance;

    @ManyToMany
    @JoinTable(name = "element_discoverer",
            joinColumns = @JoinColumn(name = "element_atomic_number"),
            inverseJoinColumns = @JoinColumn(name = "discoverer_id"))
    private List<Discoverer> discoverers;

    public Element () {}

    public Element(int atomicNumber, String alternativeName, String name, String appearance) {
        this.atomicNumber = atomicNumber;
        this.alternativeName = alternativeName;
        this.name = name;
        this.appearance = appearance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Discoverer> getDiscoverers() {
        return discoverers;
    }

    public void setDiscoverers(List<Discoverer> discoverers) {
        this.discoverers = discoverers;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    public void setAlternativeName(String alternativeName) {
        this.alternativeName = alternativeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String toString(){
        return this.atomicNumber + " " + this.name;
    }

}
