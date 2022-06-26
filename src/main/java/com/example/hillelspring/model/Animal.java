package com.example.hillelspring.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Builder
@Data
public class Animal {

    @Id
    private Integer id;
    private String nickname;
    private Integer Owner;
}
