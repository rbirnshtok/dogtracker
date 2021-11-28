package com.funstuff.dogTracker.services;

import com.funstuff.dogTracker.entities.Dog;
import com.funstuff.dogTracker.repositories.DogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DogService {
    @Autowired
    private DogRepository dogRepository;
    public List<Dog> listAllDogs() {
        return dogRepository.findAll();
    }

    public void saveDog(Dog dog) {
        dogRepository.save(dog);
    }

    public Dog getDog(Integer id) {
        return dogRepository.findById(id).get();
    }

    public List<Dog> getDogs(Integer ownerId) {
        return dogRepository.findByOwnerId(ownerId);
    }

    public void deleteDog(Integer id) {
        dogRepository.deleteById(id);
    }

}
