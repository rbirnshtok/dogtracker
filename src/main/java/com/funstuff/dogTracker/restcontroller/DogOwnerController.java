package com.funstuff.dogTracker.restcontroller;

import com.funstuff.dogTracker.entities.DogOwner;
//import com.funstuff.dogTracker.services.DogOwnerService;
import com.funstuff.dogTracker.services.DogOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/dogowners")
public class DogOwnerController {
    @Autowired
    DogOwnerService dogOwnerService;

    @GetMapping("/{id}")
    ResponseEntity<DogOwner> getDogOwner(@PathVariable Integer id) {
        try {
            DogOwner dogOwner = dogOwnerService.getDogOwner(id);
            return new ResponseEntity<DogOwner>(dogOwner, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DogOwner>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    List<DogOwner> getAllDogOwners() {
        return dogOwnerService.listAllDogOwners();
    }

    @PostMapping("/")
    public void add(@RequestBody DogOwner dogOwner) {
        dogOwnerService.saveDogOwner(dogOwner);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DogOwner dogOwner, @PathVariable Integer id) {
        try {
            dogOwner.setId(id);
            dogOwnerService.saveDogOwner(dogOwner);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        dogOwnerService.deleteDogOwner(id);
    }
}
