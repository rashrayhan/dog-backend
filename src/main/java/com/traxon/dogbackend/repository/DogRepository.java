package com.traxon.dogbackend.repository;

import com.traxon.dogbackend.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

  List<Dog> findAllByBreed(String breed);
  List<Dog> findAllByName(String name);

  @Query("SELECT d.id, d.name FROM Dog d WHERE d.name=:name")
  List<String> findAllNames(String name);
}
