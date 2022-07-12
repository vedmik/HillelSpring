package com.example.hillelspring.service;

import com.example.hillelspring.model.Person;
import com.example.hillelspring.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Integer createPerson(Person person){
        return personRepository.save(person).getId();
    }

    public Person getPerson(Integer id){
        return personRepository.findById(id).orElse(Person.builder().build());
    }

    public Person updatePerson(Person restPerson){
        Person person = findPerson(restPerson.getId());

        if(person.getId() != null){
            person.setName(restPerson.getName());
            personRepository.save(person);
        }

        return person;
    }

    public void deletePerson(Integer id){
        Person person = findPerson(id);
        personRepository.delete(person);
    }

    private Person findPerson(Integer id){
        return personRepository.findById(id).orElse(Person.builder().build());
    }
}
