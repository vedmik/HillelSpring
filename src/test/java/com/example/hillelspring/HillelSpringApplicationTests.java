package com.example.hillelspring;

import com.example.hillelspring.controller.AnimalController;
import com.example.hillelspring.controller.PersonController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HillelSpringApplicationTests {

    @Autowired
    private PersonController personController;

    @Autowired
    private AnimalController animalController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(personController);
        Assertions.assertNotNull(animalController);
    }

}
