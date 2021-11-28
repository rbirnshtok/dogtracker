package com.funstuff.dogTracker.services;

import com.funstuff.dogTracker.entities.DogOwnerParkMap;
import com.funstuff.dogTracker.repositories.DogOwnerParkMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DogOwnerParkMapService {
    @Autowired
    private DogOwnerParkMapRepository dogOwnerParkMapRepository;
    public List<DogOwnerParkMap> listAllDogOwnerParkMaps() {
        return dogOwnerParkMapRepository.findAll();
    }

    public void saveDogOwnerParkMap(DogOwnerParkMap dogOwnerParkMap) {
        dogOwnerParkMapRepository.save(dogOwnerParkMap);
    }

    public DogOwnerParkMap getDogOwnerParkMap(Integer id) {
        return dogOwnerParkMapRepository.findById(id).get();
    }

    public void deleteDogOwnerParkMap(Integer id) {
        dogOwnerParkMapRepository.deleteById(id);
    }
}
