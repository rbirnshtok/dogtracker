package com.funstuff.dogTracker.repositories;

import com.funstuff.dogTracker.entities.DogOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogOwnerRepository extends JpaRepository<DogOwner, Integer> {
}
