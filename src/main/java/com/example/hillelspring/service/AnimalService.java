package com.example.hillelspring.service;

import com.example.hillelspring.model.Animal;
import com.example.hillelspring.service.lists.AnimalList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalList animalList;
    private final PersonService personService;

    @Autowired
    public AnimalService(AnimalList animalList, PersonService personService) {
        this.animalList = animalList;
        this.personService = personService;
    }

    public Animal getAnimal(Integer id) {
        Animal animal = animalList.getAnimalList().stream()
                .filter(s->s.getId().equals(id))
                .findAny()
                .orElse(Animal.builder().build());
        return animal;
    }

    public Animal updateAnimal(Animal restAnimal) {
        Animal animal = restAnimal;

        var i = animalList.getAnimalList().iterator();

        while(i.hasNext()){
            animal = i.next();
            if(animal.getId() == restAnimal.getId()){
                animal.setNickname(restAnimal.getNickname());
                break;
            }
        }

        return animal;
    }

    public Integer createAnimal(Animal animal,Integer id) {
        animal.setOwner(personService.getPerson(id));
        animalList.getAnimalList().add(animal);
        return animal.getId();
    }

    public void deleteAnimal(Integer id) {
        Animal animal = animalList.getAnimalList().stream()
                .filter(s->s.getId().equals(id))
                .findAny()
                .orElse(Animal.builder().build());
        animalList.getAnimalList().remove(animal);
    }
}
