package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "Skier")

public class Skier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkier;

    private String firstName;
    private String lastName;

    @DateTimeFormat
    private Date dateOfBirth;

    private String city ;

    @OneToOne(mappedBy = "skier")
    private Subscription subscription;


    @OneToMany(mappedBy = "skier")
    private Set<Registration> registrations;


    @ManyToMany(mappedBy = "skiers")
    private Set<Piste> piste;
}

