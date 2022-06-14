package com.example.hillelspring.service.lists;

import com.example.hillelspring.model.Animal;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class AnimalList {
    private final List<Animal> animalList;
}
