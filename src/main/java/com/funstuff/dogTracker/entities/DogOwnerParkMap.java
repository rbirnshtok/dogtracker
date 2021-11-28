package com.funstuff.dogTracker.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class DogOwnerParkMap {
    private int id;
    private int dogOwnerId;
    private int dogParkId;
    private boolean active = true;

    public DogOwnerParkMap(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
}
