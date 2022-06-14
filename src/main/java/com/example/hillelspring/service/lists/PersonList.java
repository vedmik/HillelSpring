package com.example.hillelspring.service.lists;

import com.example.hillelspring.model.Person;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class PersonList {
    private final List<Person> personList;
}
