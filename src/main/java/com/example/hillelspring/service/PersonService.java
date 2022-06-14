package com.example.hillelspring.service;

import com.example.hillelspring.model.Person;
import com.example.hillelspring.service.lists.PersonList;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonList personList;

    public PersonService(PersonList personList) {
        this.personList = personList;
    }

    public Integer createPerson(Person person){
        personList.getPersonList().add(person);
        return person.getId();
    }

    public Person getPerson(Integer id){
        Person person = personList.getPersonList().stream()
                .filter(s->s.getId().equals(id))
                .findAny()
                .orElse(Person.builder().build());
        return person;
    }

    public Person updatePerson(Person restPerson){
        Person person = restPerson;

        var i = personList.getPersonList().iterator();

        while(i.hasNext()){
            person = i.next();
            if(person.getId() == restPerson.getId()){
                person.setName(restPerson.getName());
                break;
            }
        }

        return person;
    }

    public void deletePerson(Integer id){
        Person person = personList.getPersonList().stream()
                .filter(s->s.getId().equals(id))
                .findAny()
                .orElse(Person.builder().build());
        personList.getPersonList().remove(person);
    }
}
