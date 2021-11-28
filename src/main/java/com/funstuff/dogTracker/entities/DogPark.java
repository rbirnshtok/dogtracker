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
public class DogPark {
    private int parkId;
    private String parkName;
    private String address;
    private Double latitude;
    private Double longitude;
    private boolean active = true;

    public DogPark(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getParkId() {
        return parkId;
    }
}
