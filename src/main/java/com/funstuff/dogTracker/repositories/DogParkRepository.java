package com.funstuff.dogTracker.repositories;

import com.funstuff.dogTracker.entities.DogPark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogParkRepository extends JpaRepository<DogPark, Integer> {
}
