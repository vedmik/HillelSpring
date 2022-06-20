package com.example.hillelspring.controller;

import com.example.hillelspring.model.Animal;
import com.example.hillelspring.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping(value = "/{id}")
    public @ResponseBody Animal getAnimal(@PathVariable Integer id){
        return  animalService.getAnimal(id);
    }

    @PostMapping(produces = "application/json")
    public @ResponseBody Animal updateAnimal(@RequestBody Animal animal){ return animalService.updateAnimal(animal); }

    @PutMapping(value = "/person{id}",produces = "application/json")
    public @ResponseBody Integer createAnimal(@RequestBody Animal animal, @PathVariable Integer id){ return animalService.createAnimal(animal, id); }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody void deleteAnimal(@PathVariable Integer id){
        animalService.deleteAnimal(id);
    }

}
