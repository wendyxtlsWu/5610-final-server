package com.example.finalserverjava.repository;

import com.example.finalserverjava.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Query("SELECT pet from Pet pet WHERE (?1 IS NULL OR (pet.name = ?1))\n" +
            "AND (?2 IS NULL OR (pet.size = ?2))\n" +
            "AND ((?3) IS NULL OR (pet.age = ?3))\n" +
            "AND ((?4) IS NULL OR (pet.type = ?4))\n" +
            "AND ((?5) IS NULL OR (pet.gender = ?5))")
    public List<Pet> findPets(String name, String size, String age, String type, String gender);

}
