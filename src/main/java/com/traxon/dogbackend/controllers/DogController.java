package com.traxon.dogbackend.controllers;

import com.traxon.dogbackend.models.Dog;
import com.traxon.dogbackend.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DogController {

    final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping(value = {"", "/"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dog> newDog(@Validated @RequestBody Dog dog){
        return new ResponseEntity<>(dogService.createDog(dog), HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dog>> getAllDogs(){
        return new ResponseEntity<>(dogService.retrieveDogs(), HttpStatus.OK);
    }

    @GetMapping(value = "/breed/{breed}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dog>> getAllDogByBreed(@PathVariable String breed){
        return new ResponseEntity<>(dogService.retrieveDogBreed(breed), HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dog> getDogById(@PathVariable Long id){
        return new ResponseEntity<>(dogService.retrieveDogBreedById(id), HttpStatus.OK);
    }

    @GetMapping("/names/{name}")
    public ResponseEntity<List<Dog>> getAllDogByName(@PathVariable String name){
        return new ResponseEntity<>(dogService.retrieveDogNames(name), HttpStatus.OK);
    }

    //just for trying @Query in jpa repository
    @GetMapping("/name/{name}")
    public ResponseEntity<List<String>> getAllDogNames(@PathVariable String name){
        return new ResponseEntity<>(dogService.getDogNames(name), HttpStatus.OK);
    }
}
