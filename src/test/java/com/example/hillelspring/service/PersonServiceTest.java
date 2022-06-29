package com.example.hillelspring.service;

import com.example.hillelspring.model.Person;
import com.example.hillelspring.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class PersonServiceTest {

    private final PersonRepository personRepository = Mockito.mock(PersonRepository.class);

    private final PersonService personService = new PersonService(personRepository);

    @Test
    void createPersonTest() {
        int expected = 12;

        Mockito.when(personRepository.save(Mockito.any()))
                .thenReturn(Person.builder()
                        .id(expected).build());

        Assertions.assertEquals(expected, personService.createPerson(Mockito.any()));
    }

    @Test
    void getPersonTest() {
        Person vasya = Person.builder().name("Vasya").id(12).build();

        Mockito.when(personRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(vasya));

        Assertions.assertEquals(vasya, personService.getPerson(Mockito.anyInt()));

        Assertions.assertNotEquals(Person.builder().name("Petya").build(),personService.getPerson(Mockito.anyInt()));
    }

    @Test
    void updatePersonTest() {
        Person petya = Person.builder().name("Petya").id(1).build();
        Person lena = Person.builder().name("Lena").id(2).build();

        Mockito.when(personRepository.findById(Mockito.any())).thenReturn(Optional.of(petya));

        Person person = personService.updatePerson(lena);

        Assertions.assertNotEquals(person,lena);
        Assertions.assertEquals(person,petya);

        Mockito.verify(personRepository).save(petya);
    }

    @Test
    void deletePersonTest() {
        Person petya = Person.builder().name("Petya").id(1).build();

        Mockito.when(personRepository.findById(Mockito.any())).thenReturn(Optional.of(petya));

        personService.deletePerson(Mockito.anyInt());

        Mockito.verify(personRepository).delete(petya);

    }
}