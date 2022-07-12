package com.example.hillelspring.service;

import com.example.hillelspring.model.Animal;
import com.example.hillelspring.model.Person;
import com.example.hillelspring.repository.AnimalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class AnimalServiceTest {

    private final AnimalRepository animalRepository = Mockito.mock(AnimalRepository.class);

    private PersonService personService = Mockito.mock(PersonService.class);
    private final AnimalService animalService = new AnimalService(animalRepository, personService);

    @Test
    void getAnimalTest() {
        Animal pushok = Animal.builder().id(13).nickname("Pushok").build();

        Mockito.when(animalRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(pushok));

        Assertions.assertEquals(pushok, animalService.getAnimal(Mockito.anyInt()));
    }

    @Test
    void updateAnimalTest() {
        Animal pushok = Animal.builder().id(13).nickname("Pushok").build();
        Animal bobik = Animal.builder().id(11).nickname("Bobik").build();

        Mockito.when(animalRepository.findById(Mockito.any())).thenReturn(Optional.of(pushok));

        Animal animal = animalService.updateAnimal(bobik);

        Assertions.assertNotEquals(animal,bobik);
        Assertions.assertEquals(animal,pushok);

        Mockito.verify(animalRepository).save(pushok);
    }

    @Test
    void createAnimalTest() {
        Animal pushok = Animal.builder().id(1).build();
        Person andrii = Person.builder().id(2).build();

        Mockito.when(animalRepository.save(Mockito.any())).thenReturn(pushok);
        Mockito.when(personService.getPerson(Mockito.anyInt())).thenReturn(andrii);

        Assertions.assertEquals(1, animalService.createAnimal(Animal.builder().build(), Mockito.anyInt()));
    }

    @Test
    void deleteAnimalTest() {
        Animal pushok = Animal.builder().id(13).nickname("Pushok").build();

        Mockito.when(animalRepository.findById(Mockito.any())).thenReturn(Optional.of(pushok));

        animalService.deleteAnimal(Mockito.anyInt());

        Mockito.verify(animalRepository).delete(pushok);
    }
}