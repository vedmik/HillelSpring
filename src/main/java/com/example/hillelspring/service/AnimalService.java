package com.example.hillelspring.service;

import com.example.hillelspring.model.Animal;
import com.example.hillelspring.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimal(Integer id) {
        Animal animal = animalRepository.findById(id)
                .orElse(Animal.builder().build());
        return animal;
    }

    public Animal updateAnimal(Animal restAnimal) {
        Animal animal = findAnimal(restAnimal.getId());
        if(restAnimal.getNickname() != null){
        animal.setNickname(restAnimal.getNickname());
        }
        if(restAnimal.getOwner() != null){
            animal.setOwner(restAnimal.getOwner());
        }
        animalRepository.save(animal);
        return animal;
    }

    public Integer createAnimal(Animal animal,Integer id) {
        animal.setOwner(id);
        return animalRepository.save(animal).getId();
    }

    public void deleteAnimal(Integer id) {
        Animal animal = findAnimal(id);
        animalRepository.delete(animal);
    }

    private Animal findAnimal(Integer id){
        return animalRepository.findById(id).orElse(Animal.builder().build());
    }
}
