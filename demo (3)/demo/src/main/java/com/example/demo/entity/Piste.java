package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity@Table(name = "Piste")


public class Piste implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numPiste;

    private String namePiste;
    @Enumerated(EnumType.STRING)
    private Color color;

    private int length;
    private int slop ;

    @ManyToMany
    Set<Skier> skiers;

}
