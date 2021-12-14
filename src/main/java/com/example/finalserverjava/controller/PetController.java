package com.example.finalserverjava.controller;

import com.example.finalserverjava.model.Pet;

import com.example.finalserverjava.model.SearchParams;
import com.example.finalserverjava.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PetController {
    @Autowired
    PetRepository repository;

    @PostMapping("/search/pets")
    public List<Pet> findPets(
            @RequestBody SearchParams searchParams
    ) {
        String name = isStringEmpty(searchParams.getName()) ? null:searchParams.getName();
        String size = isStringEmpty(searchParams.getSize()) ? null:searchParams.getSize();;
        String age = isStringEmpty(searchParams.getAge()) ? null:searchParams.getAge();
        String type = isStringEmpty(searchParams.getType()) ? null:searchParams.getType();
        String gender = isStringEmpty(searchParams.getGender()) ? null:searchParams.getGender();

        return repository.findPets(name, size, age, type, gender);
    }

    boolean isStringEmpty(String s) {
        return s == null || s.isEmpty();
    }
}



