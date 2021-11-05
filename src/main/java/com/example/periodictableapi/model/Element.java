package com.example.periodictableapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "element")
public class Element {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "atomic_number", unique = true)
    private int atomicNumber;

    @Column(name="alternative_name")
    private String alternativeName;

    @Column(name="name")
    private String name;

    @Column(name="appearance")
    private String appearance;

    @Column(name="atomic_symbol", length = 3)
    private String atomicSymbol;

    @Column(name = "period")
    private int period;

    @Column(name = "el_group")
    private int group;

    @Column(name = "discovery_year")
    private String discoveryYear;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "element_discoverer",
            joinColumns = @JoinColumn(name = "element_id"),
            inverseJoinColumns = @JoinColumn(name = "discoverer_id"))
    private List<Discoverer> discoverers;


}
