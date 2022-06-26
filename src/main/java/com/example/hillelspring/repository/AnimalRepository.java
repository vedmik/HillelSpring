package com.example.hillelspring.repository;

import com.example.hillelspring.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal,Integer> {
}
