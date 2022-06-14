package com.example.hillelspring.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {

    private Integer id;
    private String name;
}
