package com.traxon.dogbackend.service;

import com.traxon.dogbackend.exceptions.DogNotFoundException;
import com.traxon.dogbackend.models.Dog;
import com.traxon.dogbackend.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    DogRepository dogRepository;

    @Autowired
    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public Dog createDog(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public List<Dog> retrieveDogs() {
        Optional<List<Dog>> dogs = Optional.of(dogRepository.findAll());
        return dogs.orElseThrow(DogNotFoundException::new);
    }

    @Override
    public List<Dog> retrieveDogBreed(String breed) {
        Optional<List<Dog>> dogs = Optional.of(dogRepository.findAllByBreed(breed));
        return dogs.orElseThrow(DogNotFoundException::new);
    }

    @Override
    public Dog retrieveDogBreedById(Long id) {
        return dogRepository.findById(id).orElseThrow(DogNotFoundException::new);
    }

    @Override
    public List<Dog> retrieveDogNames(String name) {
        Optional<List<Dog>> dogs = Optional.of(dogRepository.findAllByName(name));
        return dogs.orElse(null);
    }

    @Override
    public List<String> getDogNames(String name) {
        Optional<List<String>> dogNames = Optional.of(dogRepository.findAllNames(name));
        return dogNames.orElse(null);
    }
}
