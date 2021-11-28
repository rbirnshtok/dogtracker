package com.funstuff.dogTracker.repositories;

import com.funstuff.dogTracker.entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {

    @Query(nativeQuery = true, value = "select *  from dog where owner_id=?1")
    List<Dog> findByOwnerId(Integer ownerId);
}
