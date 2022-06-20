package com.example.hillelspring.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Animal {

    private Integer id;
    private String nickname;
    private Person Owner;
}
