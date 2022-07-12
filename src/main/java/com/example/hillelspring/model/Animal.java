package com.example.hillelspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "animal_id", nullable = false)
    private Integer id;

    private String nickname;

    @ManyToOne
    @JoinColumn(name="owner", nullable = false, referencedColumnName="person_id")
    @JsonIgnore
    private Person owner;
}
