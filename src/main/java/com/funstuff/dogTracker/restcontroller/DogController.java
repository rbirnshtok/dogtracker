package com.funstuff.dogTracker.restcontroller;

import com.funstuff.dogTracker.entities.Dog;
//import com.funstuff.dogTracker.services.DogService;
import com.funstuff.dogTracker.repositories.DogRepository;
import com.funstuff.dogTracker.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("")
public class DogController {
    @Autowired
    DogService dogService;

    @GetMapping("/dogs/{id}")
    ResponseEntity<Dog> getDogById(@PathVariable Integer id) {
        try {
            Dog dog = dogService.getDog(id);
            return new ResponseEntity<>(dog, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Dog>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/dog")
    ResponseEntity<Dog> getDog(@RequestParam(value = "id", defaultValue="6") Integer id) {
        try {
            Dog dog = dogService.getDog(id);
            return new ResponseEntity<>(dog, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Dog>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/dogs")
    List<Dog> getDogs(@RequestParam(value = "ownerid", defaultValue="-1") Integer ownerId) {
        if(ownerId == -1)
            return dogService.listAllDogs();
        else
            return dogService.getDogs(ownerId);
    }

   /* @GetMapping("/dogs")
    List<Dog> getAllDogs() {
        return dogService.listAllDogs();
    }*/
    @PostMapping("/dog")
    @ResponseStatus(HttpStatus.OK)

    public Dog add(@RequestBody Dog dog) {
        dogService.saveDog(dog);
        return dog;
    }

/*@PutMapping("/{dogId}")
    public Dog update(@RequestBody Dog dog, @PathVariable Integer dogId) {
        try {
            dogService.saveDog(dog);
            return dog;
            //return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return null;
        }

        @DeleteMapping("/{dogId}")
    public void delete(@PathVariable Integer dogId) {
        dogService.deleteDog(dogId);
    }
    }*/



}
