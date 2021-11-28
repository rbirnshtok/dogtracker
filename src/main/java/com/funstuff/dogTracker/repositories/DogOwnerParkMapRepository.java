package com.funstuff.dogTracker.repositories;

import com.funstuff.dogTracker.entities.DogOwnerParkMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogOwnerParkMapRepository extends JpaRepository<DogOwnerParkMap, Integer> {
}
