package com.funstuff.dogTracker.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateInitializer","handler"})
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dogId;
    private String dogName;
    private String breed;
    private String age;
    private String sex;
    private String color;
    private String aboutMyDog;
    private int ownerId;
    private boolean active = true;

    public Dog(String dogName, String breed, String age, String sex, String color, String aboutMyDog, int ownerId, boolean active) {
        this.dogName = dogName;
        this.breed = breed;
        this.age = age;
        this.sex = sex;
        this.color = color;
        this.aboutMyDog = aboutMyDog;
        this.ownerId = ownerId;
        this.active = active;
    }

    /*@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private Date editDate;*/

    public Dog(){
        dogName = "Rosie";
        breed = "mix";
        age = "2 years";
        sex = "female";
        color = "fawn";
        aboutMyDog = "Energetic,loves to wrestle play";
    }

}
