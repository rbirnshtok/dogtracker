package com.funstuff.dogTracker.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {
    private String firstname;
    private String lastname;
    private int age;
    @Id
    @GeneratedValue
    private Long id;


}
