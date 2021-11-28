package com.funstuff.dogTracker.services;

import com.funstuff.dogTracker.entities.DogOwner;
import com.funstuff.dogTracker.repositories.DogOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DogOwnerService {
    @Autowired
    private DogOwnerRepository dogOwnerRepository;
    public List<DogOwner> listAllDogOwners() {
        return dogOwnerRepository.findAll();
    }

    public void saveDogOwner(DogOwner dogOwner) {
        dogOwnerRepository.save(dogOwner);
    }

    public DogOwner getDogOwner(Integer id) {
        return dogOwnerRepository.findById(id).get();
    }

    public void deleteDogOwner(Integer id) {
        dogOwnerRepository.deleteById(id);
    }
}
