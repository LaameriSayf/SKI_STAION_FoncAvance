package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "Subscription")


public class Subscription implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSub;

    private Date startDate;

    private Date endDate ;

    private Float price;
    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSubscription;
    @OneToOne
    private Skier skier;


    public Subscription() {

    }
}
