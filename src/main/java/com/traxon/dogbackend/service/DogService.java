package com.traxon.dogbackend.service;

import com.traxon.dogbackend.models.Dog;

import java.util.List;

public interface DogService {
    public Dog createDog(Dog dog);
    public List<Dog> retrieveDogs();
    public List<Dog> retrieveDogBreed(String breed);
    public Dog retrieveDogBreedById(Long id);
    public List<Dog> retrieveDogNames(String name);
    public List<String> getDogNames(String name);
}
