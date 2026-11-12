
package com.villegas.examen_animal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.villegas.examen_animal.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByEliminadoFalse();

    Optional<Animal> findByIdAndEliminadoFalse(Long id);
}
