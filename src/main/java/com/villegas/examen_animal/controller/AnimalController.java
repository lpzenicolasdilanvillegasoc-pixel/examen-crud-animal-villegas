
package com.villegas.examen_animal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.villegas.examen_animal.entity.Animal;
import com.villegas.examen_animal.service.AnimalService;

@RestController
@RequestMapping("/api/animales")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity<Animal> crear(
            @Valid @RequestBody Animal animal,
            @RequestHeader("X-Usuario") String usuario) {

        Animal nuevo = animalService.crear(animal, usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Animal>> listar() {
        return ResponseEntity.ok(animalService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Animal animal,
            @RequestHeader("X-Usuario") String usuario) {

        Animal actualizado = animalService.actualizar(id, animal, usuario);

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id,
            @RequestHeader("X-Usuario") String usuario) {

        animalService.eliminar(id, usuario);

        return ResponseEntity.noContent().build();
    }
}
