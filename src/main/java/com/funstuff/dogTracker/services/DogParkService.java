package com.funstuff.dogTracker.services;

import com.funstuff.dogTracker.entities.DogPark;
import com.funstuff.dogTracker.repositories.DogParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DogParkService {
    @Autowired
    private DogParkRepository dogParkRepository;
    public List<DogPark> listAllDogParks() {
        return dogParkRepository.findAll();
    }

    public void saveDogPark(DogPark dogPark) {
        dogParkRepository.save(dogPark);
    }

    public DogPark getDogPark(Integer id) {
        return dogParkRepository.findById(id).get();
    }

    public void deleteDogPark(Integer id) {
        dogParkRepository.deleteById(id);
    }
}
