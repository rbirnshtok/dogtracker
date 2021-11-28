package com.funstuff.dogTracker.restcontroller;

import com.funstuff.dogTracker.entities.DogPark;
//import com.funstuff.dogTracker.services.DogParkService;
import com.funstuff.dogTracker.services.DogParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/dogparks")
public class DogParkController {
    @Autowired
    DogParkService dogParkService;

    @GetMapping("/{id}")
    ResponseEntity<DogPark> getDogPark(@PathVariable Integer id) {
        try {
            DogPark DogPark = dogParkService.getDogPark(id);
            return new ResponseEntity<DogPark>(new DogPark(), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DogPark>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    List<DogPark> getAllDogParks() {
        return dogParkService.listAllDogParks();
    }

    @PostMapping("/")
    public void add(@RequestBody DogPark dogPark) {
        dogParkService.saveDogPark(dogPark);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DogPark dogPark, @PathVariable Integer id) {
        try {
            dogPark.setParkId(id);
            dogParkService.saveDogPark(dogPark);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        dogParkService.deleteDogPark(id);
    }
}
