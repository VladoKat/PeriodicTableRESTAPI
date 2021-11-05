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
@Table(name = "discoverer")
public class Discoverer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String name;

}
