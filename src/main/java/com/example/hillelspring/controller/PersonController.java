package com.example.hillelspring.controller;

import com.example.hillelspring.model.Person;
import com.example.hillelspring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    @Cacheable(value = "person_id")
    public @ResponseBody Person getPerson(@PathVariable Integer id){
        return  personService.getPerson(id);
    }

    @PostMapping(produces = "application/json")
    public @ResponseBody Person updatePerson(@RequestBody Person person){ return personService.updatePerson(person); }

    @PutMapping(produces = "application/json")
    public @ResponseBody Integer createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody void deletePerson(@PathVariable Integer id){
        personService.deletePerson(id);
    }
}
